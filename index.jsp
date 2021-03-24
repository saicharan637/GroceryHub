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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body onload="init()">
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader">
           <script type="text/javascript" src="js/autocomplete.js"></script>
       </div>
   </div>

   <jsp:include page="Header.jsp" />
   <!-- Hero Section Begin -->
   <section class="hero">
    <div class="container">

        <div class="row">
            <div class="col-lg-3">
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
         </div>

     </div>
     <div class="col-lg-9">
       <div class="hero__search">
        <div class="hero__search__form">
            <form action="#">
                <input type="text" name="complete-field" id="searchId" onkeyup="doCompletion()" placeholder="Search Grocery Hub" >
                <div id="auto-row">
                    <table id="complete-table" style="width: 100%;"></table>
                </div>

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
    <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
        <div class="hero__text">
            <span>FRESH Groceries</span>
            <h2>Vegetables<br> <br /></h2>
            <h2>100% Organic</h2><br>
            <p>Free Pickup and Delivery Available</p>
            <a href="#" class="primary-btn">SHOP NOW</a>
        </div>
    </div>
</div>
</div>
</div>
</section>
<!-- Hero Section End -->

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

<!-- || usertype ==null -->

<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <c:choose>
                    <c:when test= "${usertype == 'Admin' }" >
                    
                </c:when>
                <c:otherwise>
                <h2>Deal Matches</h2>
            </div>
            <font size="6">
                <font color="#000000"> <marquee behavior="scroll" scrollamount="20"> Matching Tweets: &nbsp;${tweet}</marquee></font>
            </font>
            
            <% pageContext.setAttribute("i", 4, PageContext.APPLICATION_SCOPE);%>
            
            <br>
        </c:otherwise>
    </c:choose>
    
           <!--      <c:forEach items="${selectedproducts}" var="entry">
                <c:choose>
                <c:when test= "${selectedproducts.size() == i}" >
                <img src="img/${entry.value.image}" width="100" height="100" alt="" style="margin-left: 500px;">
                <br><b>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${entry.value.productid}</b>
                <br>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$${entry.value.price}
                <br>
            </c:when>
            <c:otherwise>
            <h2>No Offers Found</h2>
        </c:otherwise>
    </c:choose>
</c:forEach> -->
</div>
</div>
</div>



<section class="categories">
    <div class="container">
     <c:choose>
     <c:when test= "${usertype == 'Admin' || usertype =='null'}" >

 </c:when>
 <c:otherwise>
 <div class="row">
   
    <div class="categories__slider owl-carousel">
        <c:forEach items="${selectedproducts}" var="entry">
        <c:choose>
        <c:when test= "${selectedproducts.size() == i}" >
        <div class="col-lg-3" >
            <div class="categories__item set-bg" data-setbg="img/${entry.value.image}" style="width: 56%;height: 145px;">
            </div>
            <div>
                <spam style="color: #1c1c1c;font-weight: 700;padding-left: 35px;">${entry.value.productid}</spam>
            </div>
            <div>
                <spam style="padding-left: 35px">$${entry.value.price}</spam>
            </div>

        </div>
    </c:when>
    <c:otherwise>
<!--     <h2>No Offers Found</h2>
 --></c:otherwise>
</c:choose>
</c:forEach>

</div>
</div>
</c:otherwise>
</c:choose>

</div>
</section>

</section>


<!-- Banner Begin -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="img/banner/banner-1.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="img/banner/banner-2.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner End -->

<!-- Latest Product Section Begin -->
<section class="latest-product spad">
    <div class="section-title">
        <h2>Trending:</h2>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text1">

                    <h4>Latest Products</h4>
                    <br><br>

                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${latest}" var="la">
                            <a href="#" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="img/${la.image}" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>${la.productName}</h6>
                                    <span>$${la.price}</span>
                                </div>
                            </a>
                        </c:forEach>

                    </div>
                </div>

                
            </div>
        </div>
        
        <div class="col-lg-4 col-md-6">
            <div class="latest-product__text1">
                <h4>Top Rated Products</h4>
                <br><br>
                <c:forEach items="${bestrated}" var="br">
                <div class="latest-product__slider owl-carousel">
                    <div class="latest-prdouct__slider__item">
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="img/${br.image}" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>${br.productname}(${br.rating})</h6>
                                <span>$${br.price}</span>

                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="col-lg-4 col-md-6">
        <div class="latest-product__text1">
            <h4>Top Sold Products</h4>
            <br><br>
            <c:forEach items="${mostsold}" var="ms">
            <div class="latest-product__slider owl-carousel">
                <div class="latest-prdouct__slider__item">
                    <a href="#" class="latest-product__item">
                        <div class="latest-product__item__pic">
                            <img src="img/${ms.image}" alt="">
                        </div>
                        <div class="latest-product__item__text">
                            <h6>${ms.productName}(${ms.count})</h6>
                            <span>$${ms.price}</span>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</section>
<!-- Latest Product Section End -->

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