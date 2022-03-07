package by.it.academy.Mk_JD2_88_22.view.api;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.FlightFilter;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Pageable;

import java.util.List;

public interface IFlightService {
    List<Flight> get();

    List<Flight> get(FlightFilter filter);

    List<Flight> get(Pageable pageable);

    List<Flight> get(FlightFilter filter, Pageable pageable);
}
