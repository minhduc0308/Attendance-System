<%-- 
    Document   : forgotPassword
    Created on : Jan 22, 2024, 6:04:14 PM
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
        <h2>Forgot Password</h2>
    
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <% String error = (String)request.getAttribute("error"); %>
    <% if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <%-- Hiển thị thông báo thành công nếu có --%>
    <% String mess = (String)request.getAttribute("mess"); %>
    <% if (mess != null && !mess.isEmpty()) { %>
        <p style="color: green;"><%= mess %></p>
    <% } %>

    <%-- Form để nhập thông tin --%>
    <form action="forgotPassword" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <button type="submit">Submit</button>
    </form>
    </body>
</html>
