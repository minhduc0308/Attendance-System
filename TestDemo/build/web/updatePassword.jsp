<%-- 
    Document   : updatePassword
    Created on : Jan 22, 2024, 7:44:14 PM
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
        <h2>Update Password</h2>
    
    <!-- Hiển thị thông báo lỗi nếu có -->
    <% String error = (String)request.getAttribute("error"); %>
    <% if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <!-- Hiển thị thông báo thành công nếu có -->
    <% String successMessage = (String)request.getAttribute("successMessage"); %>
    <% if (successMessage != null && !successMessage.isEmpty()) { %>
        <p style="color: green;"><%= successMessage %></p>
    <% } %>

    <!-- Hiển thị form update password -->
    <form action="updatePassword" method="post">
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        <input type="hidden" name="username" value="${username}">
        <br>
        <input type="submit" value="Update Password">
    </form>

    </body>
</html>
