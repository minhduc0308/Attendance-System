/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import model.Parent;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ParentAdd", urlPatterns = {"/ParentAdd"})
public class ParentAdd extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParentAdd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParentAdd at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            // Lấy thông tin từ request
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String job = request.getParameter("job");
            String placeOfWork = request.getParameter("placeOfWork");
            // Giá trị của otp sẽ được set là null
            // Kiểm tra xem id có giá trị không
            if (idStr != null && !idStr.isEmpty()) {
                // Chuyển đổi id và otp từ String sang BigInteger
                BigInteger id = new BigInteger(idStr);
                // Tạo đối tượng Parent
                Parent parent = new Parent(id, name, address, email, password, username, job, placeOfWork);

                // Gọi DAO để thêm Parent vào database
                DAO daoParent = new DAO();
                daoParent.addParent(parent);

                // Chuyển hướng về trang ListParent sau khi thêm thành công
                response.sendRedirect("ListParent");
            } else {
                // Xử lý khi id không hợp lệ
                request.setAttribute("error", "Invalid ID");
                RequestDispatcher dispatcher = request.getRequestDispatcher("AddParent.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý các ngoại lệ nếu có
            e.printStackTrace();
            request.setAttribute("error", "Error occurred: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddParent.jsp");
            dispatcher.forward(request, response);
        }
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
