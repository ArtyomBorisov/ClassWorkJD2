package by.it.academy.Mk_JD2_88_22.controller.main;

import java.sql.*;

public class JDBCMain2Unsafe {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=Messenger", "postgres", "postgres");
             Statement statement = conn.createStatement();
        ) {
            statement.execute("INSERT INTO app.users (login, password, date_reg, fio, birthday) " +
                    "VALUES ('user2222', 'pass1', now(), 'Артём', '1995-05-17')");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL " + e.getMessage());
        }
    }
}
