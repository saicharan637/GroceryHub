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
    <script type='text/javascript' src="https://www.gstatic.com/charts/loader.js"></script>
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
    </section>
    <!-- Hero Section End -->

    <!-- Login Form Begins -->
    <section class = "sales-rep">
        <div class="container">
            <h3 style="color: black; font: bold;">Products Stock Chart</h3>
            <h3><button class="site-btn" id="clickhere">Chart</h3>
                <div id='chart_div' style="display: none;"></div>
                <script>
                    google.charts.load('current', {packages: ['corechart', 'bar']});
                    google.charts.setOnLoadCallback(drawChart);
                    $("#clickhere").click(function () {
                        $.ajax({
                            url: "SMStockGraph",
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
                        console.log(x);
                        if (x.style.display === "none") {
                            x.style.display = "block";
                        } else {
                            x.style.display = "none";
                                // createDataTable(jdata);
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
                            data2 = ['Product Name', 'Number of Items in Stock'];
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
                          

                          var materialOptions = {
                            'width':1000,
                            'height':1000,
                            chart: {
                              title: 'Products Stock',
                              // subtitle: 'Total Stock Of Products',
                          },
                          hAxis: {
                              minValue: 0,
                          },
                          vAxis: {
                              title: 'Product Name'
                          },
                         
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
            <br><br><br>
            <h3 style="color: black; font: bold;">Sales by Category</h3>
            <h3><button class="site-btn" id="CatChart" onclick="seeSaleChart()">Chart</h3>
                <div id='cat_chart_div'></div>

                <script>
                    google.charts.load('current', {packages: ['corechart', 'bar']});
                    google.charts.setOnLoadCallback(drawChar);
                    function seeSaleChart(){
                        $.ajax({
                            url: "SMCateogrySalesGraph",
                            type: "POST",
                            data: "{}",
                            success: function (msg) {
                                console.log(msg);
    // onclickCat(msg);
    createSaleTable(msg);            

},
error: function(){
    console.log("error occurred while making ajax call;")
}
});    
                    }
// function onclickCat(jdata){
// var y = document.getElementById("cat_chart_div");
//                     console.log(y);
//                     if (y.style.display === "none") {
//                         y.style.display = "block";
//                         createSaleTable(jdata);            
//                     } else {
//                         y.style.display = "none";
//                         // createSaleTable(jdata);
//                     }
//                 }

function createSaleTable(jsonData) {
    console.log(jsonData);
    var parsedData = $.parseJSON(jsonData);
    var data = new Array();
    var productNameArr = new Array();
    var quantityArr = new Array();

    console.log(parsedData);
    var actualData = parsedData.myArrayList;
    data2 = ['Category', 'Items Sold'];
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


    var materialOption = {
        'width':400,
        'height':400,
        chart: {
            title: 'Sales by Product Category',
            // subtitle: 'Sales by Product Category',
        },
        hAxis: {
            minValue: 0,
        },
        vAxis: {
            title: 'Product Name'
        },
        
        bars: 'horizontal',
        axes: {
            y: {
                0: {side: 'left'}
            }
        }
    };
    var materialChar = new google.charts.Bar(document.getElementById('cat_chart_div'));
    materialChar.draw(chartData, materialOption);
}
</script>

</div>
</section>
<!-- Login Form Ends -->
<br><br><br><br><br><br><br><br><br><br>
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