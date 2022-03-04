package by.it.academy.Mk_JD2_88_22.storage.json;

import by.it.academy.Mk_JD2_88_22.storage.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.model.Citizen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorageCitizenService implements IStorageService<Citizen> {

    private final List<Citizen> list;
    private static final StorageCitizenService instance = new StorageCitizenService();

    private StorageCitizenService() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Citizen> getStorage() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void addToStorage(Citizen item) {
        list.add(item);
    }

    public static StorageCitizenService getInstance() {
        return instance;
    }
}
