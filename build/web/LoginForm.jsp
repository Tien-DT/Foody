<%-- 
    Document   : LoginForm
    Created on : Jun 19, 2024, 9:35:26 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login and Register Form</title>
        <link rel="stylesheet" href="assets/css/LoginForm.css">
        <link rel="stylesheet" href="assets/css/Main.css">
    </head>
    <body>

        <jsp:include page="Header.jsp" />
        <%
            String checkLogin = (String) session.getAttribute("LoginedUser");
            if (checkLogin != null) {
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
        %>
        <video src="assets/video/tvc.mp4" autoplay loop muted></video>

        <div class="container box-input-div">
            <!-- Login Form -->
            <div class="login-box" id="login-form">
                <form action="MainController?action=login" method="POST"">
                    <div class="inputBox">
                        <input type="text" name="txtemail" required>
                        <label>Email</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="txtpassword" required>
                        <label>Mật Khẩu</label>
                    </div>
                    <%
                        String msg = (String) request.getAttribute("Error");
                        if (msg != null) {
                    %><p style="color: red; font-size: 20px; font-weight: bold; background-color: #f8d7da; border: 1px solid #f5c6cb; padding: 10px; margin-top: 10px; border-radius: 5px;">
                        <%= msg%>
                    </p><%
                            request.removeAttribute("Error");
                            request.removeAttribute("PasswordEncoded");
                        }

                    %>


                    <div class="button">
                        <input type="submit" value="Đăng Nhập">
                    </div>

                    <div class="register">
                        <a href="#" onclick="toggleForm()">Đăng Kí</a>
                    </div>
                </form>
            </div>

            <!-- Register Form -->
            <div class="login-box" id="register-form" style="display: none;">
                <form action="MainController?action=register" method="POST">
                    <div class="inputBox">
                        <input type="text" name="txtfullname" required>
                        <label>Họ và Tên</label>
                    </div>
                    <div class="inputBox">
                        <input type="email" name="txtemail" required>
                        <label>Email</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="txtpassword" required>
                        <label>Mật Khẩu</label>
                    </div>
                    <div class="button">
                        <input type="submit" value="Đăng Kí">
                    </div>
                    <div class="register">
                        <a href="#" onclick="toggleForm()">Đăng Nhập</a>
                    </div>
                </form>

            </div>
        </div>

        <script>
            function toggleForm() {
                var loginForm = document.getElementById("login-form");
                var registerForm = document.getElementById("register-form");
                if (loginForm.style.display === "none") {
                    loginForm.style.display = "block";
                    registerForm.style.display = "none";
                } else {
                    loginForm.style.display = "none";
                    registerForm.style.display = "block";
                }
            }
            
            function validateForm() {
            var email = document.querySelector("input[name='txtemail']").value.trim();
            var regex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

            if (!email.match(regex)) {
                alert("Email không hợp lệ. Email phải có đuôi @gmail.com");
                return false; 
            }

            return true;
        }
        </script>


    </body>

</html>

