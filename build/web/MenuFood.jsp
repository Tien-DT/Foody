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
        <title>JSP Page</title>
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
                    ArrayList<Menu> list = (ArrayList<Menu>) session.getAttribute("MenuFood");
                    if (list != null && !list.isEmpty()) {
                        int count = 0;
                        for (Menu m : list) {
                            if (m.isMenuStatus()) {
                                count++;
                %>
                <form action="MainController?action=" method="POST">
                    <input type="hidden" name="menuId" value="<%= m.getMenuID()%>">
                    <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success">
                        <%= m.getMenuName() %>
                    </button>
                </form>
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
