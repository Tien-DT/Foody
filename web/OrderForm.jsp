<%@page import="DTO.ItemCart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/UserFood.css" rel="stylesheet">
        <link href="assets/css/Header.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>
        <title>Nhâp Thông tin đặt hàng</title>
    </head>
    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content" style= "margin-top: 100px; min-height: 75%;">
            <div class="row">
                <div class="col-md-12 menu-title">
                    <h1 id="title-list">Nhập thông tin đặt hàng</h1>
                </div>
            </div>
            <form action="MainController?action=order" method="POST">
            <div class="box-menu box-list">
                <%
                
                    ArrayList<ItemCart> listitem = (ArrayList) request.getAttribute("OrderItem");
                    int totalPrice = 0;
                    if (listitem != null) {
                        for (ItemCart i : listitem) {
                            totalPrice += i.getItemPrice() * i.getItemQuantity();

                %>
                <h3 style="margin-top:20px;"><%=i.toString()%></h3>
                
                <%                        }
                    }
                        ServletContext context = request.getServletContext();
                        context.setAttribute("TotalPrice", totalPrice);
                %>
                <h3 style="color:red;">Tổng Tiền: <%=totalPrice %>VNĐ</h3>
                    <div class="form-group" style="margin-top:20px;">
                        <label for="exampleInputEmail1">Tên Người Nhận-Địa chỉ nhận hàng</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập Tên Người Nhận - Địa Chỉ" name="txtaddress">
                    </div>
                    
                    <div class="form-group" style="margin-top:20px;">
                        <label for="exampleInputEmail1">Số điện thoại</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập số điện thoại" name="txtnumber">
                    </div>
                <input type="hidden" name="function" value="ORDERNOW">
            </div>
                <button type="submit" class="btn btn-success">Đặt hàng ngay</button>   
                <a href="MainController?action=viewcart" class="btn btn-danger>" style="margin-left:10px;">Hủy</a>
            </form>
                
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>




</html>
