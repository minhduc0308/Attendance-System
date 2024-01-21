<%-- 
    Document   : login.jsp
    Created on : Jan 19, 2024, 8:42:08 PM
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
        <div>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/TestDemo/LoginGoogle&response_type=code
    &client_id=633898061282-5lkqa1u4c6lp5l81i2f9nm76g4ddh1qf.apps.googleusercontent.com&approval_prompt=force">Login With Google</a> 
        </div>
        <div>
            <form action="LoginAccount" method="post">
                username: <input type="text" name="user"><br/>
                password: <input type="password" name="pass"><br/>
                <input type="submit" value="Login"/><br/>
            </form>
        </div>
    </body>
</html>
