<%@page import="DTO.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/MenuFood.css" rel="stylesheet">
        <link href="assets/css/Header.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="assets/img/favicon.png"/>
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <title>Danh sách đơn hàng</title>
    </head>
    <jsp:include page="Header.jsp" />
    <body>
        <div class="container-fluid body-content">
            <div class="row">
                <div class="col-md-12 menu-title">
                    <h1 id="title-list">Danh sách đơn hàng</h1>
                </div>
            </div>
            <% 
                
                String result =(String) request.getAttribute("Result");
                if(result != null){
                    %><h3 style="color: green;"><%=result %></h3>   <%
                        request.removeAttribute("Result");
                }
            %>
            <div class="row">
                <div class="box-menu box-list col-md-12">
                    <ul class="list-group row">
                        <%
                            String statusColor = null;
                            String status = null;
                            ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("OrderList");
                            if (list != null && !list.isEmpty()) {
                                for (Order o : list) {
                                   if(o.getOrderStatus()==1){
                                       status="Đang chờ Nhân Viên xác nhận";
                                       statusColor="btn btn-secondary";
                                   }else if(o.getOrderStatus()==2){
                                       status="Nhân Viên đang gói hàng";
                                       statusColor="btn btn-info";
                                   }else if(o.getOrderStatus()==3){
                                       status="Đơn hàng đang được vận chuyển";
                                       statusColor="btn btn-warning";
                                   }else if(o.getOrderStatus()==4){
                                       status="Giao hàng thành công";
                                       statusColor="btn btn-success";
                                   }
                                        
                        %>
                        <div class="frame-menu" style="border-width: 3px;
                             border-style: solid;
                             border-color: #0dcaf0;border-radius: 15px;margin: 10px;">
                            <div style="margin:10px;">
                                    Mã đơn hàng: <%=o.getOrderID() %><br> 
                                    Ngày Đặt Hàng: <%=o.getOrderDate() %><br>
                                    Nội Dung:<br> <%=o.getOrderDetail() %><br>
                                    Số điện thoại nhận hàng: <%=o.getOrderPhone() %><br>
                                    Địa chỉ nhận hàng: <%=o.getOrderAddress() %><br>
                                    <div class="<%=statusColor %>">
                                        <%=status %>
                                    </div>
                            </div>
                                 </div>   
                           
                                <%if(o.getOrderStatus()==1){ %>
                            <form action="MainController?action=cancelorder" method="POST">
                                <input type="hidden" name="orderid" value="<%=o.getOrderID()%>">
                                <button type="submit" class="col-md-12 col-sm-12 button-menu-food btn btn-outline-danger">
                                   Hủy Đơn Hàng: <%=o.getOrderID()%>
                                </button>
                            </form>
                            
                        
                        <%
                            }
                                }
                            }
                                
                            
                        %>

                 
                    </ul>
                </div>
            </div>
        </div>
        <footer>
            <jsp:include page="Footer.jsp" />
        </footer>
    </body>




</html>
