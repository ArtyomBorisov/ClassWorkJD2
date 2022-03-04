package by.it.academy.Mk_JD2_88_22.controller.web.servlets.airportsDB;

import by.it.academy.Mk_JD2_88_22.model.airpotsDB.Flight;
import by.it.academy.Mk_JD2_88_22.view.airportsDB.FlightService;
import by.it.academy.Mk_JD2_88_22.view.api.IFlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

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

        int count = Integer.parseInt(req.getParameter("count"));

        List<Flight> list = flightService.get(count);

        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.filterOutAllExcept(
                "Аэропорт вылета",
                "Аэропорт прилета",
                "Время вылета по расписанию");
        FilterProvider filter = new SimpleFilterProvider().addFilter("myFilter", theFilter);
        writer.write(mapper.writer(filter).writeValueAsString(list));
    }
}
