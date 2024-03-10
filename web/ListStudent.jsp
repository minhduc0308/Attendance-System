<%-- 
    Document   : ListStudent
    Created on : Jan 21, 2024, 8:42:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.email}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.address}</td>
                <td>${student.dob}</td>
            </tr>
        </c:forEach>
    </table>
        <%String idLectures = request.getParameter("idLectures");%>
        
        <form action="SendFeedBackToStudent" method="post">
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" rows="4" cols="50"></textarea><br>
        
        <input type="submit" value="Send Feedback">
        </form>
    </body>
</html>