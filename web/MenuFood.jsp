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
        <link href="assets/css/MenuFood.css" rel="stylesheet">
        <link href="assets/css/Header.css" rel="stylesheet">

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>Thực Đơn</title>
    </head>
    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content">
            <div class="row">
                <div class="col-md-12 menu-title">
                    <h1 id="title-list">Danh Sách Thực Đơn</h1>
                </div>
            </div>
            <div class="box-menu box-list">
                <ul class="list-group row">
                    <%
                        ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("MenuFood");
                        if (list != null && !list.isEmpty()) {
                            int count = 0;
                            for (Menu m : list) {
                                if (m.isMenuStatus()) {
                                    count++;
                    %>
                    <div class="frame-menu" style="border-width: 3px;
                         border-style: solid;
                         border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                        <form action="MainController?action=menudetail" method="POST">
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
                        </form>
                        <form action="MainController?action=deletemenu" method="POST">
                            <input type="hidden" name="menuid" value="<%= m.getMenuID()%>">
                            <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
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
                        } else {
                        %>
                    <li class="list-group-item">Chưa Có Thực Đơn Nào</li>
                        <%
                            }
                        %>
                    <a href="MainController?action=createmenu">
                        <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-primary">
                            Tự Thêm Thực Đơn Mới 
                        </button>
                    </a>
                </ul>
            </div>
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>




</html>
