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

    <jsp:include page="Header.jsp"/>

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

                                <input type="text" placeholder="What do you need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>${storeLocation}</h5>
                                <span>${stozip}</span>
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
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <c:choose>
        <c:when test="${not empty cartyempty}">
        <h3>${cartyempty}</h3>
    </c:when>
    <c:otherwise>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <table>
                        <thead>
                            <tr>
                                <th class="shoping__product">Products</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${orders}" var="order">
                            <tr>
                                <td class="shoping__cart__item">
                                    <img src="img/${order.image}" alt="">
                                    <h4>${order.name}</h4>
                                </td>
                                <td class="shoping__cart__price">
                                    $${order.price}/${order.weight}
                                </td>
                                <form action="<%= request.getContextPath()%>/Reload?maker=reload" method="post">
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <input type="hidden" name="can" value="${order.name}">
                                            <div class="pro-qty">
                                                <input type="text" name="quant" value="${order.quant}">
                                                <input type="hidden" name="cartquant" value="${order.quant}">
                                            </div>
                                        </div>
                                    </td>
                                    <input type="hidden" name="prodname" value="${order.name}">
                                    <input type="hidden" name="prodcat" value="${order.category}">
                                    <td class="shoping__cart__item__close">
                                       <button style="background-color: #ffffff;"> <i class="fa fa-refresh" aria-hidden="true"></i></button>
                                    </td>
                                </form>
                                <td class="shoping__cart__total">
                                    <c:set var = "prodTotal" scope = "session" value = "${order.price*order.quant}"/>
                                    <input type="hidden" name="prodtotal" value="${prodTotal}">
                                    $${prodTotal}
                                </td>
                                <td class="shoping__cart__item__close">
                                    <form action="<%= request.getContextPath()%>/Cancel?maker=cancel" method="post">
                                        <input type="hidden" name="can" value="${order.name}">
                                        <button style="background-color: #ffffff;"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- <div class="col-lg-6"> -->
            <!-- <div class="shoping__continue"> -->
                        <!-- <div class="shoping__discount">
                            <h5>Discount Codes</h5> -->
                            <!-- <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">APPLY COUPON</button>
                            </form> -->
                            <!-- </div> -->
                            <!-- </div> -->
                            <!-- </div> -->
                            <div class="col-lg-6">
                                <form action="<%= request.getContextPath()%>/Checkout" method="post">    
                                    <div class="shoping__checkout">
                                        <h5>Cart Total</h5>
                                        <ul>
                            <!-- <c:set var = "total" scope = "session" value = "0"/>
                                <c:set var = "orderTotal" scope = "session" value = "${order.price}+${total}"/> -->

                                <li>Total <span>$${total}</span></li>

                                <input type="hidden" name="orderTotal" value="${total}">
                            </ul>
                            <button type="submit" class="primary-btn2" style="text-align:center;" >PROCEED TO CHECKOUT</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
</section>
<!-- Shoping Cart Section End -->
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