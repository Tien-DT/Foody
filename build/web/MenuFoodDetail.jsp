<%-- 
    Document   : MenuFoodDetail
    Created on : Jul 4, 2024, 5:49:00 PM
    Author     : USER
--%>

<%@page import="DTO.MenuDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/MenuFoodDetail.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>

    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content">

            <div class="box-menu col-md-12 box-body">
                <h1 class="text-center my-4">Thực Đơn Chi Tiết</h1>
                <!-- Header Row -->
                <div class="row schedule">
                    <div class="col-12 col-md-2 day">Thứ Hai</div>
                    <div class="col-12 col-md-2 day">Thứ Ba</div>
                    <div class="col-12 col-md-2 day">Thứ Tư</div>
                    <div class="col-12 col-md-2 day">Thứ Năm</div>
                    <div class="col-12 col-md-2 day">Thứ Sáu</div>
                    <div class="col-12 col-md-2 day">Thứ Bảy</div>
                </div>
                <!-- Time Slots -->
                <%
                    ArrayList<MenuDetail> monday = new ArrayList<>();
                    ArrayList<MenuDetail> tuesday = new ArrayList<>();
                    ArrayList<MenuDetail> wednesday = new ArrayList<>();
                    ArrayList<MenuDetail> thursday = new ArrayList<>();
                    ArrayList<MenuDetail> friday = new ArrayList<>();
                    ArrayList<MenuDetail> saturday = new ArrayList<>();
                    ArrayList<MenuDetail> list = (ArrayList) request.getAttribute("MenuDetail");
                    if (list != null) {
                        for (MenuDetail md : list) {
                            // Lấy ngày của menu (ví dụ: 2 cho thứ 2, 3 cho thứ 3, ...)
                            int menuDay = md.getMenuDay();

                            // Thêm MenuDetail vào ArrayList tương ứng với ngày của nó
                            switch (menuDay) {
                                case 2:
                                    monday.add(md);
                                    break;
                                case 3:
                                    tuesday.add(md);
                                    break;
                                case 4:
                                    wednesday.add(md);
                                    break;
                                case 5:
                                    thursday.add(md);
                                    break;
                                case 6:
                                    friday.add(md);
                                    break;
                                case 7:
                                    saturday.add(md);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }


                %>
                <div class="row schedule">
                    <!-- Thứ Hai -->
                    <div class="col-12 col-md-2">

                        <div class="menu-items">
                            <%            for (MenuDetail menu : monday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>

                    </div>
                    <!-- Thứ Ba -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : tuesday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                    <!-- Thứ Tư -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : wednesday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Năm -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : thursday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Sáu -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : friday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Bảy -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : saturday) {
                            %>
                            <div class="menu-item">
                                <h4><%= menu.getFoodName()%></h4>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>



</html>
