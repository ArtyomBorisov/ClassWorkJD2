package by.it.academy.Mk_JD2_88_22.view.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;
import by.it.academy.Mk_JD2_88_22.storage.airportsDB.DBAirportStorage;
import by.it.academy.Mk_JD2_88_22.storage.api.IAirportStorage;
import by.it.academy.Mk_JD2_88_22.view.api.IAirportService;

import java.util.List;

public class AirportService implements IAirportService {

    private final static AirportService instance = new AirportService();
    private IAirportStorage storage;

    private AirportService() {
        this.storage = DBAirportStorage.getInstance();
    }

    @Override
    public List<Airport> get(int page, int size) {
        return storage.get(page, size);
    }

    @Override
    public List<String> getAirportCode() {
        return storage.getAirportCode();
    }

    public static AirportService getInstance() {
        return instance;
    }
}
