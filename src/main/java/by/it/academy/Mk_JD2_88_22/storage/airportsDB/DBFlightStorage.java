package by.it.academy.Mk_JD2_88_22.storage.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.FlightFilter;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Pageable;
import by.it.academy.Mk_JD2_88_22.storage.api.IFlightStorage;

import javax.sql.DataSource;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DBFlightStorage implements IFlightStorage {

    private static DBFlightStorage instance = new DBFlightStorage();
    private final DataSource dataSource;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    private DBFlightStorage() {
        dataSource = DBInitializer.getInstance().getDataSource();
    }

    @Override
    public List<Flight> get() {
        return get(null, null);
    }

    @Override
    public List<Flight> get(FlightFilter filter) {
        return get(filter, null);
    }

    @Override
    public List<Flight> get(Pageable pageable) {
        return get(null, pageable);
    }

    @Override
    public List<Flight> get(FlightFilter filter, Pageable pageable) {
        Integer limit = null;
        Integer offset = null;

        if (pageable != null) {
            if (pageable.getSize() > 0) {
                limit = pageable.getSize();
            }

            if (limit != null && pageable.getPage() > 0) {
                offset = (pageable.getPage() - 1) * limit;
            }
        }

        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT\n" +
                "    flight_id,\n" +
                "    flight_no,\n" +
                "    scheduled_departure,\n" +
                "    scheduled_arrival,\n" +
                "    departure_airport,\n" +
                "    arrival_airport,\n" +
                "    status,\n" +
                "    aircraft_code,\n" +
                "    actual_departure,\n" +
                "    actual_arrival\n" +
                "FROM\n" +
                "    bookings.flights";

        List<Object> params = new ArrayList<>();

        if (filter != null) {
            String where = "";
            if (filter.getFlightId() != 0) {
                where += "flight_id = ?";
                params.add(filter.getFlightId());
            }
            if (filter.getFlightNum() != null && !filter.getFlightNum().isEmpty()) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "flight_no = ?";
                params.add(filter.getFlightNum());
            }
            if (filter.getDayScheduleDepart() != null) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "date_trunc('day', scheduled_departure) = ?";
                params.add(filter.getDayScheduleDepart());
            }
            if (filter.getDayScheduleArrival() != null) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "date_trunc('day', scheduled_arrival) = ?";
                params.add(filter.getDayScheduleArrival());
            }
            if (filter.getCodeAirDepart() != null && !filter.getCodeAirDepart().isEmpty()) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "departure_airport = ?";
                params.add(filter.getCodeAirDepart());
            }
            if (filter.getStatus() != null && !filter.getStatus().isEmpty()) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "status = ?";
                params.add(filter.getStatus());
            }
            if (filter.getCodeAirArrival() != null && !filter.getCodeAirArrival().isEmpty()) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "arrival_airport = ?";
                params.add(filter.getCodeAirArrival());
            }
            if (filter.getAircraftCode() != null && !filter.getAircraftCode().isEmpty()) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "aircraft_code = ?";
                params.add(filter.getAircraftCode());
            }
            if (filter.getDayActualDepart() != null) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "date_trunc('day', actual_departure) = ?";
                params.add(filter.getDayActualDepart());
            }
            if (filter.getDayActualArrival() != null) {
                if (!where.isEmpty()) {
                    where += "AND ";
                }
                where += "date_trunc('day', actual_arrival) = ?";
                params.add(filter.getDayActualArrival());
            }
            if (!where.isEmpty()) {
                sql += "\n WHERE " + where;
            }
        }
        if (limit != null) {
            sql += "\n LIMIT " + limit;
        }
        if (offset != null) {
            sql += "\n OFFSET " + offset;
        }
        sql += ";";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            int index = 1;
            for (Object param : params) {
                ps.setObject(index++, param);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightId(rs.getInt(1));
                    flight.setFlightNum(rs.getString(2));

                    String timeScheduleDepartRaw = rs.getString(3);
                    if (!rs.wasNull()) {
                        flight.setTimeScheduleDepart(ZonedDateTime.parse(timeScheduleDepartRaw, this.formatter));
                    }

                    String timeScheduleArrivalRaw = rs.getString(4);
                    if (!rs.wasNull()) {
                        flight.setTimeScheduleArrival(ZonedDateTime.parse(timeScheduleArrivalRaw, this.formatter));
                    }

                    flight.setCodeAirDepart(rs.getString(5));
                    flight.setCodeAirArrival(rs.getString(6));
                    flight.setStatus(rs.getString(7));
                    flight.setAircraftCode(rs.getString(8));

                    String timeActualDepartRaw = rs.getString(9);
                    if (!rs.wasNull()) {
                        flight.setTimeActualDepart(ZonedDateTime.parse(timeActualDepartRaw, this.formatter));
                    }

                    String timeActualArrivalRaw = rs.getString(10);
                    if (!rs.wasNull()) {
                        flight.setTimeActualArrival(ZonedDateTime.parse(timeActualArrivalRaw, this.formatter));
                    }
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнения SQL", e);
        } catch (DateTimeParseException e) {
            throw new IllegalStateException("Невозможно прочитать дату и время из базы данных", e);
        }

        return flights;
    }

    public static DBFlightStorage getInstance() {
        return instance;
    }
}
