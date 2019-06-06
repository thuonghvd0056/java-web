package controller;

import com.google.gson.Gson;
import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private static StudentModel model = new StudentModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        req.setAttribute("Student", student);
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String role = req.getParameter("role");
        String address = req.getParameter("address");
        Student student = new Student();
        student.setUsername(name);
        student.setPassword(password);
        student.setEmail(email);
        student.setFullname(fullName);
        student.setRole(role);
        student.setAddress(address);
        model.save2(student);
        resp.getWriter().println(new Gson().toJson(student));
    }
}
