<%-- 
    Document   : ListClassForFeedBack
    Created on : Feb 27, 2024, 5:33:28 PM
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
    String lectureName = request.getParameter("lectureName");
%>
<p>Lecture ID: <%= idLectures %></p>
<p>Lecture Name: <%= lectureName %></p>
        <table>
            <tr>
                <th>Class ID</th>
                <th>Class Name</th>
            </tr>
            <c:forEach var="classInfo" items="${classNames}">
                <tr>
                    <td>${classInfo[0]}</td>
                    <td>${classInfo[1]}</td>
                    <td><a href="ListStudentEachClass?idClass=${classInfo[0]}&idLectures=<%= idLectures %>">View Students</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="LectureHome.jsp?idLectures=<%= idLectures %>&lectureName=<%= lectureName %>">Back to Lecture Home</a>
    </body>
</html>
