    <%-- 
        Document   : LoginForm
        Created on : Jun 19, 2024, 9:35:26 AM
        Author     : USER
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    
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
        <video src="assets/video/tvc.mp4" autoplay loop muted></video>
        
        <div class="container box-input-div">
            <!-- Login Form -->
            <div class="login-box" id="login-form">
                <form action="MainController?action=login" method="POST">
                    <div class="inputBox">
                        <input type="text" name="txtusername" required>
                        <label>Username</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="txtpassword" required>
                        <label>Password</label>
                    </div>
                    <div class="remember">
                        <input type="checkbox">Remember me
                    </div>
                    <div class="button">
                        <input type="submit" value="Login">
                    </div>
                   
                    <div class="register">
                        <a href="#" onclick="toggleForm()">Register</a>
                    </div>
                </form>
            </div>

            <!-- Register Form -->
            <div class="login-box" id="register-form" style="display: none;">
                <form action="MainController?action=register" method="POST">
                    <div class="inputBox">
                        <input type="text" name="txtfullname" required>
                        <label>Full Name</label>
                    </div>
                    <div class="inputBox">
                        <input type="email" name="txtemail" required>
                        <label>Email</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="txtusername" required>
                        <label>Username</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="txtpassword" required>
                        <label>Password</label>
                    </div>
                    <div class="button">
                        <input type="submit" value="Register">
                    </div>
                    <div class="register">
                        <a href="#" onclick="toggleForm()">Login</a>
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
        </script>
 
        
    </body>
        
    </html>

