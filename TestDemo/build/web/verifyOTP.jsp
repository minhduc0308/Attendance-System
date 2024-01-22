<%-- 
    Document   : verifyOTP
    Created on : Jan 22, 2024, 7:14:10 PM
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
        <h2>Enter OTP</h2>

        <%
            String error = (String)request.getAttribute("error");
            if (error != null) {
        %>
        <p style="color: red;"><%= error %></p>
        <%
            }
        %>

        <form action="verifyOTP" method="post">
            <label for="otp">OTP:</label>
            <input type="text" id="otp" name="otp" required>
            <br>
            <input type="submit" value="Verify OTP">
        </form>
    </body>
</html>
