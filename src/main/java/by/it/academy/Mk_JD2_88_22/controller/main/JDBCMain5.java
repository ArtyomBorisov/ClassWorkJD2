package by.it.academy.Mk_JD2_88_22.controller.main;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;
import by.it.academy.Mk_JD2_88_22.storage.airportsDB.DBAirportStorage;
import by.it.academy.Mk_JD2_88_22.storage.api.IAirportStorage;

import java.util.List;

public class JDBCMain5 {
    public static void main(String[] args) {
        IAirportStorage storage = DBAirportStorage.getInstance();

        List<Airport> list = storage.get(1);

        System.out.println(list);
    }
}
