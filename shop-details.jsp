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
                                <span>support 24/7 time</span>
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

                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Home</a>
                            <a href="./index.jsp">${category1}</a>
                            <span>${name1}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                            src="img/${image1}" alt="">
                        </div>
                      <!--   <div class="section-title">
                            <h4>Customers who bought this item also bought</h4>
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="img/product/details/product-details-2.jpg"
                            src="img/product/details/thumb-1.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-3.jpg"
                            src="img/product/details/thumb-2.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-5.jpg"
                            src="img/product/details/thumb-3.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-4.jpg"
                            src="img/product/details/thumb-4.jpg" alt="">
                        </div> -->
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <form action="<%= request.getContextPath() %>/Cart" method="post">
                            <h3>${name1}</h3>
                            <div class="product__details__rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                                <!-- <span>(Reviews)</span> -->
                            </div>
                            <div class="product__details__price">$${price1}/${weight1}</div>
                            
                            <div class="product__details__quantity">
                                <div class="quantity">
                                    <div class="pro-qty">
                                        <input type="text" name="quant" value=1>
                                        <input type="hidden" name="cartquant" value=1>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="prodname" value="${name1}">
                            <input type="hidden" name="prodcat" value="${category1}">
                            <input type="hidden" name="pprice" value="${price1}">
                            <br>
                            <button type="submit" class="primary-btn1">ADD TO CART</button>
                        </form>
                        <form action="<%= request.getContextPath() %>/Reviews.jsp" method="post">
                            <input type="hidden" name="image" value="${image1}">
                            <input type="hidden" name="category" value="${category1}">
                            <input type="hidden" name="prodname" value="${name1}">
                            <input type="hidden" name="prodcat" value="${category1}">
                            <input type="hidden" name="price" value="${price1}">
                            <input type="hidden" name="operation" value="write">
                            <br>
                            <button type="submit" class="primary-btn1">Write Review</button>
                        </form>
                        <ul>
                            <li><b>Availability</b> <span>${noofitems1} Items In Stock</span></li>
                            <li><b>Shipping</b> <span>01 day shipping. <br><marquee><samp>Free pickup available today</samp></span></li></marquee>
                            <li><b>Share on</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                aria-selected="true">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                aria-selected="false">View Reviews</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Products Infomation:</h6>
                                    <p>Banana, fruit of the genus Musa, of the family Musaceae, one of the most important fruit crops of the world. The banana is grown in the tropics, and, though it is most widely consumed in those regions, it is valued worldwide for its flavour, nutritional value, and availability throughout the year. Cavendish, or dessert, bananas are most commonly eaten fresh, though they may be fried or mashed and chilled in pies or puddings..</p>
                                    
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <% pageContext.setAttribute("i", 0, PageContext.APPLICATION_SCOPE);%>
                                    <% pageContext.setAttribute("val", 0, PageContext.APPLICATION_SCOPE);%>
                                    <c:forEach items="${hm}" var="entry">
                                    <c:choose>
                                    <c:when test= "${name1 == entry.key}" >
                                    <c:forEach items="${entry.value}" var="entry1">
                                    <table>
                                    <tr><td><b>UserName: </td>
                                    <td>${entry1.username}</td></tr>
                                    <tr><td><b>Review Date: </td>
                                    <td>${entry1.reviewDate}</td></tr>
                                    <tr><td><b>Review Rating: </td>
                                    <td>${entry1.reviewRating}</td></tr>
                                    <tr><td><b>Review Text: </td>
                                    <td>${entry1.reviewText}</td></tr>
                                    <% pageContext.setAttribute("i", 1, PageContext.APPLICATION_SCOPE);%>
                                    </table>
                                    <br>
                                    </c:forEach>
                                    </c:when>
                                    </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                    <c:when test= "${val == i}">
                                    <h4>No Reviews available for this Product</h4>
                                    </c:when>
                                    </c:choose>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="categories">
    <div class="container">
     <c:choose>
     <c:when test= "${usertype == 'Admin' || usertype ==null}" >
     
 </c:when>
 <c:otherwise>
 <div class="row">
    <div class="section-title">
        <h4>Recommended For You</h4>
    </div>
    <div class="categories__slider owl-carousel">
        <c:forEach items="${p}" var="p1">
        <div class="col-lg-3" >
            <div class="categories__item set-bg" data-setbg="img/${p1.image}" style="width: 56%;height: 145px;">
            </div>
            <div>
                <spam style="color: #1c1c1c;font-weight: 700;padding-left: 35px;">${p1.productname}</spam>
            </div>
            <div>
                <spam style="padding-left: 35px">$${p1.price}</spam>
            </div>

        </div>
    </c:forEach> 

</div>
</div>
</c:otherwise>
</c:choose>

</div>
</section>
<br><br>
<!-- Related Product Section End -->
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