<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Food"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="assets/css/Cart.css" rel="stylesheet">
        <link href="assets/css/Footer.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="Header.jsp" %> 

        <div>
            <h1 class="jumbotron-heading cart">Giỏ Hàng</h1>
        </div>

        <div class="container mb-4 cart-frame">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Sản Phẩm</th>
                                    <th scope="col">Tình Trạng</th>
                                    <th scope="col" class="text-center">Số Lượng</th>
                                    <th scope="col" class="text-right">Giá (VNĐ)</th>
                                    <th scope="col" class="text-right">Tổng</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<Food> list = (ArrayList<Food>) session.getAttribute("cart");
                                    int totalPrice = 0;

                                    if (list != null && !list.isEmpty()) {
                                        for (Food f : list) {
                                            int quantity = 1; // Default quantity (you should adjust this to get actual quantity from session)

                                            // Calculate item total
                                            int itemTotal = quantity * f.getFoodPrice();

                                            // Update total price
                                            totalPrice += itemTotal;
                                %>
                                <tr>
                                    <td><img src="<%= f.getFoodImage()%>" width="50" height="50" /></td>
                                    <td><%= f.getFoodName()%></td>
                                    <td><% if (f.getFoodStatus()) { %>Còn hàng<% } else { %>Hết hàng<% }%></td>
                                    <td class="text-center">
                                        <input type="number" value="1" class="form-control quantity-input" value="<%= quantity%>" min="1" name="quantity_<%= f.getFoodID()%>" onchange="updateItemTotal(<%= f.getFoodID()%>, this.value, <%= f.getFoodPrice()%>)">
                                    </td>
                                    <td class="text-right"><span class="formatted-price"><%= f.getFoodPrice()%></span></td>
                                    <td class="text-right item-total"><span class="formatted-price"><%= itemTotal%></span></td>
                                    <td class="text-right">
                                        <button class="btn btn-sm btn-danger">
                                            <i class="fa fa-trash"></i>
                                        </button>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><strong>Tổng Tiền Sản Phẩm:</strong></td>
                                    <td class="text-right"><strong id="totalPrice"><span class="formatted-price"><%= totalPrice%></span></strong></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col mb-2">
                    <div class="row">
                        <div class="col-sm-12 col-md-6">
                            <a href="MainController?action=foodlist" class="btn btn-block btn-light">Tiếp Tục Mua Hàng</a>
                        </div>
                        <div class="col-sm-12 col-md-6 text-right">
                            <button class="btn btn-lg btn-block btn-danger text-uppercase">Đặt Hàng</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function formatNumber(number) {
                return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
            }

            function updateItemTotal(foodId, quantity, price) {
                var itemTotal = quantity * price;
                var row = document.querySelector('input[name="quantity_' + foodId + '"]').closest('tr');
                row.querySelector('.item-total .formatted-price').textContent = formatNumber(itemTotal);

                updateTotalPrice();
            }

            function updateTotalPrice() {
                var itemTotals = document.querySelectorAll('.item-total .formatted-price');
                var totalPrice = 0;
                itemTotals.forEach(function (item) {
                    totalPrice += parseInt(item.textContent.replace(/\./g, ''));
                });
                document.querySelector('#totalPrice .formatted-price').textContent = formatNumber(totalPrice);
            }

            // Format all prices on page load
            document.addEventListener('DOMContentLoaded', function () {
                var prices = document.querySelectorAll('.formatted-price');
                prices.forEach(function (price) {
                    price.textContent = formatNumber(parseInt(price.textContent));
                });
            });
        </script>

        <%@include file="Footer.jsp" %>
    </body>
</html>