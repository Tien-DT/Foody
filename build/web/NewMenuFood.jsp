<%-- 
    Document   : NewMenuFood
    Created on : Jul 4, 2024, 6:35:16 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/MenuFood.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content">
            <div class="row">
                <div class="col-md-12 menu-title">
                    <h1 id="title-list">Tạo Thực Đơn Mới</h1>
                </div>
            </div>
            <div class="box-menu box-list">
                <form action="MainController?action=insertnewmenu" method="POST">

                    <div class="mb-3">                   
                        <label for="Tên Thực Đơn " class="form-label">Tên Thực Đơn</label>
                        <input type="text" class="form-control" id="formGroupExampleInput" name="txtmenuname" required>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">Tạo Thực Đơn</button>
                    </div>
                </form>
            </div>
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>
</html>
