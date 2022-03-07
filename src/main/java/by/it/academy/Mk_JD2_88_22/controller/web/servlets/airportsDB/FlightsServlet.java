package by.it.academy.Mk_JD2_88_22.controller.web.servlets.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.FlightFilter;
import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Pageable;
import by.it.academy.Mk_JD2_88_22.view.airportsDB.FlightService;
import by.it.academy.Mk_JD2_88_22.view.api.IFlightService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {

    private IFlightService flightService;
    private ObjectMapper mapper;

    public FlightsServlet() {
        this.flightService = FlightService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        int page;
        String pageRaw = req.getParameter("page");
        if (pageRaw == null || pageRaw.isEmpty()) {
            page = 1;
        } else {
            page = Integer.parseInt(pageRaw);
        }

        int size;
        String sizeRaw = req.getParameter("size");
        if (sizeRaw == null || sizeRaw.isEmpty()) {
            size = 10;
        } else {
            size = Integer.parseInt(sizeRaw);
        }

        Pageable pageable = new Pageable(page, size);

        String airArr = req.getParameter("airArr");
        String airDep = req.getParameter("airDep");

        FlightFilter filter = new FlightFilter.Builder().
                setCodeAirArrival(airArr).
                setCodeAirDepart(airDep).build();

        List<Flight> list = flightService.get(filter, pageable);

        writer.write(mapper.writeValueAsString(list));
    }
}
