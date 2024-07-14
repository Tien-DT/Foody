<%@page import="DTO.Menu"%>
<%@page import="DTO.User"%>
<%@page import="DTO.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="assets/css/StaffDashBoard.css" rel="stylesheet">
        <link href="assets/css/Footer.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>Giỏ Hàng</title>
    </head>
    <body>
        <%@include file="Header.jsp" %> 
        <div class="container body-content" style="margin-top: 100px; min-height: 75%;">
            <h1>Bảng điều khiển cho Nhân Viên</h1>
            <%
                String function = (String) request.getAttribute("Function");
                String action = (String) request.getAttribute("Action");
            %>
            <div class="row">
                <div class="col-12">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-order-list" data-bs-toggle="list" href="#list-order" role="tab" aria-controls="home">Quản Lý Đơn hàng</a>
                        <a class="list-group-item list-group-item-action" id="list-menu-list" data-bs-toggle="list" href="#list-menu" role="tab" aria-controls="profile">Quản Lý Menu</a>
                        <a class="list-group-item list-group-item-action" id="list-user-list" data-bs-toggle="list" href="#list-user" role="tab" aria-controls="messages">Quản Lý Người dùng</a>

                    </div>
                </div>
                <div class="col-12" style="margin-top:20px;">
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="list-order" role="tabpanel" aria-labelledby="list-home-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listorder" class="btn btn-primary">Danh Sách Đơn Hàng</button>
                                <button type="submit" name="menu" value="statusorder" class="btn btn-danger">Chuyển trạng thái đơn hàng</button>
                            </form>

                        </div>
                        <div class="tab-pane fade" id="list-menu" role="tabpanel" aria-labelledby="list-profile-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listmenu" class="btn btn-success">Danh sách menu</button>
                                <button type="submit" name="menu" value="addmenu" class="btn btn-primary">Thêm Menu</button>
                                <button type="submit" name="menu" value="deletemenu" class="btn btn-danger">Xóa Menu</button>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="list-user" role="tabpanel" aria-labelledby="list-messages-list">
                            <form action="MainController?action=funcdashboard" method="POST">
                                <button type="submit" name="menu" value="listuser" class="btn btn-primary">Danh Sách Người Dùng</button>

                            </form>

                        </div>                 
                    </div>
                </div>
                <!--FUNCTION ADD MENU BY STAFF -->
                <%
                    if (function != null) {
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
               
                
                 
                <div>
                    <%                      function = null;
                            }

                        }

                        String result = (String) request.getAttribute("Result");
                        if (result != null) {
                            out.print(result);
                        }
                        request.removeAttribute("Result");

                    %>
                     <!--FUNCTION ADD MENU BY STAFF -->
                     
                   <!--FUNCTION SHOW LIST USER -->
                    <%  if (function != null) {
                            if (function.contains("LISTUSER")) {
                                ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("ListAllUser");

                                if (listUser != null) {

                                    for (User u : listUser) {
                                     

                    %>
                    <div class="frame-menu" style="border-width: 3px;
                         border-style: solid;
                         border-color: #0dcaf0;border-radius: 15px;margin: 10px;">


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
                        Trạng Thái: <%if(u.isUserStatus()){
                               out.print("Hoạt Động");
                        }else{
                            out.print("Đã Khóa");
                        }%>
                        <%if(u.isUserStatus()){ %>  
                        <form action="MainController?action=funcdashboard" method="POST">
                            <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                            <input type="hidden" name="menu" value="disableuser">
                            <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger" name="menu" value="deletemenunow">
                                Khóa Người Dùng
                            </button>
                        </form>
                            <%
                            }else{
                            %>
                            <form action="MainController?action=funcdashboard" method="POST">
                            <input type="hidden" name="userid" value="<%= u.getUserID()%>">
                            <input type="hidden" name="menu" value="enableuser">
                            <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success" name="menu" value="deletemenunow">
                               Mở Khóa Người Dùng
                            </button>
                        </form>
                            <%
                                }
                            %>
                    </div>
                    <%
                                    }
                                }
                                function = null;
                            }
                        }
                    %>

                </div>
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
                            ID Người Dùng: <%=m.getUserID() %><br>
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

            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
