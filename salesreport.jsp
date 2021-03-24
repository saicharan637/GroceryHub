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

    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type='text/javascript' src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="Header.jsp" />

    <!-- Hero Section Begin -->
<!--     <section class="hero hero-normal">
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
                                <i class="fas fa-store-alt"></i>
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
    </section> -->
    <!-- Hero Section End -->

    <!-- Login Form Begins -->
    <section class = "sales-rep">
        <div class="container">
            <form action="<%= request.getContextPath() %>/AdminTotalSales" method="post">
            <div style="margin-left: 420px;">
            <select name="sale" >
                <option value="ordercat">Sales by Product</option>
                <option value="ordersales">Total Sales in a day</option>
            </select>
            <button type="submit" style="margin-left: 1%;" class="site-btn" >See Table</button>
            <c:choose>
            <c:when test="${val == 'sbd'}">
                <h3>Sales by Date</h3>

            </c:when>
            <c:otherwise>
                <h3>Sales by Product</h3>
                </c:otherwise>
                </c:choose>
        </form>
        </div>
        <br>
        
            <div class="limiter" id="tab">
                <div class="container-table100">
                    <div class="wrap-table100">
                        <div class="table100 ver1">
                            <div class="wrap-table100-nextcols js-pscroll">
                                <div class="table100-nextcols">
                                    <table>
                                        <thead>
                                            <tr class="row100 head">
                                                <c:choose>
                                                    <c:when test="${val == 'sbd'}">
                                                        <th class="cell100 column2 " style="padding-left: 20px;">Sales Date</th>
                                                        <th class="cell100 column2">Total</th>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <th class="cell100 column2 " style="padding-left: 20px;">Product Name</th>
                                                        <th class="cell100 column2">No. of Items Sold</th>
                                                    </c:otherwise>
                                                </c:choose>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                                <c:when test="${val == 'sbd'}">
                                                    <c:forEach items="${st}" var="entry">
                                                        <tr class="row100 body">
                                                        <td class="cell100 column2" style="padding-left: 20px;">${entry.purchaseDate}</td>
                                                        <td class="cell100 column2">$${entry.orderTotal}</td>



                                                       
                                                    </c:forEach>
                                                    </c:when>        
                                                    <c:otherwise>
                                                        <c:forEach items="${st}" var="entry">
                                                            <tr class="row100 body">
                                                            <td class="cell100 column2" style="padding-left: 20px;">${entry.productName}</td>
                                                            <td class="cell100 column2">${entry.no_of_items}</td>
                                                    </c:forEach>
                                                    </c:otherwise>
                                            </c:choose>                                                
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </script>

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
        

            <!-- <h3 style="color: black; font: bold;">Product Stock Chart</h3> -->
            <c:choose>
                <c:when test="${val == 'sbd'}">
                    <h3><button class="site-btn56" id="clickhere">Chart</h3>
                </c:when>
                <c:otherwise>
                    <h3><button class="site-btn56" id="clickhere1">Chart</h3>
                </c:otherwise>
                </c:choose>
            <div id='chart_div' style="display: none;"></div>

            
            <script>
            google.charts.load('current', {packages: ['corechart', 'bar']});
            google.charts.setOnLoadCallback(drawChart);
$("#clickhere1").click(function () {
    $.ajax({
        url: "AdminProductsSold",
        type: "POST",
        data: "{}",
        success: function (msg) {
            console.log(msg);
            onc();
            createDataTable(msg)            
        },
        error: function(){
            console.log("error occurred while making ajax call;")
        }
    });    
});
    function onc(){
    var x = document.getElementById("chart_div");
    var y = document.getElementById("tab");
                            console.log(x);
                            if (x.style.display === "none") {
                                x.style.display = "block";
                                y.style.display = "none";
                            } else {
                                x.style.display = "none";
                                y.style.display = "block";
                                createDataTable(jdata);
                            }
                        }

function createDataTable(jsonData) {
    console.log(jsonData);
    var parsedData = $.parseJSON(jsonData);
    var data = new Array();
    var productNameArr = new Array();
    var quantityArr = new Array();

    console.log(parsedData);
    var actualData = parsedData.myArrayList;
    data2 = ['Product Name', 'Number of Items Sold'];
    productNameArr.push(data2);    
    for(var i=0; i<actualData.length; i++) {
      console.log(actualData[i]);
        var productName = actualData[i].map.product_name;
        var quantity = actualData[i].map.product_sales;
        var data1 = [];
        data1.push(productName);
        data1.push(quantity);
        productNameArr.push(data1);
     }
     console.log(productNameArr)
     drawChart(data, productNameArr);
}
function drawChart(data, productNameArr) {
  console.log(productNameArr);

  var chartData = google.visualization.arrayToDataTable(productNameArr);
  
    var width = 600;
    var height = 600;
  var materialOptions = {
    'width':width,
    'height':height,
    chart: {
      title: 'Products Sold',
      subtitle: 'Number of Products Sold',
    },
    hAxis: {
      minValue: 0,
    },
    vAxis: {
      title: 'Product Name'
    },
    colors: ['red'],
    bars: 'horizontal',
    axes: {
      y: {
        0: {side: 'left'}
      }
    }
    };
  var materialChart = new google.charts.Bar(document.getElementById('chart_div'));
  materialChart.draw(chartData, materialOptions);
}
            </script>
    <!-- <br><br><br>
    <h3 style="color: black; font: bold;">Sales by Category</h3>
    <h3><button class="site-btn" id="CatChart" onclick="seeSaleChart()">Chart</h3>
    <div id='cat_chart_div'></div> -->

<script>
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawChar);

    $("#clickhere").click(function () {
    $.ajax({
        url: "AdminCateogrySalesGraph",
        type: "POST",
        data: "{}",
        success: function (msg) {
            console.log(msg);
            onclickCat();
            createSaleTable(msg)            
        },
        error: function(){
            console.log("error occurred while making ajax call;")
        }
    });    
});

function onclickCat(){
var x = document.getElementById("chart_div");
var y = document.getElementById("tab");
                    console.log(y);
                    if (x.style.display === "none") {
                        x.style.display = "block";
                        y.style.display = "none";
                    } else {
                        x.style.display = "none";
                        y.style.display = "block";
                        // createSaleTable(jdata);
                    }
                }

function createSaleTable(jsonData) {
console.log(jsonData);
var parsedData = $.parseJSON(jsonData);
var data = new Array();
var productNameArr = new Array();
var quantityArr = new Array();

console.log(parsedData);
var actualData = parsedData.myArrayList;
data2 = ['Date', 'Total Sales(in $)'];
productNameArr.push(data2);    
for(var i=0; i<actualData.length; i++) {
console.log(actualData[i]);
var productName = actualData[i].map.product_name;
var quantity = actualData[i].map.product_sales;
var data1 = [];
data1.push(productName);
data1.push(quantity);
productNameArr.push(data1);
}
console.log(productNameArr)
drawChart(data, productNameArr);
}
function drawChar(data, productNameArr) {
console.log(productNameArr);

var chartData = google.visualization.arrayToDataTable(productNameArr);

var h = 200;
var w = 200;

var materialOptio = {
    'width':w,
    'height':h,
    chart: {
    title: 'Daily Sales',
    subtitle: 'Total Sales in a Day',
},
hAxis: {
minValue: 0,
},
vAxis: {
title: 'Day'
},
colors: ['red'],
bars: 'horizontal',
axes: {
y: {
0: {side: 'left'}
}
}
};
var materialChar = new google.charts.Bar(document.getElementById('chart_div'));
materialChar.draw(chartData, materialOptio);
}
    </script>

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