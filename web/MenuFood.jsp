<%-- 
    Document   : MenuFood
    Created on : Jul 3, 2024, 9:33:35 AM
    Author     : USER
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/Main.css" rel="stylesheet">
        <link href="assets/css/MenuFood.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
   <body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <jsp:include page="Header.jsp" />
            </div>
        </div>
            <div> <h1 class="jumbotron-heading cart">Giỏ Hàng</h1> </div>
        <div class="row mt-3">
            <div class="col-md-12">
                <h1 class="jumbotron-heading cart">Thực Đơn Hàng Ngày</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-responsive table-food">
                    <table class="table table-hover" style="height:20vh;">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Thứ Hai</th>
                                <th scope="col">Thứ Ba</th>
                                <th scope="col">Thứ Tư</th>
                                <th scope="col">Thứ Năm</th>
                                <th scope="col">Thứ Sáu</th>
                                <th scope="col">Thứ Bảy</th>
                                <th scope="col">Chủ Nhật</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row"></th>
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food2}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food3}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food4}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food5}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food6}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${Food7}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                
                                <td class="Food-name-menu">
                                    <p class="Food-name-menu">
                                        <c:forEach items="${FoodCN}" var="food">
                                            ${food.foodID}<br>
                                        </c:forEach>
                                    </p>
                                </td>
                                <!-- Repeat similar structure for other days -->
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <jsp:include page="Footer.jsp" />
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (optional, only if you need Bootstrap JavaScript components) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+O6pDkw/6KLk0mk9/pUo6F4+Xjqn0CK0yW7" crossorigin="anonymous"></script>
</body>


</html>
