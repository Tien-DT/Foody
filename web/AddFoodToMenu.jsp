<%-- 
    Document   : AddFoodToMenu
    Created on : Jul 10, 2024, 10:25:09 AM
    Author     : USER
--%>

<%@page import="DTO.MenuDetail"%>
<%@page import="DTO.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Món Ăn Vào Menu</title>
        <link href="assets/css/FoodDetail.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="Header.jsp" />

        <div class="container body-detail">
            <h1>Thêm Món Ăn Vào Menu</h1>

            <div class="card">
                <form>
                    <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Menu: </label>
                    <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                        <option selected>Chọn Menu</option>
                        <%
                            ArrayList<Menu> list = (ArrayList) request.getAttribute("MenuTemp");
                            if (list != null) {
                              
                                for (Menu m : list) {

                        %>
                        <option value="Mon An"><%= m.getMenuName() %></option>
                        <%                               }
                            }
                        %>
                    </select>

                    <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Thứ: </label>
                    <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                        <option selected>Thứ 2-Thứ 7</option>
                        
                        <option value="1"></option>
                        
                    </select>
                </form>

            </div>




            <jsp:include page="Footer.jsp" />
    </body>
</html>
