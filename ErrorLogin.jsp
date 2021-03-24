<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="Header.jsp" />

    <!-- Hero Section Begin -->
    
    <%
    Cookie[] cookies=request.getCookies();
    String userName = "", password = "",rememberVal="";
    if (cookies != null) {
    for (Cookie cookie : cookies) {
    if(cookie.getName().equals("cookuser")) {
    userName = cookie.getValue();
}
if(cookie.getName().equals("cookpass")){
password = cookie.getValue();
}
if(cookie.getName().equals("cookrem")){
rememberVal = cookie.getValue();
}
}
}
%>
<!-- Hero Section End -->

<!-- Login Form Begins -->
<section class="id form">
    <div class="container">
        
        <div style="color:red;">
            <br>${login_msg}
        </div>       
        <form action="<%= request.getContextPath() %>/Login" method="post">
            <div class="checkout__input1">
                <p>Username<span>*</span></p>
                <input type="text" name = "username"placeholder="Enter your username"  value="<%=userName%>">
            </div>
            
            <div class="checkout__input1">
             <!-- <div class="container"> -->
                <p>Password<span>*</span></p>

                <input type="password" name="password" id="password" placeholder="Enter your password" value="<%=password%>">
                <i class="fa fa-fw fa-eye field-icon" style="margin-left: -28px;" id="togglePassword"></i>
                <!-- </div> -->
                <script >
                    const togglePassword = document.querySelector('#togglePassword');
                    const password = document.querySelector('#password');
                    togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye slash icon
    this.classList.toggle('fa-eye-slash');
});
</script>
</div>
<button type="submit" class="site-btn2">Login</button>
<label style="margin-left: 10px;">
    <input type="checkbox" name="remember" <%= "1".equals(rememberVal) ? "checked=\"checked\"" : "" %>  value="1"> Remember me 

</label>
<!-- <div class="forgot" >
   <a href="#">Forgot password?</a>
</div> -->
</form>
</div>
</section>
<!-- Login Form Ends -->

<jsp:include page="footer.jsp" />


<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>

</body>

</html>































