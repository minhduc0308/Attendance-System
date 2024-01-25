/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Semester;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Vector;
import dal.DAOSemester;

/**
 *
 * @author HuyPC
 */
@WebServlet(name = "ControllerSemester", urlPatterns = {"/SemesterURL"})
public class ControllerSemester extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOSemester dao = new DAOSemester();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllSemester";
            }
            if (service.equals("listAllSemester")) {
                String message = request.getParameter("message");
                if (message == null) {
                    message = "";
                }
                Vector<Semester> vector
                        = dao.getData("SELECT * FROM Semester");
                String pageTitle = "Semester";
                String tableTitle = "List of Semester";

                //pre
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", pageTitle);
                request.setAttribute("tableTitle", tableTitle);
                request.setAttribute("message", message);
                //select view/jsp
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/DisplaySemester.jsp");
                //display
                dispath.forward(request, response);
            }

            if (service.equals("insertSemester")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // request view form
                    Vector<Semester> vector = dao.getData("select * from Semester");
                    request.setAttribute("data", vector);
                    dispath(request, response, "/jsp/InsertSemester.jsp");
                } else {
                    //Insert Customer
                    //get data
                    String Seid = request.getParameter("id");
                    String Name = request.getParameter("name");
                    
                    // check data

                    // convert
                    int id = Integer.parseInt(Seid);
                   

                    Semester pro = new Semester(id, Name);
                    int n = dao.addSemesterByPrepared(pro);
                    String st = "";
                    response.sendRedirect("SemesterURL?message=" + st);
                }
            }

            if (service.equals("deleteSemester")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                int n = dao.deleteSemester(cid);
                String st = "delete success";
                if (n == 0) {
                    st = "can't delete because ...";
                }
                response.sendRedirect("SemesterURL?message=" + st);
            }

            if(service.equals("updateSemester")){
                String update = request.getParameter("submit");
                if(update==null){
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    Vector<Semester> vector = dao.getData("select * from orders where idSemester="+cid);
                    request.setAttribute("data", vector);
                    dispath(request, response, "/jsp/UpdateSemester.jsp");
                }else{
                      String Seid = request.getParameter("id");
                    String Name = request.getParameter("name");
                    
                    // check data

                    // convert
                    int id = Integer.parseInt(Seid);
                   

                    Semester pro = new Semester(id, Name);
                    int n = dao.updateSemester(pro);
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
