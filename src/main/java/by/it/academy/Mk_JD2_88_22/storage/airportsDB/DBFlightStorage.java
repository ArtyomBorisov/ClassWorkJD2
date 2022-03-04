package by.it.academy.Mk_JD2_88_22.storage.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.storage.api.IFlightStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBFlightStorage implements IFlightStorage {

    private static DBFlightStorage instance = new DBFlightStorage();
    private final ObjectMapper mapper = new ObjectMapper();

    private DBFlightStorage() {
        DBInitializer.getInstance();
    }

    @Override
    public List<Flight> get(int count) {
        List<Flight> flights = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/demo?ApplicationName=Messenger",
                "postgres", "postgres");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT\n" +
                     "    departure_airport,\n" +
                     "    arrival_airport,\n" +
                     "    scheduled_departure\n" +
                     "FROM\n" +
                     "    bookings.flights\n" +
                     "LIMIT " + count))
        {
            while (rs.next()){
                Flight flight = new Flight();
                flight.setCodeAirDepart(rs.getString(1));
                flight.setCodeAirArrival(rs.getString(2));

                String timeRaw = rs.getString(3);
                if(!rs.wasNull()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");
                    ZonedDateTime time = ZonedDateTime.parse(timeRaw, formatter);
                    flight.setTimeSchedDepart(time);
                }

                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнения SQL", e);
        }

        return flights;
    }

    public static DBFlightStorage getInstance() {
        return instance;
    }
}
