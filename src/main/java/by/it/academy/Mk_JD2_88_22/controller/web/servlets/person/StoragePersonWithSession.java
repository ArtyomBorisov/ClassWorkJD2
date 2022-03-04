package by.it.academy.Mk_JD2_88_22.controller.web.servlets.person;

import by.it.academy.Mk_JD2_88_22.controller.web.servlets.person.api.IStoragePersonService;
import by.it.academy.Mk_JD2_88_22.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StoragePersonWithSession implements IStoragePersonService {

    private static final String PERSON_KEY_NAME = "person";

    @Override
    public void saveAtStorage(HttpServletRequest req, HttpServletResponse resp, Person person) {
        HttpSession session = req.getSession();

        if (person != null) {
            session.setAttribute(PERSON_KEY_NAME, person);
        } else {
            throw new IllegalArgumentException("Не передан пользователь.");
        }
    }

    @Override
    public Person getFromStorage(HttpServletRequest req) {
        HttpSession session = req.getSession();

        return (Person) session.getAttribute(PERSON_KEY_NAME);
    }
}
