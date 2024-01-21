<%-- 
    Document   : index
    Created on : Jan 19, 2024, 8:56:04 PM
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
        <h1>Index</h1>
         <%
    String id = (request.getAttribute("id") != null) ? request.getAttribute("id").toString() : "";
    String email = (request.getAttribute("email") != null) ? request.getAttribute("email").toString() : "";
    String phoneNumber = (request.getAttribute("phoneNumber") != null) ? request.getAttribute("phoneNumber").toString() : "";
    String address = (request.getAttribute("address") != null) ? request.getAttribute("address").toString() : "";
    String dob = (request.getAttribute("dob") != null) ? request.getAttribute("dob").toString() : "";

    out.print("Id: " + id);
    out.print("<br/>Email: " + email);
    out.print("<br/>Phone Number: " + phoneNumber);
    out.print("<br/>Address: " + address);
    out.print("<br/>Date of Birth: " + dob);
%>
    </body>
</html>
