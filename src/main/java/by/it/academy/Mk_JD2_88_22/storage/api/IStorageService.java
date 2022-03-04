package by.it.academy.Mk_JD2_88_22.storage.api;

import java.util.List;

public interface IStorageService<T> {
    List<T> getStorage();

    void addToStorage(T item);
}
