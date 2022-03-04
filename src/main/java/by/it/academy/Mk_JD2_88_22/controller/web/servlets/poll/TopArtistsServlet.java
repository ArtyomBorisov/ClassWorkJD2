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
import java.util.*;

@WebServlet(name = "TopArtistsServlet", urlPatterns = "/top_artists")
public class TopArtistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        IPollService service = PollService.getInstance();
        PrintWriter writer = resp.getWriter();
        List<SavedPoll> savedPolls = service.getPolls();

        if (savedPolls.isEmpty()) {
            writer.write("Голосов еще нет.");
            return;
        }

        List<Integer> artistsFromPools = new ArrayList<>();

        for (SavedPoll savedPoll : savedPolls) {
            artistsFromPools.add(savedPoll.getPool().getArtist());
        }

        Map<String, Integer> artistsHashMap = new HashMap<>();

        for (int i = 0; i < service.getArtists().size(); i++) {
            artistsHashMap.put(service.getArtists().get(i), Collections.frequency(artistsFromPools, i + 1));
        }

        artistsHashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(temp -> writer.write("<p>" + temp.getKey() + " " + temp.getValue() + "</p>"));
    }
}
