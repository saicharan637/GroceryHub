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

    <jsp:include page="Header.jsp" />

    <!-- Hero Section Begin -->
  <!--   <section class="hero hero-normal">
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
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Hero Section End -->

    <!-- Form Section Begins -->
    <section class="id form">
        <div class="container">
            <c:choose>
                <c:when test="${val == 'true'}">
                   <h2> No Reviews Available For This Product</h2>
                   <br><br><br><br><br><br><br><br><br><br><br><br>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${rev}" var="entry">
                                    <c:choose>
                                    <c:when test= "${name1 == entry.key}" >
                                    <c:forEach items="${entry.value}" var="entry1">
                                        <div class="prob" style="margin-bottom: 2%; margin-top: 2%;">
                                            Product Name : ${entry1.productName}<br>
                                            Category : ${entry1.category}<br>
                                            Rating : ${entry1.reviewRating}<br>
                                            Date : ${entry1.reviewDate}<br>
                                            Store Zip : ${entry1.storeid}<br>
                                            Review : ${entry1.reviewText}<br>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                                </c:choose>
                                </c:forEach>
                </c:otherwise>
            </c:choose>
                    
    </div>
    </section>
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