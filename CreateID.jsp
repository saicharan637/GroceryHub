





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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>

    <jsp:include page="Header.jsp" />

    
    <!-- Hero Section End -->

    <!-- Form Section Begins -->

  <section class="id form">
    <div class="container">
        <div class="checkout__form">
            <form action="<%= request.getContextPath() %>/CreateIDForm" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">

                        <div class="checkout__input">
                            <p>Username<span>*</span></p>
                            <input type="text" name = "username">
                        </div>

                        <div class="checkout__input">
                            <p>Email id<span>*</span></p>
                            <input type="text" name = "email">
                        </div>
                        <div class="checkout__input">
                            <p>UserType<span>*</span></p>
                            <select name="usertype">
                                <option value="Customer">Customer</option>
                                <option value="Store Manager">Store Manager</option>
                                <option value="Admin">Admin</option>
                            </select><br>
                            
                        </div>
                        <div class="checkout__input">
                            <p>Password<span>*</span></p>
                            <input type="password" name = "password" id="password">
                        </div>
                        <input type="checkbox" onclick="myFunction()"> Show Password
                        <div class="checkout__input">   
                            <p>Repeat Password<span>*</span></p>
                            <input type="password" name = "repassword" id="password1">
                        </div>
                        <input type="checkbox" onclick="myFunction1()"> Show Repeat Password
                        <div style="color:red;">
                            <br>${error}
                        </div>
                        <br><br>
                        <button type="submit" class="site-btn90" onclick="check()">Create ID</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <!--  <script>
        $(document).ready(function(){
          $("form").submit(function(){
            alert("Your Account has been Created Succesfully, Click OK to go to Home Page");
        });
      });
  </script> -->
</section>
<script>
    function myFunction() {
      var x = document.getElementById("password");
      if (  x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }

}
function myFunction1() {
  var y = document.getElementById("password1");
  if (  y.type === "password") {
    y.type = "text";
} else {
    y.type = "password";
}

}

</script>
<!-- Form Section End -->


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