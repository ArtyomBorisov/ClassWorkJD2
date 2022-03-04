package by.it.academy.Mk_JD2_88_22.controller.web.servlets.person;

import by.it.academy.Mk_JD2_88_22.controller.web.servlets.person.api.IStoragePersonService;
import by.it.academy.Mk_JD2_88_22.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private static final String STORAGE_NAME = "storage";
    private static final String STORAGE_NAME_1 = "cookie";
    private static final String STORAGE_NAME_2 = "session";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String storage = req.getHeader(STORAGE_NAME);

        if(storage == null){
            throw new IllegalArgumentException("Не передан Header.");
        }

        IStoragePersonService iPersonService = null;

        if(storage.equals(STORAGE_NAME_1)){
            iPersonService = new StoragePersonWithCookie();
        } else if (storage.equals(STORAGE_NAME_2)){
            iPersonService = new StoragePersonWithSession();
        } else {
            throw new IllegalArgumentException("Передан неверный Header.");
        }

        Person personFromStorage = iPersonService.getFromStorage(req);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if(personFromStorage != null) {
            writer.write(personFromStorage.toString());
            return;
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Переданы неверные параметры.");
        }

        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Переданы неверные параметры.");
        }

        iPersonService.saveAtStorage(req, resp, new Person(firstName, lastName, age));

        writer.write(iPersonService.getFromStorage(req).toString());
    }
}
