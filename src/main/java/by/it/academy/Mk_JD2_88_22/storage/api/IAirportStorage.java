package by.it.academy.Mk_JD2_88_22.storage.api;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;

import java.util.List;

public interface IAirportStorage {
    List<Airport> get(int count);
}
