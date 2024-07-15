<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Trang chủ-Foody.</title>
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <link href="assets/css/Main.css" rel="stylesheet">
      


    </head>

    <body>

        <!-- ======= Header ======= -->
        <jsp:include page="Header.jsp" />
        <!-- End Header -->
        <div style="min-height: 85%!important;">
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
                                    <h2>Bánh Xèo<br>Món Ăn Phổ Biến Ở Miền Nam</h2>
                                    <p>Món ăn này thường xuất hiện ở Nam Trung Bộ và các tỉnh miền Nam. Bánh xèo ở từng vùng miền sẽ khác nhau về màu sắc, kích cỡ, loại nhân bên trong, nước chấm. Điểm chung của tất cả các loại đều được làm từ bột gạo tẻ pha loãng, sau đó được tráng mỏng trên chảo và chiên giòn.</p>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/banhxeo.jpeg" class="img-fluid banhxeo " alt="">
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
                                    <h2>Bánh Cuốn<br>Món Ăn Phổ Biến Ở Miền Trung</h2>
                                    <p>Một món bánh cuốn ngon sẽ được tráng thật kỹ lưỡng, đảm bảo độ mỏng dính vừa phải nhưng lại vừa dai thơm. Bên trong ruột sẽ là phần nhân với thịt heo, tôm, mộc nhĩ, nấm hương. Phía trên bánh sẽ rắc thêm chút hành phi, khi ăn ta sẽ chấm với nước mắm tỏi ớt là số 1.</p>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/banhcuon.jpeg" class="img-fluid banhxeo " alt="">
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
                                    <p>Bún chả là thức quà có sức sống bền lâu nhất của vùng đất Hà thành. Những viên chả thơm ngon được làm từ thịt nạc vai băm nhỏ, viên tròn, thêm một vài lát thịt ba chỉ thái lát, nướng vàng ăn kèm với bún, nước mắm pha loãng. Món ngon còn có vị chua của dưa góp cùng mùi thơm hài hòa của tỏi và sự thanh mát của rau sống ăn kèm.</p>
                                </div>
                                <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                                    <img src="assets/img/buncha.jpeg" class="img-fluid banhxeo " alt="">
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
        
                        
                    </div>
        </div>
                <jsp:include page="Footer.jsp" />
                        <!-- End Footer -->

                        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                        <script src="assets/vendor/aos/aos.js"></script>
                        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
                        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
                        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
                        <script src="assets/vendor/php-email-form/validate.js"></script>

                        <script src="assets/js/main.js"></script>

                        </body>
                        </html>
