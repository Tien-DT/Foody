<%@page import="java.util.ArrayList"%>
<%@page import="DTO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/UserFood.css" rel="stylesheet">
        <link href="assets/css/Header.css" rel="stylesheet">

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>Danh Sách Người Dùng</title>
    </head>
    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content" style= "margin-top: 100px; min-height: 75%;">
            <div class="row">
                <div class="col-md-12 menu-title">
                    <h1 id="title-list">Danh Sách Người Dùng</h1>
                </div>
            </div>
            <div class="box-menu box-list">
                <ul class="list-group row">
                    <%
                        ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("ListAllUser");

                        if (listUser != null) {
                        
                            for (User u : listUser) {
                                
                    %>
                    <div class="frame-menu" style="border-width: 3px;
                         border-style: solid;
                         border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                     
                           
                                ID Người Dùng: <%= u.getUserID() %><br>
                                Tên Người Dùng: <%= u.getFullName() %><br>
                                Email Người Dùng: <%= u.getEmail() %><br>
                                Loại Người Dùng: <%
                                if(u.isRole()) {
                                    out.print("Nhân Viên");
                                }else{
                                    out.print("Người Dùng");
                                }
                                %><br>
                           
                        <form action="MainController?action=deletemenu" method="POST">
                          
                            <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                                Xóa Người Dùng
                            </button>
                        </form>
                    </div>
                    <%
                         }
                        }
                    %>
                  
                </ul>
            </div>
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>




</html>
