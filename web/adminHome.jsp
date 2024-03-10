<%-- 
    Document   : adminHome
    Created on : Jan 31, 2024, 8:49:20 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                display: flex;
            }

            #sidebar {
                width: 200px;
                height: 100%;
                background-color: #f1f1f1;
                padding-top: 20px;
            }

            #content {
                flex: 1;
                padding: 20px;
            }

            .sidebar-button {
                display: block;
                padding: 10px;
                text-align: left;
                text-decoration: none;
                font-size: 16px;
                color: black;
                border: none;
                background: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div id="sidebar">
            <button class="sidebar-button" onclick="location.href = 'adminHome.jsp'">Home</button>
            <button class="sidebar-button" onclick="location.href = 'LectureManage.jsp'">Lecture Management</button>
            <button class="sidebar-button" onclick="location.href = 'FindListOfStudent.jsp'">Search Student List</button>
        </div>
    </body>
</html>
