<%-- 
    Document   : search
    Created on : Apr 26, 2025, 8:59:02 AM
    Author     : Computing Fundamental - HCM Campus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <!--your code here-->
        <h2>Welcome <span style="color: blue">${sessionScope.user.username}</span> </h2>

        <h2>Tool</h2>
        <ul style="list-style: none">
            <li><a href="MainController?action=search">Search</a></li>
            <li><a href="MainController?action=logout">Logout</a></li>
        </ul>

        <h2>Search</h2>

        <form action="MainController" method="post">
            <input type="text" name="search" value="${param.search}">

            <input type="submit" value="Search">
            <input type="hidden" name="action" value="search">
        </form>
        <c:if test="${not empty requestScope.list}">
            <table border="2">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Location</th>
                    <th>Description</th>
                    <th>Posted date</th>
                    <th>Price</th>
                    <th>Tool</th>
                </tr>

                <c:forEach var="i" items="${requestScope.list}">
                    <c:if test="${i.status != -2}">
                        <tr> 
                            <td>${i.id}</td>
                            <td>${i.title}</td>
                            <td>${i.location}</td>
                            <td>${i.description}</td>
                            <td>${i.postedDate}</td>
                            <td>${i.price}</td>
                            <td>
                                <c:if test="${i.status != 1}">
                                    <form action="MainController" method="post">
                                        <input type="submit" value="Delete">

                                        <input type="hidden" name="roomId" value="${i.id}">
                                        <input type="hidden" name="location" value="${param.search}">
                                        <input type="hidden" name="action" value="delete">

                                    </form>
                                </c:if>
                            </td>
                        </tr> 
                    </c:if>
                </c:forEach>

            </table>
        </c:if>
        ${ERROR}
    </body>
</html>
