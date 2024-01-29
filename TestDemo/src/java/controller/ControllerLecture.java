/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Lecture;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Vector;
import dal.DAOLecture;

/**
 *
 * @author HuyPC
 */
@WebServlet(name = "ControllerLecture", urlPatterns = {"/LectureURL"})
public class ControllerLecture extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            DAOLecture dao = new DAOLecture();
            String service = request.getParameter("service");

            if (service == null) {
                service = "listAllLecture";
            }

            if (service.equals("listAllLecture")) {
                String message = request.getParameter("message");
                if (message == null) {
                    message = "";
                }
                Vector<Lecture> vector = dao.getData("SELECT * FROM lectures");
                String pageTitle = "Lecture";
                String tableTitle = "List of Lecture";

                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", pageTitle);
                request.setAttribute("tableTitle", tableTitle);
                request.setAttribute("message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/DisplayLecture.jsp");
                dispatcher.forward(request, response);
            }

            if (service.equals("insertLecture")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Vector<Lecture> vector = dao.getData("select * from lectures");
                    request.setAttribute("data", vector);
                    dispatch(request, response, "/jsp/InsertLecture.jsp");
                } else {
                    String Lecid = request.getParameter("id");
                    String mail = request.getParameter("email");
                    String name = request.getParameter("lecName");
                    String phone = request.getParameter("Phone");
                    String address = request.getParameter("Address");
                    String DOB = request.getParameter("DoB");

                    BigInteger id = new BigInteger(Lecid);
                    int Phone = Integer.parseInt(phone);
                    Date dateOfBirth = Date.valueOf(DOB);

                    Lecture pro = new Lecture(id, mail, name, Phone, address, dateOfBirth);
                    int n = dao.addLectureByPrepared(pro);
                    String st = (n > 0) ? "insert success" : "insert failed";
                    response.sendRedirect("LectureURL?message=" + st);
                }
            }

            // ... (similar corrections for other cases)
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
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
