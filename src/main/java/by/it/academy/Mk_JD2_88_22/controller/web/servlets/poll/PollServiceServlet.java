package by.it.academy.Mk_JD2_88_22.controller.web.servlets.poll;

import by.it.academy.Mk_JD2_88_22.view.poll.PollService;
import by.it.academy.Mk_JD2_88_22.view.poll.ValidationPoll;
import by.it.academy.Mk_JD2_88_22.view.api.IPollService;
import by.it.academy.Mk_JD2_88_22.model.Poll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PoolServiceServlet", urlPatterns = "/poll")
public class PollServiceServlet extends HttpServlet {
    private String GENRE_PARAMETER = "genre";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        IPollService service = PollService.getInstance();
        PrintWriter writer = resp.getWriter();

        if (!new ValidationPoll().validate(req)) {
            writer.write("Ваш голос НЕ учтён! Ошибка в заполнении!");
            return;
        }

        int artist = Integer.parseInt(req.getParameter("artist"));

        String[] genresString = req.getParameterMap().get(GENRE_PARAMETER);
        int[] genres = new int[genresString.length];

        for (int i = 0; i < genresString.length; i++) {
            genres[i] = Integer.parseInt(genresString[i]);
        }

        String about = req.getParameter("about");

        service.createPoll(new Poll(artist, genres, about));

        writer.write("Ваш голос учтён!");
    }
}
