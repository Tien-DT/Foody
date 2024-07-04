<%-- 
    Document   : TestPage
    Created on : Jul 3, 2024, 11:41:03 AM
    Author     : USER
--%>

<%@page import="DTO.Menu"%>
<%@page import="DTO.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:forEach items="${Food2}" var="food">
                <td>${food.FoodName}</td>
            </c:forEach>
        </h1>
    </body>
</html>
