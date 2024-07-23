<%@page import="DTO.Order"%>
<%@page import="DTO.Food"%>
<%@page import="DTO.Menu"%>
<%@page import="DTO.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="assets/css/StaffDashBoard.css" rel="stylesheet">
        <link href="assets/css/Footer.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>Dashboard</title>
    </head>
    <body>
        <%@include file="Header.jsp" %> 
        <div class="container body-content" style="margin-top: 100px; min-height: 75%;">
            <h1>Bảng điều khiển cho Nhân Viên</h1>
            <%  int role = (int) session.getAttribute("Role");
                int userIDSession = (int) session.getAttribute("LoginedUID");
                if (role == 0) {
                    request.getRequestDispatcher("Index").forward(request, response);
                }
                String function = (String) request.getAttribute("Function");
                String action = (String) request.getAttribute("Action");

            %>
            <div class="row">
                <div class="col-12">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-order-list" data-bs-toggle="list" href="#list-order" role="tab" aria-controls="home">Quản Lý Đơn hàng</a>
                        <a class="list-group-item list-group-item-action" id="list-menu-list" data-bs-toggle="list" href="#list-menu" role="tab" aria-controls="profile">Quản Lý Menu và Món Ăn</a>
                        <a class="list-group-item list-group-item-action" id="list-user-list" data-bs-toggle="list" href="#list-user" role="tab" aria-controls="messages">Quản Lý Người dùng</a>

                    </div>
                </div>
                <div class="col-12" style="margin-top:20px;">
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="list-order" role="tabpanel" aria-labelledby="list-home-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listorder" class="btn btn-primary">Danh Sách Đơn Hàng</button> 
                                <div style="margin-top: 10px;">
                                    <div class="input-group">
                                        <input type="text" class="form-control rounded" placeholder="<%                                String searchContent = (String) request.getAttribute("SearchContent");
                                            if (searchContent != null) {
                                                out.print(searchContent);
                                            } else {
                                                out.print("Nhập Mã đơn hàng, số điện thoại, email, tên người nhận cần tìm");
                                            }
                                               %>" aria-label="Search" aria-describedby="search-addon" name="txtsearchorder" />
                                        <input type="hidden" name="menu" value="searchorder">
                                        <button type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>Tìm Kiếm</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="tab-pane fade" id="list-menu" role="tabpanel" aria-labelledby="list-profile-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listmenu" class="btn btn-success">Danh sách menu</button>
                                <button type="submit" name="menu" value="addmenu" class="btn btn-primary">Thêm Menu</button>
                                <button type="submit" name="menu" value="deletemenu" class="btn btn-danger">Xóa Menu</button>
                                <button type="submit" name="menu" value="addfoodlist" class="btn btn-info">Thêm món ăn vào danh sách</button>    
                                <button type="submit" name="menu" value="disablefoodlist" class="btn btn-dark">Sửa, ẩn hiện món ăn</button> 
                            </form>
                        </div>
                        <div class="tab-pane fade" id="list-user" role="tabpanel" aria-labelledby="list-messages-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listuser" class="btn btn-primary">Danh Sách Người Dùng</button>

                            </form>

                        </div>                 
                    </div>
                </div>
            </div>
            <%                       String resultAll = (String) request.getAttribute("ResultAll");
                if (resultAll != null) {
            %><h2 style="color: green;"><%=resultAll%></h2><%
                }
                request.removeAttribute("ResultAll");
            %>

            <!--FUNCTION LIST ORDER BY STAFF -->

            <%                            String statusColor = null;
                String status = null;
                ArrayList<Order> listOrder = (ArrayList<Order>) request.getAttribute("ListOrder");
                if (listOrder != null && !listOrder.isEmpty()) {
                    for (Order o : listOrder) {
                        if (o.getOrderStatus() == 1) {
                            status = "Đang chờ Nhân Viên xác nhận";
                            statusColor = "btn btn-secondary";
                        } else if (o.getOrderStatus() == 2) {
                            status = "Nhân Viên đang gói hàng";
                            statusColor = "btn btn-info";
                        } else if (o.getOrderStatus() == 3) {
                            status = "Đơn hàng đang được vận chuyển";
                            statusColor = "btn btn-warning";
                        } else if (o.getOrderStatus() == 4) {
                            status = "Giao hàng thành công";
                            statusColor = "btn btn-success";
                        }

            %>
            <div class="frame-menu" style="border-width: 3px;
                 border-style: solid;
                 border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                <div style="margin:10px;">
                    Mã đơn hàng: <%=o.getOrderID()%><br> 
                    Ngày Đặt Hàng: <%=o.getOrderDate()%><br>
                    Nội Dung:<br> <%=o.getOrderDetail()%><br>
                    Số điện thoại nhận hàng: <%=o.getOrderPhone()%><br>
                    Địa chỉ nhận hàng: <%=o.getOrderAddress()%><br>
                    <div class="<%=statusColor%>">
                        <%=status%>
                    </div>
                </div>
            </div>   

            <%if (o.getOrderStatus() == 1) {%>
            <form action="MainController?action=funcdashboard" method="POST">
                <input type="hidden" name="orderstatus" value="2">
                <input type="hidden" name="orderid" value="<%=o.getOrderID()%>">
                <input type="hidden" name="menu" value="updateorder">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                    Xác nhận Đơn Hàng và đóng gói: <%=o.getOrderID()%>
                </button>
            </form>
            <form action="MainController?action=funcdashboard" method="POST">
                <input type="hidden" name="orderstatus" value="2">
                <input type="hidden" name="orderid" value="<%=o.getOrderID()%>">
                <input type="hidden" name="menu" value="cancelorder">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                    Hủy Đơn Hàng: <%=o.getOrderID()%>
                </button>
            </form>


            <%
            } else if (o.getOrderStatus() == 2) {
            %>
            <form action="MainController?action=funcdashboard" method="POST">
                <input type="hidden" name="orderstatus" value="3">
                <input type="hidden" name="orderid" value="<%=o.getOrderID()%>">
                <input type="hidden" name="menu" value="updateorder">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                    Đang Vận Chuyển: <%=o.getOrderID()%>
                </button>
            </form>


            <%

            } else if (o.getOrderStatus() == 3) {
            %>
            <form action="MainController?action=funcdashboard" method="POST">
                <input type="hidden" name="orderstatus" value="4">
                <input type="hidden" name="orderid" value="<%=o.getOrderID()%>">
                <input type="hidden" name="menu" value="updateorder">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                    Giao hàng thành công: <%=o.getOrderID()%>
                </button>
            </form>


            <%

                        }

                    }

                }

            %>

            <!--FUNCTION LIST ORDER BY STAFF -->

            <!--FUNCTION ADD MENU FORM BY STAFF -->
            <%                    if (function != null) {
                    if (function.contains("ADDMENU")) {


            %>
            <form action="MainController?action=funcdashboard" method="POST">

                <div class="mb-3">
                    <label for="Tên Thực Đơn" class="form-label">Email Người Dùng</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtemail" required>
                </div>
                <div class="mb-3">
                    <label for="Tên Thực Đơn" class="form-label">Tên Thực Đơn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtmenuname" required>
                </div>
                <select type="text" id="inputState" class="form-control" name="txtweek" required>
                    <option selected>Chọn Tuần</option>
                    <option value="1">Tuần 1</option> 
                    <option value="2">Tuần 2</option>
                    <option value="3">Tuần 3</option> 
                    <option value="4">Tuần 4</option>
                    <option value="5">Tuần 5</option>
                </select>

                <div class="mb-3">
                    <label for="Tên Nhãn" class="form-label">Tên Nhãn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txttag" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="menu" value="addmenunow">Tạo Thực Đơn</button>
                </div>
            </form>



         
                <%                      function = null;
                        }

                    }
                %>
                <!--FUNCTION ADD MENU FORM BY STAFF -->

                <!--FUNCTION SHOW LIST USER -->
                <%  if (function != null) {
                        if (function.contains("LISTUSER")) {
                            ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("ListAllUser");

                            if (listUser != null) {

                                for (User u : listUser) {


                %>
                
                <div class="frame-menu" style="border-width: 1px;
                     border-style: solid;
                     border-color: black ;border-radius: 10px; margin-bottom: 30px;">


                    ID Người Dùng: <%= u.getUserID()%><br>
                    Tên Người Dùng: <%= u.getFullName()%><br>
                    Email Người Dùng: <%= u.getEmail()%><br>
                    Loại Người Dùng: <%
                        if (u.isRole()) {
                            out.print("Nhân Viên");
                        } else {
                            out.print("Người Dùng");
                        }
                    %><br>                    
                    Trạng Thái: <%if (u.isUserStatus()) {
                            out.print("Hoạt Động");
                        } else {
                            out.print("Đã Khóa");
                        }%>
               </div>
                    <%if (u.isUserStatus()&& u.getUserID() != userIDSession) {%>  
                    <form action="MainController?action=funcdashboard" method="POST">
                        <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                        <input type="hidden" name="menu" value="disableuser">
                        <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger" name="menu" value="deletemenunow">
                            Khóa Người Dùng: <%=u.getUserID() %>
                        </button>
                    </form>
                    <%
                    } else if(!u.isUserStatus() && u.getUserID() != userIDSession) {
                    %>
                    <form action="MainController?action=funcdashboard" method="POST">
                        <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                        <input type="hidden" name="menu" value="enableuser">
                        <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success" name="menu" value="deletemenunow">
                            Mở Khóa Người Dùng: <%=u.getUserID() %>
                        </button>
                    </form>
                    <%
                        }
                        if (!u.isRole()) {
                    %>

                    <form action="MainController?action=funcdashboard" method="POST">
                        <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                        <input type="hidden" name="menu" value="setstaff">
                        <input type="hidden" name="role" value="1">
                        <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-primary">
                            Đặt tài khoản <%=u.getUserID() %> thành nhân viên
                        </button>
                    </form>
               
                <%              } else if (u.isRole() && u.getUserID() != userIDSession) {%>
                <form action="MainController?action=funcdashboard" method="POST">
                    <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                    <input type="hidden" name="menu" value="setstaff">
                    <input type="hidden" name="role" value="0">
                    <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-primary">
                        Đặt tài khoản <%=u.getUserID() %> thành người dùng
                    </button>
                </form>
                    
           
            <%              }
                            }
                        }
                        function = null;
                    }
                }
            %>
            

            <!--FUNCTION ADD MENU BY STAFF -->

            <!--FUNCTION DELETE MENU BY STAFF -->

            <%
                ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("MenuFoodStaff");

                if (list != null && !list.isEmpty()) {
                    int count = 0;
                    for (Menu m : list) {
                        if (m.isMenuStatus()) {
                            count++;
            %>
            <div class="frame-menu" style="border-width: 3px;
                 border-style: solid;
                 border-color: #0dcaf0;border-radius: 15px;margin: 10px;">

                <input type="hidden" name="menuid" value="<%= m.getMenuID()%>">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success">
                    Tên Menu: <%= m.getMenuName()%><br>
                    Tuần: <%= m.getMenuDate()%><br>
                    Nhãn Menu: <%= m.getMenuTag()%><br>
                    Menu Tạo bởi: <%
                        if (!m.isMenuRole()) {
                            out.print("Người dùng");
                        } else {
                            out.print("Nhân viên");
                        }
                    %><br>
                </button>

                <form action="MainController?action=funcdashboard" method="POST">
                    <input type="hidden" name="menuid" value="<%= m.getMenuID()%>">
                    <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger" name="menu" value="<%=action%>">
                        Xóa thực đơn
                    </button>
                </form>
            </div>
            <%
                    }
                }
                if (count == 0) {
            %>
            <li class="list-group-item">Chưa Có Thực Đơn Nào</li>
                <%
                        }
                    }
                %>
            <!--FUNCTION DELETE MENU BY STAFF -->

            <!--FUNCTION VIEW MENU BY STAFF -->
            <%
                ArrayList<Menu> listMenu = (ArrayList<Menu>) request.getAttribute("MenuFood");
                if (listMenu != null && !listMenu.isEmpty()) {
                    int count = 0;
                    for (Menu m : listMenu) {
                        if (m.isMenuStatus()) {

            %>
            <div class="frame-menu" style="border-width: 3px;
                 border-style: solid;
                 border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                <form action="MainController?action=menudetail" method="POST">
                    <input type="hidden" name="menuid" value="<%= m.getMenuID()%>">
                    <input type="hidden" name="function" value="VIEWMENU">
                    <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success">
                        ID Người Dùng: <%=m.getUserID()%><br>
                        Tên Menu: <%= m.getMenuName()%><br>
                        Tuần: <%= m.getMenuDate()%><br>
                        Nhãn Menu: <%= m.getMenuTag()%><br>
                        Menu Tạo bởi: <%
                            if (!m.isMenuRole()) {
                                out.print("Người dùng");
                            } else {
                                out.print("Nhân viên");
                            }
                        %><br>
                    </button>

                </form>
            </div>
            <%
                        }
                    }
                }
            %>
            <!--FUNCTION VIEW MENU BY STAFF -->

            <!--FUNCTION ADD FOODLIST BY STAFF -->
            <%
                if (function != null) {
                    if (function.contains("ADDFOODLISTFORM")) {


            %>
            <form action="MainController?action=funcdashboard" method="POST">

                <div class="mb-3">
                    <label for="Tên Thực Đơn" class="form-label">Tên Món Ăn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtname" required>
                </div>
                <div class="mb-3">
                    <label for="Nội Dung" class="form-label">Nội Dung</label>
                    <textarea class="form-control" id="formGroupExampleInput" name="txtfoodstep" rows="10" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="Giá món ăn" class="form-label">Giá món ăn</label>
                    <input type="number" class="form-control" id="formGroupExampleInput" name="txtprice" required>
                </div>

                <div class="mb-3">
                    <label for="Đường link đến thư mục chứa hình ảnh món ăn" class="form-label">Đường link đến thư mục chứa hình ảnh món ăn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtpath" placeholder="assets\img\ten_mon_an.jpeg" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="menu" value="addfoodlistnow">Thêm Món Ăn</button>
                </div>
            </form>
            <%                      function = null;
                    }

                }

                String resultFoodList = (String) request.getAttribute("Result");
                if (resultFoodList != null) {
                    out.print(resultFoodList);
                }
                request.removeAttribute("Result");

            %>
            <!--FUNCTION ADD FOODLIST BY STAFF -->

            <!-- DELETE FOOD LIST -->
            <div>
                <%                if (function != null && function.contains("DISABLEFOODLIST")) {
                        ArrayList<Food> listFoodDelete = (ArrayList) request.getAttribute("DisableFoodList");
                        if (listFoodDelete != null) {
                            for (Food f : listFoodDelete) {


                %>

                <div class="col-md-3">
                    <a href="<%=f.getFoodImage()%>" class="glightbox item-card">
                        <img src="<%= f.getFoodImage()%>" class="card-img-top menu-img img-fluid rounded food-img" class="rounded" width="300" width="300" alt="">
                    </a>
                    <div class="card-body d-flex flex-column" style="min-height: 200px;">
                        <h4 class="card-title"><%= f.getFoodName()%></h4>                                     
                        <p class="card-text">
                        </p>

                        <form action="MainController?action=funcdashboard" method="POST">
                            <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                            <input type="hidden" name="menu" value="updateinfofood">  
                            <a><button class="btn btn-warning button-card">Chỉnh Sửa Món Ăn</button></a>
                        </form>
                        <%
                            if (f.getFoodStatus()) {
                        %>
                        <form action="MainController?action=funcdashboard" method="POST">
                            <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                            <input type="hidden" name="menu" value="disablefoodlistnow">                            
                            <a><button class="btn btn-danger button-card">Ẩn Món Ăn</button></a>
                        </form>  

                        <%
                        } else {
                        %>
                        <form action="MainController?action=funcdashboard" method="POST">
                            <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                            <input type="hidden" name="menu" value="enablefoodlistnow">                            
                            <a><button class="btn btn-info button-card">Hiện Món Ăn</button></a>
                        </form> 
                        <%
                            }
                        %>
                    </div>
                </div>

                <%
                            }
                        }
                    }


                %>
            </div>
            <!-- DELETE FOOD LIST -->

            <!--UPDATE FOOD LIST -->
            <%                if (function != null && function.contains("UPDATEFOOD")) {
                    Food foodUpdate = (Food) request.getAttribute("FoodUpdate");
            %>
            <form action="MainController?action=funcdashboard" method="POST">
                <input type="hidden" name="foodid" value="<%=foodUpdate.getFoodID()%>"> 
                <div class="mb-3">
                    <label for="Tên Thực Đơn" class="form-label">Tên Món Ăn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtname" value="<%=foodUpdate.getFoodName()%>" required>
                </div>
                <div class="mb-3">
                    <label for="Nội Dung" class="form-label">Nội Dung</label>
                    <textarea class="form-control" id="formGroupExampleInput" name="txtfoodstep" rows="10" required><%=foodUpdate.getFoodStep()%></textarea>
                </div>

                <div class="mb-3">
                    <label for="Giá Món Ăn" class="form-label">Giá món ăn</label>
                    <input type="number" class="form-control" id="formGroupExampleInput" name="txtprice" value="<%=foodUpdate.getFoodPrice()%>" required>
                </div>

                <div class="mb-3">
                    <label for="Đường link đến thư mục chứa hình ảnh món ăn" class="form-label">Đường link đến thư mục chứa hình ảnh món ăn</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="txtpath" value="<%=foodUpdate.getFoodImage()%>" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="menu" value="updateinfofoodnow">Lưu Món Ăn</button>
                </div>
            </form>
            <%
                }
            %>


            <!--UPDATE FOOD LIST -->
        </div>

    </div>
    <%@include file="Footer.jsp" %>
</body>
</html>
