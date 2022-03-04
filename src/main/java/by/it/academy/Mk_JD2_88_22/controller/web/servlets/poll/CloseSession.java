package by.it.academy.Mk_JD2_88_22.controller.web.servlets.poll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CloseSession", urlPatterns = "/close_session")
public class CloseSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);

        if (session != null) {
            session.invalidate();
            writer.write("Сессия уничтожена");
        } else {
            writer.write("Сессии не существовало");
        }


    }
}
