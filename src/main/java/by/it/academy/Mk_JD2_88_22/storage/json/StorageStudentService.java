package by.it.academy.Mk_JD2_88_22.storage.json;

import by.it.academy.Mk_JD2_88_22.storage.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorageStudentService implements IStorageService<Student> {

    private final List<Student> list;
    private static final StorageStudentService instance = new StorageStudentService();

    private StorageStudentService() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Student> getStorage() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void addToStorage(Student item) {
        list.add(item);
    }

    public static StorageStudentService getInstance() {
        return instance;
    }
}
