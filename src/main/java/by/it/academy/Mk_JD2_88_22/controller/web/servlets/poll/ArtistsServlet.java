package by.it.academy.Mk_JD2_88_22.controller.web.servlets.poll;

import by.it.academy.Mk_JD2_88_22.view.poll.PollService;
import by.it.academy.Mk_JD2_88_22.view.api.IPollService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ArtistsServlet", urlPatterns = "/show_artists")
public class ArtistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        IPollService service = PollService.getInstance();
        PrintWriter writer = resp.getWriter();

        for (int i = 0; i < service.getArtists().size(); i++) {
            writer.write("<p>" + (i + 1) + ". " + service.getArtists().get(i) + "</p>");
        }
    }
}
