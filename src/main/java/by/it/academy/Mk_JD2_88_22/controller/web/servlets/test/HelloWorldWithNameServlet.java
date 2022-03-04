package by.it.academy.Mk_JD2_88_22.controller.web.servlets.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "HelloWorldWithNameServlet", urlPatterns = "/test/hello_with_name")
public class HelloWorldWithNameServlet extends HttpServlet {

    private static final String FIRST_NAME_KEY_NAME = "firstName";
    private static final String LAST_NAME_KEY_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String firstName = req.getParameter(FIRST_NAME_KEY_NAME);
        String lastName = req.getParameter(LAST_NAME_KEY_NAME);

        if(firstName == null){
            firstName = getValueFormCookies(FIRST_NAME_KEY_NAME, req);
            if(firstName == null){
                throw new IllegalArgumentException("Не передан обязательный параметр");
            }
        } else {
            saveCookies(FIRST_NAME_KEY_NAME, firstName, resp);
        }

        if(lastName == null){
            lastName = getValueFormCookies(LAST_NAME_KEY_NAME, req);
            if(lastName == null){
                throw new IllegalArgumentException("Не передан обязательный параметр");
            }
        } else {
            saveCookies(LAST_NAME_KEY_NAME, lastName, resp);
        }
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + firstName + " " + lastName);
    }

    private String getValueFormCookies(String cookiesName, HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookiesName.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private void saveCookies(String cookiesName, String value, HttpServletResponse resp){
        Cookie cookie = new Cookie(cookiesName, URLEncoder.encode(value, StandardCharsets.UTF_8));
        cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        resp.addCookie(cookie);
    }
}
