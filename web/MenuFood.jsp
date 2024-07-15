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
            <div class="row">
                <div clas="col-md-12">
                    <form class="form-inline" action="MainController?action=searchmenu" method="POST">
                        <div class="input-group">
                            <input type="text" class="form-control rounded" placeholder="<%
                                String searchContent = (String) request.getAttribute("SearchContent");                                
                                if (searchContent != null) {
                                    out.print(searchContent);
                                } else {
                                    out.print("Nhập tên thực đơn cần tìm");
                                }
                                   %>" aria-label="Search" aria-describedby="search-addon" name="txtsearch" />
                            <button type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>Tìm Kiếm</button>
                        </div>
                    </form>
                </div>
                <div class="box-menu box-list col-md-12">
                    <ul class="list-group row">
                        <%
                            ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("MenuFood");
                            if (list != null && !list.isEmpty()) {
                                int count = 0;
                                for (Menu m : list) {
                                    if (m.isMenuStatus()) {
                                        
                        %>
                        <div class="frame-menu" style="border-width: 3px;
                             border-style: solid;
                             border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                            <form action="MainController?action=menudetail" method="POST">
                                <input type="hidden" name="menuid" value="<%= m.getMenuID()%>">
                              <input type="hidden" name="function" value="VIEWMENU">
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
                                request.removeAttribute("SearchContent");
                            
                        %>

                        <%                            } else {
                        %>
                        <li class="list-group-item">Không Có Thực Đơn Nào</li>
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
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>




</html>
