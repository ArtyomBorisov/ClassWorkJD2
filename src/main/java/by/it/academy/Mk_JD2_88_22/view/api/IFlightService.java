package by.it.academy.Mk_JD2_88_22.view.api;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> get(int count);
}
