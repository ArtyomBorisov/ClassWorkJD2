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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
        String dayArr = req.getParameter("dayArr");

        FlightFilter.Builder builderRaw = new FlightFilter.Builder();

        if (airArr != null && !airArr.isEmpty()) {
            builderRaw.setCodeAirArrival(airArr);
        }

        if (airDep != null && !airDep.isEmpty()) {
            builderRaw.setCodeAirDepart(airDep);
        }

        if (dayArr != null && !dayArr.isEmpty()) {
            try {
                LocalDate date = LocalDate.parse(dayArr);
                builderRaw.setDayScheduleArrival(date);
            } catch (DateTimeParseException e) {}
        }

        FlightFilter filter = builderRaw.build();

        List<Flight> flights = flightService.get(filter, pageable);

        String contentType = req.getContentType();
        if ("application/json".equals(contentType)) {
            resp.setContentType("application/json");

            PrintWriter writer = resp.getWriter();

            writer.write(mapper.writeValueAsString(flights));
        } else {
            resp.setContentType("text/html");

            req.setAttribute("size", size);
            req.setAttribute("page", page);
            req.setAttribute("flights", flights);

            req.getRequestDispatcher("views/flights.jsp").forward(req, resp);
        }

    }
}
