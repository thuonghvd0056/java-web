package controller;

import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private StudentModel studentModel = new StudentModel();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie:
            cookies){
                System.out.println(cookie.getName() + " - " + cookie.getValue() + " - " + cookie.getDomain());
            }
        }
        HttpSession session = req.getSession();
        Student students = (Student) session.getAttribute("currentLoggedIn");
        req.setAttribute("student", students);
        req.getRequestDispatcher("/member/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String inputPassword = req.getParameter("password");
        String inputUsername = req.getParameter("username");
        StudentModel model = new StudentModel();
        Student student = model.findByUsernameAndStatus(inputUsername, Student.Status.ACTIVE);
        if (student == null){
            resp.setStatus(404);
            resp.getWriter().println("Tài khoản không tồn tại hoạc đã bị xóa!");
        }else {
                //mã hóa pass vs salt lấy ra từ db trước khi so sánh.
                if (inputPassword.equals(student.getPassword())){
                    HttpSession session = req.getSession();
                    session.setAttribute("currentLoggedIn", student);
                    resp.setStatus(200);
                    resp.getWriter().println("Đăng nhập thành công mỹ mãn!");
                }else {
                    resp.setStatus(401);
                    resp.getWriter().println("Sai thông tin tài khoản.");
            }
        }
    }

    public static void main(String[] args) {
        String inputPassword = "1234";
        StudentModel model = new StudentModel();
        Student student = model.findByUsernameAndStatus("thuong0708", Student.Status.ACTIVE);
        if (student == null) {
            System.err.println("Tài khoản không tồn tại hoặc đã bị xóa") ;
        } else {
            // mã hóa password  với salt lấy ra từ database trước khi so sánh .
            if (inputPassword.equals(student.getPassword())){
                System.out.println("Login success.");
            } else {
                System.err.println("Sai thông tin tài khoản.");
            }
        }
    }
}
