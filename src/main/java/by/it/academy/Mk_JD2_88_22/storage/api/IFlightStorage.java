package by.it.academy.Mk_JD2_88_22.storage.api;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;

import java.util.List;

public interface IFlightStorage {
    List<Flight> get(int count);
}
