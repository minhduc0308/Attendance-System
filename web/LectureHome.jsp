<%-- 
    Document   : LectureHome
    Created on : Feb 25, 2024, 8:22:33 PM
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
            /* Đặt CSS của bạn ở đây */
            table {
                width: 100%;
                border-collapse: collapse;
                border: 1px solid #ddd;
            }
            .btn {
                display: inline-block;
                text-decoration: none;
                color: #ff6633;
                border: 3px solid #ff6633;
                padding: 10px 20px;
                border-radius: 45px;
                transition: all 0.3s;
                font-size: 1.2em;
                font-weight: 250;
                font-family: 'Montserrat', sans-serif;
                margin: 5px 10px;
            }
            /* ... */
            .info-box {
            background-color: #ffcc99;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
            .btn:hover {
                background: #ff6633;
                color: white;
                font-size: 1.5em;
            }
        </style>
    </head>
    <body>
    <div class="info-box">
        <% 
        // Lấy thông tin từ session
        String idLectures = (session.getAttribute("idLectures") != null) ? session.getAttribute("idLectures").toString() : "";
        String lectureName = (session.getAttribute("lectureName") != null) ? session.getAttribute("lectureName").toString() : "";

        out.print("Id: " + idLectures);
        out.print("<br/>Lecture Name: " + lectureName);
        %>
    </div>
    <div id="menu">
        <a class="btn" href="ListClassForFeedBack?idLectures=<%=idLectures%>&lectureName=<%=lectureName%>">Send feedback to student</a> |
        <a class="btn" href="ListParent.jsp">List Parent</a>
    </div>
</body>
</html>
