package by.it.academy.Mk_JD2_88_22.view.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.FlightFilter;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Pageable;
import by.it.academy.Mk_JD2_88_22.storage.airportsDB.DBFlightStorage;
import by.it.academy.Mk_JD2_88_22.storage.api.IFlightStorage;
import by.it.academy.Mk_JD2_88_22.view.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {

    private static final FlightService instance = new FlightService();
    private IFlightStorage storage;

    private FlightService() {
        this.storage = DBFlightStorage.getInstance();
    }

    @Override
    public List<Flight> get() {
        return storage.get();
    }

    @Override
    public List<Flight> get(FlightFilter filter) {
        return storage.get(filter);
    }

    @Override
    public List<Flight> get(Pageable pageable) {
        return storage.get(pageable);
    }

    @Override
    public List<Flight> get(FlightFilter filter, Pageable pageable) {
        return storage.get(filter, pageable);
    }

    public static FlightService getInstance() {
        return instance;
    }
}
