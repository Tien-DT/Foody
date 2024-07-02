<%-- 
    Document   : index
    Created on : May 30, 2024, 5:48:34 PM
    Author     : USER
IMG FOR FOOD 332*202
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Food"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Trang chủ-Foody.</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

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
        <jsp:include page="Header.jsp" />
        <!-- End Header -->
        <!-- ======= Menu Section ======= -->
        <section class="row filter-food">
            <div class="col-md-2">
                <!-- Filter For List -->
                <h1 id="filter">Filter</h1>
                <form>
                    <div class="form-group">
                        <label for="min-price">Giá Tối Thiểu:</label>
                        <input type="number" class="form-control" id="min-price" name="min-price">
                    </div>
                    <div class="form-group">
                        <label for="max-price">Giá Tối Đa:</label>
                        <input type="number" class="form-control" id="max-price" name="max-price">
                    </div>
                    <div class="form-group">
                        <label for="food-type">Loại món ăn:</label>
                        <select class="form-control" id="food-type" name="food-type">
                            <option value="">Tất cả</option>
                            <option value="nước">Nước</option>
                            <option value="khô">Khô</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="sort-by">Phân loại theo:</label>
                        <select class="form-control" id="sort-by" name="sort-by">
                            <option value="price-asc">Giá tăng dần</option>
                            <option value="price-desc">Giá giảm dần</option>
                            <option value="rating-asc">Đánh giá tăng dần</option>
                            <option value="rating-desc">Đánh giá giảm dần</option>
                        </select>
                    </div>
                    <button type="button" class="btn btn-primary button-filter" onclick="filterMenu()">Lọc</button>
                </form>
            </div>


            <section id="menu" class="menu col-md-10">
                <div class="container" data-aos="fade-up">
                    <div class="section-header">
                        <p>Danh Sách Món Ăn</p>
                    </div>
                    <div class="tab-content" data-aos="fade-up" data-aos-delay="300">
                        <div class="tab-pane fade active show" id="menu-starters">
                            <div class="row gy-5">
                                <%
                                    ArrayList<Food> list = (ArrayList) request.getAttribute("FoodList");
                                    if (list != null) {
                                        for (Food f : list) {
                                            if (f.getFoodStatus()) {


                                %>
                                <div class="col-lg-4 col-md-6 col-sm-12 menu-item">
                                    <div class="card h-150">
                                        <a href="assets/img/menu/menu-item-1.png" class="glightbox">
                                            <img src="<%= f.getFoodImage()%>" class="card-img-top menu-img img-fluid rounded food-img" class="rounded" width="300" width="300" alt="">
                                        </a>
                                        <div class="card-body d-flex flex-column">
                                            <h4 class="card-title"><%= f.getFoodName()%></h4>
                                            <p class="card-text">
                                                <!-- Assuming there's a description -->
                                            </p>
                                            <p class="price card-text mt-auto">
                                                <%= f.getFoodPrice()%> VNĐ
                                            </p>
                                            <div class="d-grid gap-2">
                                                <button class="btn btn-danger">Mua Món Ăn</button>
                                                <button class="btn btn-primary">Mua Nguyên Liệu</button>
                                                <button class="btn btn-secondary">Thêm vào Menu</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                            }
                                        }
                                    }
                                %>
                            </div>
                            <!-- End Breakfast Menu Content -->
                        </div>
                    </div>
                </div>
            </section>
        </section>

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="container">
                <div class="row gy-3 footercontent">
                    <div class="col-lg-3 col-md-6 d-flex">
                        <i class="bi bi-geo-alt icon"></i>
                        <div>
                            <h4>172 Nguyễn An Ninh, TP.Dĩ An, Bình Dương</h4>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 footer-links d-flex">
                        <i class="bi bi-telephone icon"></i>
                        <div>
                            <h4>Liên Hệ</h4>
                            <p>
                                <strong>Phone:</strong> 0399888999<br>
                                <strong>Email:</strong> tienne@gmail.com<br>
                            </p>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 footer-links d-flex">
                        <i class="bi bi-clock icon"></i>
                        <div>
                            <h4>Thời Gian Mở Cửa</h4>
                            <p>
                                <strong>Thứ 2- Thứ 6:</strong> 8h-19h<br>
                            </p>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 footer-links">
                        <h4>Theo Dõi</h4>
                        <div class="social-links d-flex">
                            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <div id="preloader"></div>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>
</html>
