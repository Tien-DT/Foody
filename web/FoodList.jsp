<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Food"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Danh Sách Món Ăn</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link href="assets/css/Main.css" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="Header.jsp" />
        <section class="row filter-food">
            <section id="menu" class="menu col-md-12">
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
                                        <a href="#" class="glightbox item-card">
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
                                                <form action="MainController?action=viewfood" method="POST">
                                                    <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                                                     <a><button class="btn btn-secondary button-card">Xem món ăn</button></a>
                                                </form>
                                                <form action="MainController?action=addfoodtocart" method="POST">
                                                    <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                                                    <a><button class="btn btn-danger button-card">Mua Món Ăn</button></a>
                                                </form>

                                             <!--  <form action="MainController?action=addproductcart" method="POST">
                                                    <input type="hidden" name="productid" value="<%= f.getFoodID()%>">
                                                    <a><button class="btn btn-primary button-card">Mua Nguyên Liệu</button></a>
                                                </form> -->
                                               
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

        <!-- Vendor JS Files -->
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
        <script>
                        function formatCurrency(amount) {
                            return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                        }


                        function formatAllPrices() {
                            var priceElements = document.querySelectorAll('.price');
                            priceElements.forEach(function (element) {
                                var price = parseInt(element.textContent.replace(/[^0-9]/g, ''), 10);
                                element.textContent = formatCurrency(price) + ' VNĐ';
                            });
                        }


                        window.onload = formatAllPrices;
        </script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>
</html>
