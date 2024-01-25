/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Subject;
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
import dal.DAOSubject;

/**
 *
 * @author HuyPC
 */
@WebServlet(name = "ControllerSubject", urlPatterns = {"/SubjectURL"})
public class ControllerSubject extends HttpServlet {

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
            DAOSubject dao = new DAOSubject();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllSubject";
            }
            if (service.equals("listAllSubject")) {
                String message = request.getParameter("message");
                if (message == null) {
                    message = "";
                }
                Vector<Subject> vector
                        = dao.getData("SELECT * FROM Subject");
                String pageTitle = "Subject";
                String tableTitle = "List of Subject";

                //pre
                request.setAttribute("data", vector);
                request.setAttribute("pageTitle", pageTitle);
                request.setAttribute("tableTitle", tableTitle);
                request.setAttribute("message", message);
                //select view/jsp
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/DisplaySubject.jsp");
                //display
                dispath.forward(request, response);
            }

            if (service.equals("insertSubject")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // request view form
                    Vector<Subject> vector = dao.getData("select * from Subject");
                    request.setAttribute("data", vector);
                    dispath(request, response, "/jsp/InsertSubject.jsp");
                } else {
                    //Insert Customer
                    //get data
                    String Subjid = request.getParameter("id");
                   
                    String Subjname = request.getParameter("Name");
                    String TDId = request.getParameter("TDiD");
                   
                    
                    // check data

                    // convert
                    int id = Integer.parseInt(Subjid);
                    int tdId = Integer.parseInt(TDId);
               

                    Subject pro = new Subject(id, Subjname, tdId);
                    int n = dao.addSubjectByPrepared(pro);
                    String st = "";
                    response.sendRedirect("SubjectURL?message=" + st);
                }
            }

            if (service.equals("deleteSubject")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                int n = dao.deleteSubject(cid);
                String st = "delete success";
                if (n == 0) {
                    st = "can't delete because ...";
                }
                response.sendRedirect("SubjectURL?message=" + st);
            }

            if(service.equals("updateSubject")){
                String update = request.getParameter("submit");
                if(update==null){
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    Vector<Subject> vector = dao.getData("select * from orders where idSubject="+cid);
                    request.setAttribute("data", vector);
                    dispath(request, response, "/jsp/UpdateSubject.jsp");
                }else{
                      //Insert Customer
                    //get data
                    String Subjid = request.getParameter("id");
                   
                    String Subjname = request.getParameter("Name");
                    String TDId = request.getParameter("TDiD");
                   
                    
                    // check data

                    // convert
                    int id = Integer.parseInt(Subjid);
                    int tdId = Integer.parseInt(TDId);
               

                    Subject pro = new Subject(id, Subjname, tdId);     
                    int n = dao.updateSubject(pro);
                    String st = "";
                    response.sendRedirect("SubjectURL?message="+st);
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
