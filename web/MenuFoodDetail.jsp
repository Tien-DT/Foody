<%-- 
    Document   : MenuFoodDetail
    Created on : Jul 4, 2024, 5:49:00 PM
    Author     : USER
--%>

<%@page import="DTO.MenuDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/MenuFoodDetail.css" rel="stylesheet">
        <title>Chi tiết thực đơn</title>
    </head>

    <jsp:include page="Header.jsp" />
    <body>
        
        <div class="container-fluid body-content" style="min-height: 75%!important;">
            <%
                String addResult = (String) request.getAttribute("AddResult");
                if(addResult != null){
                   %>
                   <h4 style="color:red;background-color: yellow;width: 610px;" ><%=addResult %></h4>
            <%
                
                }
        %>

            <div class="box-menu col-md-12 box-body">
                <h1 class="text-center my-4">Thực Đơn Chi Tiết</h1>
                <!-- Header Row -->
                <div class="row schedule">
                    <div class="col-12 col-md-2 day">Thứ Hai</div>
                    <div class="col-12 col-md-2 day">Thứ Ba</div>
                    <div class="col-12 col-md-2 day">Thứ Tư</div>
                    <div class="col-12 col-md-2 day">Thứ Năm</div>
                    <div class="col-12 col-md-2 day">Thứ Sáu</div>
                    <div class="col-12 col-md-2 day">Thứ Bảy</div>
                </div>
                <!-- Time Slots -->
                <%
                    int flag = 0;
                  
                    int menuDay = 0;
                    ArrayList<MenuDetail> monday = new ArrayList<>();
                    ArrayList<MenuDetail> tuesday = new ArrayList<>();
                    ArrayList<MenuDetail> wednesday = new ArrayList<>();
                    ArrayList<MenuDetail> thursday = new ArrayList<>();
                    ArrayList<MenuDetail> friday = new ArrayList<>();
                    ArrayList<MenuDetail> saturday = new ArrayList<>();
                    ArrayList<MenuDetail> list = (ArrayList) request.getAttribute("MenuDetail");

                    if (list != null) {
                        for (MenuDetail md : list) {

                            menuDay = md.getMenuDay();
                            if (flag == 0) {
                                int menuIDTemp = md.getMenuID();
                                ServletContext context = getServletContext();
                                context.setAttribute("MenuIDTemp", menuIDTemp);
                                flag = 1;
                            }
                            switch (menuDay) {
                                case 2:
                                    monday.add(md);
                                    break;
                                case 3:
                                    tuesday.add(md);
                                    break;
                                case 4:
                                    wednesday.add(md);
                                    break;
                                case 5:
                                    thursday.add(md);
                                    break;
                                case 6:
                                    friday.add(md);
                                    break;
                                case 7:
                                    saturday.add(md);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }


                %>
                <div class="row schedule">
                    <!-- Thứ Hai -->
                    <div class="col-12 col-md-2">

                        <div class="menu-items">
                            <%                                for (MenuDetail menu : monday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST" style="margin-top:10px;">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit" class="btn btn-light"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                            <form action="MainController?action=addfoodtomenu" method="POST">
                                <input type="hidden" name="menudate" value="2">
                             
                                <button type="submit" style="margin-top:20px;" class="btn btn-primary"><h4>Thêm món ăn</h4></button>
                            </form>
                        </div>

                    </div>
                    <!-- Thứ Ba -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : tuesday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                    <!-- Thứ Tư -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : wednesday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Năm -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : thursday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Sáu -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : friday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Thứ Bảy -->
                    <div class="col-12 col-md-2">
                        <div class="menu-items">
                            <%            for (MenuDetail menu : saturday) {
                            %>
                            <div class="menu-item">
                                <form action="MainController?action=viewfood" method="POST">
                                    <input type="hidden" name="foodid"value="<%= menu.getFoodID()%>">
                                    <button type="submit"> <h4><%= menu.getFoodName()%></h4></button>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>



</html>
