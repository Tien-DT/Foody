<%@page import="DTO.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết món ăn</title>
        <link href="assets/css/FoodDetail.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>
       
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
                    <h4>Giá:  <%= f.getFoodPrice()%> VNĐ</h4>
                    <div>
                        <form action="MainController?action=addfoodtocart" method="POST">
                            <input type="hidden" name="foodid" value="<%= f.getFoodID()%>">
                            <a><button class="btn btn-danger button-card">Mua Món Ăn</button></a>
                        </form>             
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
