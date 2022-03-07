package by.it.academy.Mk_JD2_88_22.controller.main;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.FlightFilter;

import java.sql.*;

public class JDBCMain {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/demo?ApplicationName=Test", "postgres", "postgres");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM bookings.flights");
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("flight_no"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL " + e.getMessage());
        }
    }
}
