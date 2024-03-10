/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.GoogleUtils;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;
import model.Lecture;
import model.Student;
import model.TrainigDepartment;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginGoogle", urlPatterns = {"/LoginGoogle"})
public class LoginGoogle extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogle() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);

            // Check if the user is already logged in
            Student student = (Student) session.getAttribute("student");
            Lecture lecture = (Lecture) session.getAttribute("lecture");
            Admin admin = (Admin) session.getAttribute("admin");

            if (student != null) {
                response.sendRedirect("StudentHome.jsp");
            } else if (lecture != null) {
                response.sendRedirect("LectureHome.jsp");
            } else if (admin != null) {
                response.sendRedirect("adminHome.jsp");
            } else {
                // Continue with the existing logic for handling Google login
                String code = request.getParameter("code");
                DAO d = new DAO();
                if (code == null || code.isEmpty()) {
                    RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                    dis.forward(request, response);
                } else {
                    String accessToken = GoogleUtils.getToken(code);
                    student = GoogleUtils.getUserInfo(accessToken);
                    lecture = GoogleUtils.getLectureInfo(accessToken);
                    admin = GoogleUtils.getAdminInfo(accessToken);

                    Student existingStudent = d.check(student.getEmail());
                    Lecture existingLecture = d.checkLectureEmail(lecture.getEmail());
                    Admin existingAdmin = d.checkAdminEmal(admin.getEmail());

                    if (existingStudent != null) {
                        session.setAttribute("id", existingStudent.getId());
                    session.setAttribute("email", existingStudent.getEmail());
                    session.setAttribute("dob", existingStudent.getDob());
                        session.setAttribute("student", existingStudent);
                        response.sendRedirect("StudentHome.jsp");
                    } else if (existingLecture != null) {
                        session.setAttribute("idLectures", existingLecture.getId());
                        session.setAttribute("email", existingLecture.getEmail());
                        session.setAttribute("lectureName", existingLecture.getName());
                        session.setAttribute("dateOfBirth", existingLecture.getDob());
                        session.setAttribute("lecture", existingLecture);
                        response.sendRedirect("LectureHome.jsp");
                    } else if (existingAdmin != null) {
                        session.setAttribute("admin", existingAdmin);
                        response.sendRedirect("adminHome.jsp");
                    } else {
                        session.setAttribute("student", student);
                        RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                        dis.forward(request, response);
                    }
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
