<%-- 
    Document   : login
    Created on : Apr 26, 2025, 8:58:20 AM
    Author     : Computing Fundamental - HCM Campus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="MainController" method="post">
            <label>Enter username: <input type="text" name="username"></label> <br/><!-- comment -->
            <label>Enter password: <input type="password" name="password"></label><br/><!-- comment -->
            
            <input type="submit" value="Login">
            <input type="hidden" name="action" value="login">
        </form>
        
        ${ERROR}
    </body>
</html>
