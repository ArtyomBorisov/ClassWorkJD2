package by.it.academy.Mk_JD2_88_22.controller.web.servlets.airportsDB;

import by.it.academy.Mk_JD2_88_22.view.airportsDB.AirportService;
import by.it.academy.Mk_JD2_88_22.view.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchFlightsServlet", urlPatterns = "/search_flights")
public class SearchFlightsServlet extends HttpServlet {

    private IAirportService airportService;

    public SearchFlightsServlet() {
        this.airportService = AirportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("airports", airportService.getAirportCode());

        req.getRequestDispatcher("views/search_flights.jsp").forward(req, resp);
    }
}
