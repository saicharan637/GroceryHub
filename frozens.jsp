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
    <title>Grocery Hub</title>

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
                                <span>support 24/7 timeline</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Grocery Hub</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Frozen Foods</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                         <h4 style=" color: #7fad39;">All Departments</h4>
                         <ul>
                            <li><a href="./Fruits">Fruits & Vegetables</a></li>
                            <li><a href="./Dairys">Dairy & Bakery</a></li>
                            <li><a href="./Meats">Fresh Meat</a></li>
                            <li><a href="./Frozens">Frozen Foods</a></li>
                            <li><a href="./Canneds">Canned Foods</a></li>
                            <li><a href="./Beverages">Beverages</a></li>
                            <li><a href="./PersonalCares">Personal Care</a></li>
                            <li><a href="./HomeCares">Home Care</a></li>
                        </ul>
                    </div>
                    
                <div class="sidebar__item">
                    <div class="latest-product__text">
                        <h4>Latest Products</h4>
                        <br><br>
                        <c:forEach items="${latest}" var="la">
                        <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                        <a href="#" class="latest-product__item">
                        <div class="latest-product__item__pic">
                        <img src="img/${la.image}" alt="">
                        </div>
                        <div class="latest-product__item__text">
                        <h6>${la.productName}</h6>
                        <span>$${la.price}</span>
                        </div>
                        </a>
                        </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9 col-md-7">
            <div class="product__discount">

                <div class="filter__item">
                    <div class="row">
                      
                        <div class="col-lg-4 col-md-4">
                            <div class="filter__found">
                                <h6><span>${count} Products found in Store ${sid}</span></h6>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">



                   <c:forEach items="${frozens}" var="frozen">
                   <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="product__item">
                        <form id="myform" action="<%= request.getContextPath()%>/Products" method="post">
                            <input type="hidden" name = "pname" value="${frozen.productname}">
                            <input type="hidden" name = "price" value="${frozen.price}">
                            <input type="hidden" name = "category" value="${frozen.category}">
                            <input type="hidden" name = "image" value="${frozen.image}">
                            <input type="hidden" name = "disc" value="${frozen.discount}">
                            <input type="hidden" name = "noofitems" value="${frozen.number_of_items}">
                            <input type="hidden" name = "weight" value="${frozen.weight}">
                            <div class="product__item__pic set-bg" data-setbg="img/${frozen.image}">
                                <c:choose>
                                    <c:when test= "${frozen.number_of_items!= 0}" >
                                        <ul class="product__item__pic__hover">
                                            <li><button type="submit" class="fa fa-shopping-cart"></button><li>
                                        </ul>
                                </c:when>
                                <c:otherwise>
                                    <h5>Product Not available</h5>
                                    </c:otherwise>
                                </c:choose>
                                    </div>
                                </form>  
                                <div class="product__item__text">
                                    <h6><a href="#">${frozen.productname}</a></h6>
                                    <h5>$${frozen.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
           <!--  <div class="product__pagination">
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#"><i class="fa fa-long-arrow-right"></i></a>
            </div> -->
        </div>
    </div>
</div>
</section>
<!-- Product Section End -->

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