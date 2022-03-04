package by.it.academy.Mk_JD2_88_22.controller.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.storage.json.StorageCitizenService;
import by.it.academy.Mk_JD2_88_22.storage.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.model.Citizen;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CitizenServlet", urlPatterns = "/citizens")
public class CitizenServlet extends HttpServlet {

    private IStorageService<Citizen> storageCitizenService;
    private ObjectMapper mapper;

    public CitizenServlet() {
        this.storageCitizenService = StorageCitizenService.getInstance();
        this.mapper = new ObjectMapper();

        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        mapper.registerModule(module);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        List<Citizen> storage = (List<Citizen>) storageCitizenService.getStorage();

        writer.write(mapper.writeValueAsString(storage));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Citizen citizen = mapper.readValue(req.getInputStream(), Citizen.class);

        storageCitizenService.addToStorage(citizen);
    }
}
