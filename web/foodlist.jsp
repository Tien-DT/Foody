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
  <link href="assets/css/main.css" rel="stylesheet">

 
</head>

<body>
    <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <a href="Maincontroller" action="home" class="logo d-flex align-items-center me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1>Foody<span>.</span></h1>
      </a>

      <nav id="navbar" class="navbar">
        <ul>
            <li><a href="MainController?action=home">Trang Chủ</a></li>
          <li><a href="MainController?action=food">Món Ăn</a></li>
          <li><a href="MainController?action=video">Video</a></li>
          <li><a href="MainController?action=shop">Mua Sắm</a></li>
          </li>
          <li><a href="MainController?action=loginform">Đăng Nhập / Đăng Kí</a></li>
        </ul>
      </nav><!-- .navbar -->

    
      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header><!-- End Header -->
    <!-- ======= Menu Section ======= -->
    <section class="row">
        <div class="col-md-2">
            <!-- Filter For List -->
            <h1 id="filter">Filter</h1>
      <label for="min-price">Tối thiểu:</label>
      <input type="number" id="min-price" name="min-price">
      <label for="max-price">Tối đa:</label>
      <input type="number" id="max-price" name="max-price">
      <label for="food-type">Loại món ăn:</label>
      <select id="food-type" name="food-type">
        <option value="">Tất cả</option>
        <option value="nước">Nước</option>
        <option value="khô">Khô</option>
      </select>
      <label for="min-rating">Đánh giá tối thiểu:</label>
      <select id="min-rating" name="min-rating">
        <option value="">Tất cả</option>
        <option value="1">1 sao</option>
        <option value="2">2 sao</option>
        <option value="3">3 sao</option>
        <option value="4">4 sao</option>
        <option value="5">5 sao</option>
      </select>
      <button onclick="filterMenu()">Lọc</button>
    </div>
            
        </div>
    <section id="menu" class="menu col-md-10">
      <div class="container" data-aos="fade-up">

        <div class="section-header">
       
          <p>Danh Sách Nguyên Liệu</p>
        </div>

        <div class="tab-content" data-aos="fade-up" data-aos-delay="300">

          <div class="tab-pane fade active show" id="menu-starters">

            <div class="row gy-5">

              <div class="col-lg-4 menu-item">
                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                <h4><a href="MainController?action=home">Bánh Xèo</a></h4>
                <p class="ingredients">
                    3-4 người ăn
                </p>
                <p class="price">
                  200.000 VNĐ
                </p>
              </div><!-- Menu Item -->

              <div class="col-lg-4 menu-item">
                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                <h4><a href="MainController?action=home">Cá Kho Tộ</a></h4>
                <p class="ingredients">
                    2-3 người ăn
                </p>
                <p class="price">
                  150.000 VNĐ
                </p>
              </div><!-- Menu Item -->

              <div class="col-lg-4 menu-item">
                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                <h4><a href="MainController?action=home">Bánh Tráng Trộn</a></h4>
                <p class="ingredients">
                    3-4 người ăn
                </p>
                <p class="price">
                  200.000 VNĐ
                </p>
              </div>
              
              <div class="tab-content" data-aos="fade-up" data-aos-delay="300">

          <div class="tab-pane fade active show" id="menu-starters">

            <div class="row gy-5">

              <div class="col-lg-4 menu-item">
                <a href="assets/img/menu/menu-item-1.png" class="glightbox"><img src="assets/img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                <h4><a href="MainController?action=home">Khoai Tây Lắc</a></h4>
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
    </div>

  </footer><!-- End Footer -->
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
