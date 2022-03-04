package by.it.academy.Mk_JD2_88_22.storage.airportsDB;

public class DBInitializer {
    private volatile static DBInitializer instance;

    public DBInitializer() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Проблемы с загрузкой драйвера");
        }
    }

    public static DBInitializer getInstance() {
        if(instance == null){
            synchronized (DBInitializer.class){
                if(instance == null){
                    instance = new DBInitializer();
                }
            }
        }
        return instance;

    }
}
