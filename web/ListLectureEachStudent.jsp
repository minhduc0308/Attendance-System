<%-- 
    Document   : ListLectureEachStudent
    Created on : Mar 8, 2024, 2:15:02 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    String id = request.getParameter("id");
%>
<p>Lecture ID: <%= id%></p>
        <table>
            <tr>
                <th>Lecture ID</th>
                <th>Lecture Name</th>
                <th>Send feedback</th>
            </tr>
            <c:forEach var="lectureInfo" items="${lecture}">
                <tr>
                    <td>${lecture.id}</td>
                    <td>${lecture.name}</td>
                    <td><a href="SendFeedbackToLecture?idLectures=${lecture.id}&idStudents=<%= id%>">View Lecture</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="StudentHome.jsp?idLectures=<%= id %>>Back to Lecture Home</a>
    </body>
</html>
