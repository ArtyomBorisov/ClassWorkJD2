package by.it.academy.Mk_JD2_88_22.controller.web.servlets.person.api;

import by.it.academy.Mk_JD2_88_22.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStoragePersonService {
    void saveAtStorage(HttpServletRequest req, HttpServletResponse resp, Person person);

    Person getFromStorage(HttpServletRequest req);
}
