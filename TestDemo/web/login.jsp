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
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f0f0f0;
            }

            div {
                width: 300px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
                margin-top: 50px;
            }

            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            input[type="submit"] {
                width: 100%;
                padding: 10px;
                border-radius: 5px;
                border: none;
                color: #fff;
                background-color: #007BFF;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            a {
                text-decoration: none;
                color: #007BFF;
            }

            a:hover {
                color: #0056b3;
            }

        </style>
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
        <div>
            <input type="checkbox" name="rem"/> Remember password
            <a href="forgotPassword.jsp">Forgot password?</a>
        </div>
    </body>
</html>
