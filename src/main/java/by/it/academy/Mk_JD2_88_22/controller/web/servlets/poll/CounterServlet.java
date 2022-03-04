package by.it.academy.Mk_JD2_88_22.controller.web.servlets.poll;

import by.it.academy.Mk_JD2_88_22.view.Counter;
import by.it.academy.Mk_JD2_88_22.view.api.ICounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        ICounter iCounter = Counter.getInstance();
        PrintWriter writer = resp.getWriter();

        writer.write("Количество активных сессий - " + iCounter.getCount());
    }
}
