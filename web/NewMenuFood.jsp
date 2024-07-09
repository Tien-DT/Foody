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
        <title>Tạo thực đơn mới</title>
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
                <form action="MainController?action=insertmenu" method="POST">
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
                        <button type="submit" class="btn btn-primary">Tạo Thực Đơn</button>
                    </div>
                </form>
                <% String result = (String) request.getAttribute("Result");
                    if (result != null) {%>
                <div>

                    <h2> <%= result%></h2>
                </div>
                <% }
                request.removeAttribute("Result");
                %>
            </div>


        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>
</html>
