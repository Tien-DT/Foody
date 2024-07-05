<%-- 
    Document   : index
    Created on : May 30, 2024, 5:48:34 PM
    Author     : USER
--%>

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
        <jsp:include page="Header.jsp" />
        <!-- End Header -->
        <div class="container">
        <!--Start Slide hero section-->
        <div id="carouselExampleIndicators" class="carousel slide slidebanner" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <section id="hero" class="hero d-flex align-items-center section-bg">
                        <div class="container">
                            <div class="row justify-content-between gy-5 divbanner">
                                <div class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start">
                                    <h2 data-aos="fade-up">Bánh Xèo<br>Món Ăn Phổ Biến Ở Miền Nam</h2>
                                    <p data-aos="fade-up" data-aos-delay="100">Món ăn này thường xuất hiện ở Nam Trung Bộ và các tỉnh miền Nam. Bánh xèo ở từng vùng miền sẽ khác nhau về màu sắc, kích cỡ, loại nhân bên trong, nước chấm. Điểm chung của tất cả các loại đều được làm từ bột gạo tẻ pha loãng, sau đó được tráng mỏng trên chảo và chiên giòn.</p>
                                    <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
                                        <a href="#book-a-table" class="btn-book-a-table">Đặt Mua</a>
                                        <a href="https://www.youtube.com/watch?v=LXb3EKWsInQ" class="glightbox btn-watch-video d-flex align-items-center"><i class="bi bi-play-circle"></i><span>Xem Video</span></a>
                                    </div>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/banhxeo.jpeg" class="img-fluid banhxeo " alt="" data-aos="zoom-out" data-aos-delay="300">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="carousel-item">
                    <section id="hero" class="hero d-flex align-items-center section-bg">
                        <div class="container">
                            <div class="row justify-content-between gy-5">
                                <div class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start">
                                    <h2 data-aos="fade-up">Bánh Cuốn<br>Món Ăn Phổ Biến Ở Miền Trung</h2>
                                    <p data-aos="fade-up" data-aos-delay="100">Một món bánh cuốn ngon sẽ được tráng thật kỹ lưỡng, đảm bảo độ mỏng dính vừa phải nhưng lại vừa dai thơm. Bên trong ruột sẽ là phần nhân với thịt heo, tôm, mộc nhĩ, nấm hương. Phía trên bánh sẽ rắc thêm chút hành phi, khi ăn ta sẽ chấm với nước mắm tỏi ớt là số 1.</p>
                                    <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
                                        <a href="#book-a-table" class="btn-book-a-table">Đặt Mua</a>
                                        <a href="https://www.youtube.com/watch?v=LXb3EKWsInQ" class="glightbox btn-watch-video d-flex align-items-center"><i class="bi bi-play-circle"></i><span>Xem Video</span></a>
                                    </div>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/banhcuon.jpeg" class="img-fluid banhxeo " alt="" data-aos="zoom-out" data-aos-delay="300">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="carousel-item">
                    <section id="hero" class="hero d-flex align-items-center section-bg">
                        <div class="container">
                            <div class="row justify-content-between gy-5">
                                <div class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start">
                                    <h2 data-aos="fade-up">Bún Chả<br>Món Ăn Phổ Biến Ở Miền Băc</h2>
                                    <p data-aos="fade-up" data-aos-delay="100">Bún chả là thức quà có sức sống bền lâu nhất của vùng đất Hà thành. Những viên chả thơm ngon được làm từ thịt nạc vai băm nhỏ, viên tròn, thêm một vài lát thịt ba chỉ thái lát, nướng vàng ăn kèm với bún, nước mắm pha loãng. Món ngon còn có vị chua của dưa góp cùng mùi thơm hài hòa của tỏi và sự thanh mát của rau sống ăn kèm.</p>
                                    <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
                                        <a href="#book-a-table" class="btn-book-a-table">Đặt Mua</a>
                                        <a href="https://www.youtube.com/watch?v=LXb3EKWsInQ" class="glightbox btn-watch-video d-flex align-items-center"><i class="bi bi-play-circle"></i><span>Xem Video</span></a>
                                    </div>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/buncha.jpeg" class="img-fluid banhxeo " alt="" data-aos="zoom-out" data-aos-delay="300">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <!--EndSlide hero section-->
        <!-- ======= Hero Section ======= -->



        <!-- ======= Menu Section ======= -->
        <section id="menu" class="menu">
            <div class="container" data-aos="fade-up">

                <div class="section-header">

                    <p>Bán<span> Chạy Nhất</span></p>
                </div>

                <div class="tab-content" data-aos="fade-up" data-aos-delay="300">

                    <div class="tab-pane fade active show" id="menu-starters">

                        <div class="row gy-5">

                            <div class="col-lg-4 menu-item">
                                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                                <h4>Bánh Xèo</h4>
                                <p class="ingredients">
                                    3-4 người ăn
                                </p>
                                <p class="price">
                                    200.000 VNĐ
                                </p>
                            </div><!-- Menu Item -->

                            <div class="col-lg-4 menu-item">
                                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                                <h4>Cá Kho Tộ</h4>
                                <p class="ingredients">
                                    2-3 người ăn
                                </p>
                                <p class="price">
                                    150.000 VNĐ
                                </p>
                            </div><!-- Menu Item -->

                            <div class="col-lg-4 menu-item">
                                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                                <h4>Bánh Xèo</h4>
                                <p class="ingredients">
                                    3-4 người ăn
                                </p>
                                <p class="price">
                                    200.000 VNĐ
                                </p>
                            </div><!-- Menu Item -->


                        </div><!-- End Breakfast Menu Content -->

                        <!-- ======= Stats Counter Section ======= -->
                        <section id="stats-counter" class="stats-counter">
                            <div class="container" data-aos="zoom-out">

                                <div class="row gy-4">

                                    <div class="col-lg-3 col-md-6">
                                        <div class="stats-item text-center w-100 h-100">
                                            <span data-purecounter-start="0" data-purecounter-end="2000" data-purecounter-duration="1" class="purecounter"></span>
                                            <p>Lượt truy cập</p>
                                        </div>
                                    </div><!-- End Stats Item -->

                                    <div class="col-lg-3 col-md-6">
                                        <div class="stats-item text-center w-100 h-100">
                                            <span data-purecounter-start="0" data-purecounter-end="100" data-purecounter-duration="1" class="purecounter"></span>
                                            <p>Món Ăn</p>
                                        </div>
                                    </div><!-- End Stats Item -->

                                    <div class="col-lg-3 col-md-6">
                                        <div class="stats-item text-center w-100 h-100">
                                            <span data-purecounter-start="0" data-purecounter-end="1453" data-purecounter-duration="1" class="purecounter"></span>
                                            <p>Lượt mua</p>
                                        </div>
                                    </div><!-- End Stats Item -->

                                    <div class="col-lg-3 col-md-6">
                                        <div class="stats-item text-center w-100 h-100">
                                            <span data-purecounter-start="0" data-purecounter-end="32" data-purecounter-duration="1" class="purecounter"></span>
                                            <p>Đánh giá tốt</p>
                                        </div>
                                    </div><!-- End Stats Item -->

                                </div>

                            </div>
                        </section><!-- End Stats Counter Section -->
                        </main><!-- End #main -->
                        <!-- Start Footer -->
                        <jsp:include page="Footer.jsp" />
                    </div>
                </div>
                     </div>
                     </div>
                        <!-- End Footer -->

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
