<%-- 
    Document   : TestPage
    Created on : Jul 3, 2024, 11:41:03 AM
    Author     : USER
--%>

<%@page import="DTO.ItemCart"%>
<%@page import="DTO.ItemCart"%>
<%@page import="DTO.Menu"%>
<%@page import="DTO.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>

            <h1><%
                String userID = (String) request.getAttribute("Temp1");
                out.print(userID);
                %></h1>
            <h1>Xin chao</h1>


        </h1>
    </body>
</html>
