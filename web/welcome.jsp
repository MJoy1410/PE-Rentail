<%-- 
    Document   : welcome
    Created on : Apr 26, 2025, 8:58:34 AM
    Author     : Computing Fundamental - HCM Campus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        
    </head>
    <body>
        <!--your code here-->
        <h2>Welcome <span style="color: blue">${sessionScope.user.username}</span> </h2>
        
        <h2>Tool</h2>
        <ul style="list-style: none">
            <li><a href="MainController?action=search">Search</a></li>
            <li><a href="MainController?action=logout">Logout</a></li>
        </ul>

    </body>
</html>
