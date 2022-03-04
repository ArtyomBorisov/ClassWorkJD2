package by.it.academy.Mk_JD2_88_22.controller.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class JDBCMain3Unsafe {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
            return;
        }
//INSERT INTO app.users (login, password, date_reg, fio, birthday) VALUES (user, 'pass1', now(), 'Артём', '1995-05-17')
        String login = "us666', 'pass12', now(), 'Артём', '1995-05-10'); INSERT INTO app.users (login, password, date_reg, fio, birthday) VALUES ('us999";
        String password = "p2";
        String fio = "gg";
        LocalDate date = LocalDate.parse("1995-05-17");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/messenger?ApplicationName=Messenger",
                "postgres", "postgres");
             Statement statement = conn.createStatement();
        ) {
            statement.execute("INSERT INTO app.users (login, password, date_reg, fio, birthday) " +
                    "VALUES ('" + login + "', '" + password + "', now(), '" + fio +
                    "', '" + date + "')");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL " + e.getMessage());
        }
    }
}
