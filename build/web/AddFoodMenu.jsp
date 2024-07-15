<%@page import="DTO.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        
        <div class="container" style="margin-top: 90px;;min-height: 70%;">
            <h1 class="col-md-12">Chọn Món Ăn để thêm vào</h1>
            <div class="row col-md-12">
        <%
            ArrayList<Food> list = (ArrayList<Food>) request.getAttribute("ListFood");
            if (list != null && !list.isEmpty()) {
                int count = 0;
                for (Food f : list) {
                    if (f.getFoodStatus()) {

        %>
        <div class="frame-menu col-md-3" style="border-width: 3px;
           
            border-radius: 15px;margin: 10px;display:inline;min-height: ">
            <form action="AddFoodToMenuServlet" method="POST">
                <input type="hidden" name="foodid" value="<%=f.getFoodID() %>">
                <input type="hidden" name="function" value="ADDFOODMENU">
                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-success" style="min-height: 300px;min-width: 300px;">                 
                    <h4><%=f.getFoodName() %></h4><br>
                    <img src="<%= f.getFoodImage()%>" class="card-img-top menu-img img-fluid rounded food-img" class="rounded" width="30" width="30" alt="">
                </button>
            </form>
       </div>
        <%
                    }
                }
            }

        %>
        </div>
        </div>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
