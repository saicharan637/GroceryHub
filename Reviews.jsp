<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">

                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                
                                <input type="text" placeholder="What do yo u need?">
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
    </section>
    <!-- Hero Section End -->

    <!-- Login Form Begins -->
    <section class="id form">
        <div class="container">
            <div style="color:red;">
            </div>
            <form action="<%= request.getContextPath() %>/Reviews" method="post">
                <c:choose>
                <c:when test= "${usr == ''}" >
                <%session.setAttribute("login_msg", "Please Login to Write a Review");%>
                <jsp:forward page="ErrorLogin.jsp" />
            </c:when>
        </c:choose>
        <% pageContext.setAttribute("val", request.getParameter("operation"), PageContext.APPLICATION_SCOPE);%>
        <% pageContext.setAttribute("image", request.getParameter("image"), PageContext.APPLICATION_SCOPE);%>
        <% pageContext.setAttribute("prodname", request.getParameter("prodname"), PageContext.APPLICATION_SCOPE);%>
        <% pageContext.setAttribute("price", request.getParameter("price"), PageContext.APPLICATION_SCOPE);%>
        <% pageContext.setAttribute("category", request.getParameter("category"), PageContext.APPLICATION_SCOPE);%>
        <c:choose>
        <c:when test= "${val == 'write'}" >
        <h2>Write a Review:</h2><br>
        <div class="shoping__cart__item">
            <img src="img/${image}" width="100" height="100" alt="">
            <h3>${prodname}</h3>
            <h3>$${price}</h3>
            <input type="hidden" name = prodname value = "${prodname}">
            <input type="hidden" name = price value = "${price}">
            <input type="hidden" name = category value = "${category}">
            <input type="hidden" name = image value = "${image}">
        </div>
        <br>
        <div class="checkout__input">
            <p>Review Rating<span>*</span></p>
            <select name='review' class='input'><option value='1' >1</option><option value='2' >2</option><option value='3' >3</option><option value='4'>4</option><option value='5'>5</option></select><br>
        </div>
        <div class="checkout__input">
            <p>Write a  review for the product<span>*</span></p>
            <textarea name='reviewtext' rows='4' cols='100'> </textarea>
        </div>
        <input type="hidden" name = "button" value="submit" >
        <button type="submit" class="site-btn">Submit</button>
    </c:when>
    <c:otherwise>
    <div class="checkout__input">
        <h2>${message}</h2><br>
    </div>
</c:otherwise>
</c:choose>
</form>
</div>
</section>
<!-- Login Form Ends -->
<jsp:include page="footer.jsp" />
<!-- Footer Section End -->

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