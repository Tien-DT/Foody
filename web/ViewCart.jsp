
           <%-- 
    Document   : ViewCart
    Created on : Jun 5, 2024, 10:31:14 AM
    Author     : ADMIN
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="DTO.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/thecuatui" prefix="v" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            <a href="GetFoodServlet">Home</a>
            <a href="ViewCart.jsp">View cart</a>
            <a href="#">Register</a>
            <a href="#">Login</a>
            <v:Welcome/>
        </h3>
        <%
            HashMap<Food, Integer> cart = (HashMap) session.getAttribute("cart");
            if (cart != null) {
        %>
        <h1>your cart</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>IMAGE</th>
                <th>PRICE</th>
                <th>QUANTITY</th>
                <th>ACTION</th>
            </tr>
            <%
                int total = 0;
                for (Food t : cart.keySet()) {
                    int quantity = cart.get(t);
                    total = total + quantity * t.getFoodPrice();
            %>

            <form action="ModifyCartServlet"> 
                <input type="hidden" value="<%= t.getFoodID()%>" name="txtitemid"/>
                <tr>
                    <td><%= t.getFoodID()%></td>
                    <td><%= t.getFoodName()%></td>
                    <td><img src="<%= t.getFoodImage()%>"/></td>
                    <td><%= t.getFoodPrice()%></td>
                    <td><input type="number" value="<%= quantity%>" min="1" max="10" name="txtquantity"/></td>
                    <td>
                        <input type="submit" value="remove" name="btnaction"/>
                        <input type="submit" value="update" name="btnaction"/>

                    </td>
                </tr> </form>
                <%
                    }
                %>
        </table>
        <p>Total: <%= total%> VND</p>
        <p>Order date: <%= (new Date()).toString()%></p>
        <p><a href="SaveOrderServlet">Hoan thanh</a></p>
        
    </div>
    </body>
</html>