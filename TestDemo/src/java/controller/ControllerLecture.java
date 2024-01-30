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
        try (PrintWriter out = response.getWriter()) {
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
                    dispath(request, response, "/jsp/InsertLecture.jsp");
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

            if (service.equals("deleteLecture")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                int n = dao.deleteLecture(cid);
                String st = "delete success";
                if (n == 0) {
                    st = "can't delete because ...";
                }
                response.sendRedirect("SemesterURL?message=" + st);
            }

            if(service.equals("updateLecture")){
                String update = request.getParameter("submit");
                if(update==null){
                    BigInteger cid = new BigInteger(request.getParameter("cid"));
                    Vector<Lecture> vector = dao.getData("select * from orders where idLecture="+cid);
                    request.setAttribute("data", vector);
                    dispath(request, response, "/jsp/UpdateLecture.jsp");
                }else{
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
                    int n = dao.updateLecture(pro);
                    String st = "";
                    response.sendRedirect("SemesterURL?message="+st);
                 }
            }
        }

    }

    void dispath(HttpServletRequest request,
            HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        //display
        dispath.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
