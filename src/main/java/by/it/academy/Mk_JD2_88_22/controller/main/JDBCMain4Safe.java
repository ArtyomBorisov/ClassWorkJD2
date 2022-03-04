package by.it.academy.Mk_JD2_88_22.controller.main;

import java.sql.*;
import java.time.LocalDate;

public class JDBCMain4Safe {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=Messenger",
                "postgres", "postgres");
             PreparedStatement statement = conn.prepareStatement(
                     "INSERT INTO app.users (login, password, date_reg, fio, birthday) " +
                             "VALUES (?, ?, now(), ?, ?)");
        ) {
            statement.setString(1, "us11");
            statement.setString(2, "p22");
            statement.setString(3, "tom");
            statement.setObject(4, LocalDate.parse("2010-01-01"));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL " + e.getMessage());
        }
    }
}
