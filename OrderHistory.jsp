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
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <!-- <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css"> -->
    <!--===============================================================================================-->
    <!-- <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"> -->
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
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
    </section>
    <!-- Hero Section End -->

    <section class="order_hist">
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100 ver1">
                        <!-- <div class="table100-firstcol">
                            <table>
                                    <thead>
                                    <tr class="row100 head">
                                        <th class="cell100 column1">Order ID</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orders}" var="entry">
                                        <c:forEach items="${entry.value}" var="order">
                                            <c:choose>
                                            <c:when test= "${order.userName == usr}">
                                    <tr class="row100 body" style="white-space: nowrap;">
                                        <td class="cell100 column1" style="padding-left: 0xp; padding-bottom: 31.5px;text-align: left;">
                                            <label>${order.orderId}</label>
                                        </td>
                                    </tr>
                                 </c:when>
                                 </c:choose>
                                </c:forEach>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div> -->
                        <h2>Order History:</h2>
                        <c:choose>
                        <c:when test="${no_order == 'true'}">
                        <h2>No Orders Placed</h2>
                    </c:when>
                    <c:otherwise>
                    <div class="wrap-table100-nextcols js-pscroll">
                        <div class="table100-nextcols">
                            <table>
                                <thead>
                                    <tr class="row100 head">
                                        <th class="cell100 column2">User Name</th>
                                        <th class="cell100 column2">Order ID</th>
                                        <th class="cell100 column2">Product Name</th>
                                        <th class="cell100 column3">No. of items</th>
                                        <th class="cell100 column4">Count/Weight(per item)</th>
                                        <!-- <th class="cell100 column5">Sub total</th> -->
                                        <th class="cell100 column6">Order Total</th>
                                        <th class="cell100 column2">Delivery Option</th>
                                        <th class="cell100 column2">Store ID</th>
                                        <th class="cell100 column8">Store Address</th>
                                        <th class="cell100 column2">Order Date</th>
                                        <th class="cell100 column2">Delivery Date</th>
                                        <th class="cell100 column2"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orders}" var="entry">
                                    <c:forEach items="${entry.value}" var="order">
                                    <c:choose>
                                    <c:when test= "${order.userName == usr}">
                                    <tr class="row100 body">
                                        <td class="cell100 column2">${order.userName}</td>
                                        <td class="cell100 column2">${order.orderId}</td>
                                        <td class="cell100 column2">${order.productName}</td>
                                        <td class="cell100 column3">${order.no_of_items}</td>
                                        <td class="cell100 column4">${order.productWeight}</td>
                                        <!-- <td class="cell100 column5">${order.productSubTotal}</td> -->
                                        <td class="cell100 column6">${order.orderTotal}</td>
                                        <td class="cell100 column2">${order.deliveryType}</td>
                                        <td class="cell100 column2">${order.storeId}</td>
                                        <td class="cell100 column8">${order.storeAddress}</td>
                                        <td class="cell100 column2">${order.purchaseDate}</td>
                                        <td class="cell100 column2">${order.expectedDeliveryDate}</td>
                                        <form action = "<%= request.getContextPath() %>/CustomerOrderHistory" method="POST">
                                            <input type="hidden" name="oid" value="${entry.key}">
                                            <input type="hidden" name="pname" value="${order.productName}">
                                            <td clas ="cell100 column2"><button type="submit" class="site-btn">Cancel Order</button></td>
                                        </form>
                                    </tr>
                                </c:when>
                                <c:when test= "${usr == 's1'|| usr == 's2'|| usr == 's3'|| usr == 's4'|| usr == 's5'}">
                                <tr class="row100 body">
                                    <td class="cell100 column2">${order.userName}</td>
                                    <td class="cell100 column2">${order.orderId}</td>
                                    <td class="cell100 column2">${order.productName}</td>
                                    <td class="cell100 column3">${order.no_of_items}</td>
                                    <td class="cell100 column4">${order.productWeight}</td>
                                    <!-- <td class="cell100 column5">${order.productSubTotal}</td> -->
                                    <td class="cell100 column6">${order.orderTotal}</td>
                                    <td class="cell100 column2">${order.deliveryType}</td>
                                    <td class="cell100 column2">${order.storeId}</td>
                                    <td class="cell100 column8">${order.storeAddress}</td>
                                    <td class="cell100 column2">${order.purchaseDate}</td>
                                    <td class="cell100 column2">${order.expectedDeliveryDate}</td>
                                    <form action = "<%= request.getContextPath() %>/CustomerOrderHistory" method="POST">
                                        <input type="hidden" name="oid" value="${entry.key}">
                                        <input type="hidden" name="pname" value="${order.productName}">
                                        <td clas ="cell100 column2"><button type="submit" class="site-btn">Cancel Order</button></td>
                                    </form>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</c:otherwise>
</c:choose>
</div>
</div>
</div>
</div>
</section>
<jsp:include page="footer.jsp" />



<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function(){
        var ps = new PerfectScrollbar(this);
        
        $(window).on('resize', function(){
            ps.update();
        })
        
        $(this).on('ps-x-reach-start', function(){
            $(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
        });
        
        $(this).on('ps-scroll-x', function(){
            $(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
        });
        
    });
    
    
    
    
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>



</body>

</html>
