package by.it.academy.Mk_JD2_88_22.controller.web.servlets.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldWithNameServletSession", urlPatterns = "/test/hello_with_name_session")
public class HelloWorldWithNameServletSession extends HttpServlet {

    private static final String FIRST_NAME_KEY_NAME = "firstName";
    private static final String LAST_NAME_KEY_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String firstName = req.getParameter(FIRST_NAME_KEY_NAME);
        String lastName = req.getParameter(LAST_NAME_KEY_NAME);

        HttpSession session = req.getSession();

        if(firstName == null){
            firstName = (String) session.getAttribute(FIRST_NAME_KEY_NAME);
            if(firstName == null){
                throw new IllegalArgumentException("Не передан обязательный параметр");
            }
        } else {
            session.setAttribute(FIRST_NAME_KEY_NAME, firstName);
        }

        if(lastName == null){
            lastName = (String) session.getAttribute(LAST_NAME_KEY_NAME);
            if(lastName == null){
                throw new IllegalArgumentException("Не передан обязательный параметр");
            }
        } else {
            session.setAttribute(LAST_NAME_KEY_NAME, lastName);
        }
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + firstName + " " + lastName);
    }

}
