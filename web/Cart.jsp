<%@page import="DTO.ItemCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="assets/css/Cart.css" rel="stylesheet">
        <link href="assets/css/Footer.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <title>Giỏ Hàng</title>
    </head>
    <body>
       
        <%@include file="Header.jsp" %> 

        <div>
            <h1 class="jumbotron-heading cart">Giỏ Hàng</h1>
        </div>  

        <div class="container mb-4 cart-frame">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Sản Phẩm</th>
                                    
                                    <th scope="col" class="text-center">Số Lượng</th>
                                    <th scope="col" class="text-right">Giá (VNĐ)</th>
                                    <th scope="col" class="text-right">Tổng</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                   ArrayList<ItemCart> listitem = (ArrayList) request.getAttribute("ItemCart");
                                   int totalPrice =0;
                                    if (listitem != null) {
                                        for (ItemCart i : listitem) {
                                            totalPrice += i.getItemPrice() * i.getItemQuantity();
                                %>
                                <tr>
                            
                                    <td><img src="<%= i.getItemImage()%>" width="50" height="50" /></td>
                                    <td><%= i.getItemName() %></td>
                                    <td class="text-right"><span class="formatted-price"><%= i.getItemQuantity() %></span></td>
                                    <td class="text-right item-total"><span class="formatted-price"><%= i.getItemPrice() %></span></td>
                                    <td class="text-right">
                                        <form action="MainController?action=deletecart" method="POST">
                                            <button type="submit" class="btn btn-sm btn-danger">
                                                <input type="hidden" name="cartid" value="<%=i.getCartID() %>">
                                            <p>Xóa</p>
                                            </button>
                                        </form>
                                    </td>
                                   
                                </tr>
                                <%
                                        }
                                    }else{
                                    request.getRequestDispatcher("Index.jsp").forward(request, response);
}
                                %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><strong>Tổng Tiền Sản Phẩm: <%=totalPrice %></strong></td>
                                    <td class="text-right"><strong id="totalPrice"><span class="formatted-price"></span></strong></td>
                                    <td></td>
                                    <%
                                        request.setAttribute("TotalPrice", totalPrice);
                                    %>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col mb-2">
                    <div class="row">
                        <div class="col-sm-12 col-md-6">
                            <a href="MainController?action=foodlist" class="btn btn-block btn-light">Tiếp Tục Mua Hàng</a>
                        </div>
                        <form action="MainController?action=order" method="POST">
                        <div class="col-sm-12 col-md-6 text-right">
                            <input type="hidden" name="function" value="ORDERFORM">
                            <input type="hidden" name="totalprice" value="<%=totalPrice %>">
                            <button class="btn btn-lg btn-block btn-danger text-uppercase " type="submit">Đặt Hàng</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="Footer.jsp" %>
    </body>
</html>