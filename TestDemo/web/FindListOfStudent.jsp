<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.Semester" %>
<%@ page import="model.Subject" %>
<%@ page import="dal.DAOSemester" %>
<%@ page import="dal.DAOSubject" %>
<%@ page import="java.util.Iterator" %>

<%
    DAOSemester dao = new DAOSemester();
 

    // Get data from the database
    Vector<Semester> semesters = dao.getData("select * from semester");
      
    

%>
<html>
    <head>
        <title>Semester List</title>
    </head>
    <body>
        <h1>Semester List</h1>

        <table>
            <tr>
                <th>Semester</th>
            </tr>
            <%  Iterator<Semester> iterator = semesters.iterator();
        while (iterator.hasNext()) {
            Semester semester = iterator.next();
            %>
                <tr>
                   <td> <a href="/SubjectList.jsp?id=<%= semester.getIdSemester() %>"><%= semester.getName() %></a></td>

                </tr>
            <% } %>
        </table>
          <%--<jsp:include page="header.jsp"/>--%>
    </body>
</html>
