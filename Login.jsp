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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="Header.jsp" />

    <!-- Hero Section Begin -->
 <!--    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">

                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">

                                <input type="text" placeholder="What do you need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+1 123.456.7890</h5>
                                <span>Support 24/7 timeline</span>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
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
        <form id="login" action="<%= request.getContextPath() %>/Login" method="post">
            <div class="checkout__input1">
                <p>Username<span>*</span></p>
                <input type="text" name = "username" placeholder="Enter your username"  value="<%=userName%>">
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
<!-- <c:choose>
<c:when test="${er != null}">
<p style="color:red">${er}</p>
</c:when>
</c:choose> -->
<div id="userexist">
    <br>
</div>
<button type="submit" class="site-btn2">Login</button>
<label style="margin-left: 10px;">
    <input type="checkbox" name="remember" <%= "1".equals(rememberVal) ? "checked=\"checked\"" : "" %>  value="1"> Remember me 

</label>
<!-- <div class="forgot" >
   <a href="#">Forgot password?</a>
</div> -->
</form>
<script>     
    $('#login').validate({
        rules: {
            username: "required",
            password: "required",
        },

        submitHandler: function(form){
            $.ajax({
                url: "Login",
                type: "POST",
                data: $("form").serialize(),
                success: function(msg){
                    console.log(msg);
                    if(msg === 'true'){
                        $('#userexist').html('<h5 style="color: red;">Username or Password you have entered is incorrect</h5>');
                    }else{
                        window.location.href = msg;
                    }
                },
                error: function(){
                    console.log("error occurred while making ajax call;")
                }
            });
        }
    });
</script>
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