<%-- 
    Document   : FoodDetail
    Created on : Jul 9, 2024, 7:01:03 PM
    Author     : USER
--%>

<%@page import="DTO.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết món ăn</title>
        <link href="assets/css/FoodDetail.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="Header.jsp" />

        <div class="container body-detail">
            <h1>Chi Tiết Món Ăn</h1>
            <%
                ArrayList<Food> list = (ArrayList<Food>) request.getAttribute("FoodDetail");
                for (Food f : list) {
            %>
            <div class="card row">
                <div class="card-body col-md-12">
                    <img src="<%= f.getFoodImage()%>"style="width: 300px; height: 200px; object-fit: cover;" />
                    <h4><%= f.getFoodName()%></h4>
                    <h4>Giá:<%= f.getFoodPrice()%> VND</h4>
                    <div>
                        <button class="btn btn-primary" onclick="">Mua Món Ăn</button>
                        <button class="btn btn-secondary" onclick="">Mua Nguyên Liệu</button>
                        <button class="btn btn-success" onclick="">Thêm vào Menu</button>
                    </div>
                </div>
                <div class="card-body col-md-12">
                    <h6 class="content">
                        <pre><%= f.getFoodStep()%></pre>
                    </h6>

                </div>
            </div>
            <%
                }
            %>
        </div>




        <jsp:include page="Footer.jsp" />
    </body>
</html>
