package by.it.academy.Mk_JD2_88_22.storage.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.NameLang;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Point;
import by.it.academy.Mk_JD2_88_22.storage.api.IAirportStorage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAirportStorage implements IAirportStorage {

    private static DBAirportStorage instance = new DBAirportStorage();
    private final ObjectMapper mapper = new ObjectMapper();
    private final DataSource dataSource;

    private DBAirportStorage() {
        dataSource = DBInitializer.getInstance().getDataSource();
    }

    @Override
    public List<Airport> get(int page, int size) {
        int limit = size;
        int offset = (page - 1) * limit;

        List<Airport> airports = new ArrayList<>();
        String sql = "SELECT\n" +
                "    airport_code,\n" +
                "    airport_name,\n" +
                "    city,\n" +
                "    coordinates,\n" +
                "    timezone\n" +
                "FROM\n" +
                "    bookings.airports_data ";

        if (limit > 0) {
            sql += "\n LIMIT " + limit;
        }
        if (offset > 0) {
            sql += "\n OFFSET " + offset;
        }
        sql += ";";

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql))
        {
            while (rs.next()){
                Airport airport = new Airport();
                airport.setAirportCode(rs.getString(1));

                String airportName = rs.getString(2);
                if(!rs.wasNull()){
                    airport.setAirportName(mapper.readValue(airportName, NameLang.class));
                }

                String city = rs.getString(3);
                if(!rs.wasNull()){
                    airport.setCity(mapper.readValue(city, NameLang.class));
                }

                String coordinateRaw = rs.getString(4);
                if(!rs.wasNull()){
                    String[] split = coordinateRaw.replaceAll("(\\(|\\))", "").split(",");
                    airport.setCoordinates(new Point(split[0], split[1]));
                }

                airport.setTimezone(rs.getString(5));

                airports.add(airport);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнения SQL", e);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Невозможно преобразовать json из базы", e);
        }

        return airports;
    }

    public static DBAirportStorage getInstance() {
        return instance;
    }
}
