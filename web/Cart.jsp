<%-- 
    Document   : AdminDashBoard
    Created on : Jun 24, 2024, 4:02:07 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="assets/css/Cart.css" rel="stylesheet">
    <link href="assets/css/Footer.css" rel="stylesheet">
    <!------ Include the above in your HEAD tag ---------->

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <body>
        <%
            String checkLogin = (String) session.getAttribute("LoginedUser");
            if (checkLogin == null) {
                request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
            }
        %>
        <div class="col-md-12"><jsp:include page="Header.jsp" /></div>

        <div> <h1 class="jumbotron-heading cart">Giỏ Hàng</h1> </div>


        <div class="container mb-4 cart-frame">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"> </th>
                                    <th scope="col">Sản Phẩm</th>
                                    <th scope="col">Tình Trạng</th>
                                    <th scope="col" class="text-center">Số Lượng</th>
                                    <th scope="col" class="text-right">Giá (VNĐ)</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${CartList}">
                                    <tr>
                                        <td><img src="${not empty item.foodImage ? item.foodImage : item.productImage}" width="50" height="50" /></td>
                                        <td>${not empty item.foodName ? item.foodName : item.productName}</td>
                                        <td>In stock</td>
                                        <td><input class="form-control" type="text" value="1" /></td>
                                        <td class="text-right">${not empty item.foodName ? item.foodPrice : item.productPrice}</td>
                                        <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                </c:forEach>

                                <!-- Calculate total -->
                                <c:set var="total" value="0" />
                                <c:forEach var="item" items="${CartList}">
                                    <c:set var="total" value="${total + (not empty item.FoodName ? item.FoodPrice : item.ProductPrice)}" />
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Tổng Tiền Sản Phẩm</td>
                                    <td class="text-right">${total}</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Phí Vận Chuyển</td>
                                    <td class="text-right">30000</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><strong>Tổng Cộng</strong></td>
                                    <td class="text-right"><strong>${total + 30000}</strong></td>
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
                        <div class="col-sm-12 col-md-6 text-right">
                            <button class="btn btn-lg btn-block btn-danger text-uppercase">Đặt Hàng</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   

    <!-- Footer -->
    <jsp:include page="Footer.jsp" />


</body>
</html>
