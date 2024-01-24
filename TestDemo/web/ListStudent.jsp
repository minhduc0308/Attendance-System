<%-- 
    Document   : ListStudent
    Created on : Jan 21, 2024, 8:42:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="model.Student" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>DOB</th>
        </tr>
        <% 
            Vector<Student> students = (Vector<Student>) request.getAttribute("students");
            for (Student student : students) {
        %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getPhoneNumber() %></td>
                <td><%= student.getAddress() %></td>
                <td><%= student.getDOB() %></td>
            </tr>
        <% 
            }
        %>
    </table>
    </body>
</html>
