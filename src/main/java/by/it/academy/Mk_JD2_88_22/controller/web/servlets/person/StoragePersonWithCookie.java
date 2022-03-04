package by.it.academy.Mk_JD2_88_22.controller.web.servlets.person;

import by.it.academy.Mk_JD2_88_22.controller.web.servlets.person.api.IStoragePersonService;
import by.it.academy.Mk_JD2_88_22.model.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class StoragePersonWithCookie implements IStoragePersonService {

    private static final String PERSON_KEY_NAME = "person";
    private static final String DELIMITER = ":";

    @Override
    public void saveAtStorage(HttpServletRequest req, HttpServletResponse resp, Person person) {

        if (person != null) {
            String valueCookie = person.getFirstName() + DELIMITER + person.getLastName() + DELIMITER + person.getAge();
            Cookie cookie = new Cookie(PERSON_KEY_NAME, URLEncoder.encode(valueCookie, StandardCharsets.UTF_8));
            cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(cookie);
        } else {
            throw new IllegalArgumentException("Не передан пользователь.");
        }
    }

    @Override
    public Person getFromStorage(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (PERSON_KEY_NAME.equals(cookie.getName())){
                    String valueCookie = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                    String[] temp = valueCookie.split(DELIMITER);
                    return new Person(temp[0], temp[1], Integer.parseInt(temp[2]));
                }
            }
        }

        return null;
    }
}
