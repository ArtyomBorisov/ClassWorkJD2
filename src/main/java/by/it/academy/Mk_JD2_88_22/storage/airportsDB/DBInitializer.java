package by.it.academy.Mk_JD2_88_22.storage.airportsDB;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DBInitializer {
    private volatile static DBInitializer instance;

    private ComboPooledDataSource cpds;

    private DBInitializer() throws PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5433/demo?ApplicationName=DemoDB");
        cpds.setUser("postgres");
        cpds.setPassword("postgres");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public DataSource getDataSource() {
        return cpds;
    }

    public static DBInitializer getInstance() {
        if(instance == null){
            synchronized (DBInitializer.class){
                if(instance == null){
                    try {
                        instance = new DBInitializer();
                    } catch (Exception e) {
                        throw new RuntimeException("Ошибка подключения к базе", e);
                    }
                }
            }
        }
        return instance;
    }
}
