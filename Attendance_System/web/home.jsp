<%-- 
    Document   : home
    Created on : Jan 16, 2024, 10:19:38 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        // Lấy token từ attribute
        String data = (String) request.getAttribute("data"); 
        if (data != null) {
    %>
        <!-- In token -->
        <p>Token: <%= data %></p>
    <% 
        } else {
    %>
        <p>Không tìm thấy token.</p>
    <% 
        }
    %>

    </body>
</html>
