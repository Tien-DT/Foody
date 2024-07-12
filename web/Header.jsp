<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>JSP Page</title>
        <!-- Favicons -->
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>

        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/Main.css" rel="stylesheet">
    </head>
    <body>
        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">
            <div class="container d-flex align-items-center justify-content-between">

                <a href="MainController?action=welcome" action="home" class="logo d-flex align-items-center me-auto me-lg-0">
                    <!-- Uncomment the line below if you also wish to use an image logo -->
                    <!-- <img src="assets/img/logo.png" alt=""> -->
                    <h1>Foody<span>.</span></h1>
                </a>

                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a href="MainController?action=welcome">Trang Chủ</a></li>
                        <li><a href="MainController?action=foodlist">Món Ăn</a></li>
                        <li><a href="GetCartServlet">Giỏ Hàng</a></li>
                        <li><a href="MainController?action=getorder">Đơn Hàng</a></li>
                        <li><a href="MainController?action=menu">Thực Đơn</a></li>
                        <li><a href="MainController?action=staffdashboard">DashBoard</a></li>
                        <c:if test="${empty sessionScope.LoginedUser}">
                            <li><a href="MainController?action=loginform">Đăng nhập</a></li>
                            </c:if>
                            <c:if test="${not empty sessionScope.LoginedUser}">
                            <li><a href="MainController?action=mydashboard">Xin chào: ${sessionScope.LoginedUser}</a></li>
                            <c:if test="${not empty sessionScope.LoginedUser}">
                                
                            <li><a href="MainController?action=logout">Đăng xuất</a></li>
                               
                                </c:if>
                        </c:if>
                            
                    </ul>
                </nav><!-- .navbar -->

                <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
                <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

            </div>

            
        </header><!-- End Header -->
    </body>
</html>
