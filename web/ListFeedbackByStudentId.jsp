<%-- 
    Document   : ListFeedbackByStudentId
    Created on : Feb 28, 2024, 8:13:31 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        /* CSS cho trang */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        h1 {
            background-color: #ff6633;
            color: white;
            padding: 10px;
            text-align: center;
        }
        p {
            margin-top: 20px;
            margin-bottom: 10px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #ff6633;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        a {
            text-decoration: none;
            color: #ff6633;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
    </head>
    <body>
        <h1>Feedback List</h1>
        <%
    String idLectures = request.getParameter("idLectures");
%>
<p>Lecture ID: <%= idLectures %></p>
    <table>
        <tr>
            <th>FeedBack ID</th>
            <th>Student ID</th>
            <th>Content</th>
            <th>Date</th>
            <th>Update feedback</th>
        </tr>
        <c:forEach var="feedback" items="${feedbackList}">
            <tr>
                <td>${feedback.id}</td>
                <td>${feedback.studentId}</td>
                <td>${feedback.content}</td>
                <td>${feedback.date}</td>
                <td><a href="UpdateFeedback?idFeedBack=${feedback.id}&idStudents=${feedback.studentId}&idLectures=<%= idLectures %>">Update feedback</a></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
