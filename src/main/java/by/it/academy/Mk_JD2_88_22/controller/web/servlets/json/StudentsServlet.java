package by.it.academy.Mk_JD2_88_22.controller.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.storage.json.StorageStudentService;
import by.it.academy.Mk_JD2_88_22.storage.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentsServlet", urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {

    private IStorageService<Student> storageStudentService;
    private ObjectMapper mapper;

    public StudentsServlet() {
        this.storageStudentService = StorageStudentService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        List<Student> storage = (List<Student>) storageStudentService.getStorage();

        writer.write(mapper.writeValueAsString(storage));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Student student = mapper.readValue(req.getInputStream(), Student.class);

        storageStudentService.addToStorage(student);
    }
}
