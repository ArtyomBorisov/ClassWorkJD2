package by.it.academy.Mk_JD2_88_22.controller.web.servlets.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Airport;
import by.it.academy.Mk_JD2_88_22.view.airportsDB.AirportService;
import by.it.academy.Mk_JD2_88_22.view.api.IAirportService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private IAirportService airportService;
    private ObjectMapper mapper;

    public AirportsServlet() {
        this.airportService = AirportService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        int count = Integer.parseInt(req.getParameter("count"));

        List<Airport> airports = airportService.get(count);

        writer.write(mapper.writeValueAsString(airports));
    }
}
