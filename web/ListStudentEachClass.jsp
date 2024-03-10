<%-- 
    Document   : ListStudentEachClass
    Created on : Feb 27, 2024, 9:19:23 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
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
        <%
    String idLectures = request.getParameter("idLectures");
%>
<p>Lecture ID: <%= idLectures %></p>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Feedback</th>
                <th>View details</th>
            </tr>
            <c:forEach var="studentId" items="${studentIds}">
                <tr>
                    <td>${studentId.id}</td>
                    <td>${studentId.name}</td>
                    <td><a href="SendFeedbackToStudent?idStudents=${studentId.id}&idLectures=<%= idLectures %>">Send Feedback</a></td>
                    <td><a href="ListFeedbackByStudentId?idStudents=${studentId.id}&idLectures=<%= idLectures %>">View feedback</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
