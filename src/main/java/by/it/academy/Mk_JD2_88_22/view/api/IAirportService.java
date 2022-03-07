package by.it.academy.Mk_JD2_88_22.view.api;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;

import java.util.List;

public interface IAirportService {
    List<Airport> get(int page, int size);
}
