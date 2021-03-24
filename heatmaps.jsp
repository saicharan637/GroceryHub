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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzMqurJd8NXaERE7WXqs1Qw3SJbbpssOk&libraries=visualization"></script>
    <!-- <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDYWD_tXx646o6YvbdJepCXnsPO1aE-hkE&libraries=visualization\"></script> -->

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
    <!-- Hero Section End -->

    <!-- Login Form Begins -->
    <div style="margin-left: 10%;">
    <!-- <select>
        <option value="heat1">Review at every Location</option>
        <option value="heat2">Transactions at every Location</option>
        <option value="heat3">Total Number Liked((rating >=3)</option>
        <option value="heat4">Total number of disliked (rating less than 3) products</option>
        <option value="heat5">Total number of store pick-ups</option>
    </select> -->
    Reviews at Every Store Location&nbsp;&nbsp;&nbsp;Transactions at Every Location&nbsp;&nbsp;&nbsp;Total number of Disliked (Rating<3) Products&nbsp;&nbsp;&nbsp;Total Number Liked((rating >=3)Products&nbsp;&nbsp;&nbsp;Total number of store pick-ups<br>
    <button class="site-btn" id="btnGetHeatmap1">View Heat Map&nbsp;&nbsp;&nbsp;</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="site-btn300" id="btnGetHeatmap2">View Heat Map&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;
    <button style="margin-right: 10%;" class="site-btn100" id="btnGetHeatmap3">View Heat Map&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
    <button  class="site-btn101" id="btnGetHeatmap4">View Heat Map&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="site-btn" id="btnGetHeatmap5">View Heat Map&nbsp;&nbsp;&nbsp;</button>
    </div>
        <div class="heat-map" id="heat_div" style="height: 70%; width: 80%;">
        </div>
        <script type='text/javascript' src='js/HeatMap.js'></script>
        <script type='text/javascript' src='js/TbyStore.js'></script>
        <script type='text/javascript' src='js/Like.js'></script>
        <script type='text/javascript' src='js/Dislike.js'></script>
        <script type='text/javascript' src='js/Delivery.js'></script>


        <jsp:include page="footer.jsp" />

        <!-- Login Form Ends -->




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