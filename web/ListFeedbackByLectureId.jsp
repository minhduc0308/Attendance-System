<%-- 
    Document   : ListFeedbackByLectureId
    Created on : Mar 10, 2024, 5:45:35 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Feedback List</h1>
        <%
    String id = request.getParameter("idStudents");
%>
<p>Lecture ID: <%= id %></p>
    <table>
        <tr>
            <th>FeedBack ID</th>
            <th>Lecture ID</th>
            <th>Lecture Name</th>
            <th>Content</th>
            <th>Date</th>
            <th>Update feedback</th>
        </tr>
        <c:forEach var="feedback" items="${feedbackList}">
            <tr>
                <td>${feedback.id}</td>
                <td>${feedback.lectureId}</td>
                <td>${feedback.lecture.name}</td>
                <td>${feedback.content}</td>
                <td>${feedback.date}</td>
                <td><a href="UpdateFeedbackForLecture?idFeedBack=${feedback.id}&idStudents=<%= id %>&idLectures=${feedback.lectureId}">Update feedback</a></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
