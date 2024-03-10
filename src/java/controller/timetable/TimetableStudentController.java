package controller.timetable;

import dal.AttendanceDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Student;

@WebServlet(name = "TimetableStudentController", urlPatterns = {"/student/attendance"})
public class TimetableStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AttendanceDBContext adb = new AttendanceDBContext();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student != null) {
            // Now you can access student attributes without it being null
            String email = student.getUsername();
            request.setAttribute("list", adb.listInfoStudent(email));
        } else {
            // Handle the case when the user is not logged in or student is null
            // You might want to redirect to a login page or show an error message
            // For simplicity, let's redirect to the home page
            response.sendRedirect("error.jsp");
            return;
        }

        request.getRequestDispatcher("../view/timetable/studentTimeTB.jsp").forward(request, response);
    }

    // ... (other methods remain unchanged)

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // You can implement any necessary logic for POST requests here
    }

    @Override
    public String getServletInfo() {
        return "Handles requests for student timetables";
    }
}
