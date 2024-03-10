<%-- 
    Document   : StudentHome
    Created on : Mar 5, 2024, 9:37:38 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div class="info-box">
        <% 
        // Lấy thông tin từ session
        String id = (session.getAttribute("id") != null) ? session.getAttribute("id").toString() : "";

        out.print("Id: " + id);
        %>
    </div>
    <div id="menu">
        <a class="btn" href="ListLectureEachStudent?id=<%=id%>">Send feedback to Lecture</a> |
        <a class="btn" href="ListParent.jsp">List Parent</a>
        <a class="btn" href="student/timetable?id=<%=id%>">Weekly Timetable</a>

    </div>
</body>
</html>
