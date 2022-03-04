package by.it.academy.Mk_JD2_88_22.controller.web.servlets.poll;

import by.it.academy.Mk_JD2_88_22.view.poll.PollService;
import by.it.academy.Mk_JD2_88_22.view.api.IPollService;
import by.it.academy.Mk_JD2_88_22.model.SavedPoll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "TopAboutServlet", urlPatterns = "/top_about")
public class TopAboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        IPollService service = PollService.getInstance();
        PrintWriter writer = resp.getWriter();
        List<SavedPoll> savedPolls = new ArrayList<>(service.getPolls());

        if (savedPolls.isEmpty()) {
            writer.write("Голосов еще нет.");
            return;
        }

        Collections.sort(savedPolls, (SavedPoll s1, SavedPoll s2) -> s2.getTime().compareTo(s1.getTime()));

        savedPolls.forEach(temp -> writer.write("<p>Время: " +
                temp.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ". О себе: " +
                temp.getPool().getAbout() + "</p>"));
    }
}
