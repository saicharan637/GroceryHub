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
             
            </div>
        </div>
    </section>
        <!-- Hero Section End -->
    
    <section class="order_hist">
        <h3 style="color: black; font: bold; margin-left: 41%;font-size: 36px;">Products Stock</h3>
        <!-- <h3><button class="site-btn80" id="clickhere">View Chart</h3> -->
            <br>
            <form action="<%= request.getContextPath() %>/AdminStockbyStore" method="post">
            <select name="storeID" style="margin-left: 38%;">
                <option value="s1">Store 1</option>
                <option value="s2">Store 2</option>
                <option value="s3">Store 3</option>
                <option value="s4">Store 4</option>
                <option value="s5">Store 5</option>
            </select>
            <button class="site-btn10" type="submit" >Change Store</button>
        </form>
        <br>
        <c:choose>
            <c:when test="${val == 'stocks'}">
            <div class="limiter" id="tab">
                <div class="container-table100">
                    <div class="wrap-table100">
                        <div class="table100 ver1">
                            <div class="wrap-table100-nextcols js-pscroll">
                                <div class="table100-nextcols">
                                    <table>
                                        <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column2 " style="padding-left: 20px;">Index</th>
                                                <th class="cell100 column2">Product ID</th>
                                                <th class="cell100 column2">Product Name</th>
                                                <th class="cell100 column2">Category</th>
                                                <th class="cell100 column3">Stock</th>
                                                <th class="cell100 column4">Weight(per item)</th>
                                                <th class="cell100 column6">Price(Per item)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${stoc}" var="entry">
                                               <tr class="row100 body">
                                                <td class="cell100 column2" style="padding-left: 20px;">${entry.index}</td>
                                                <td class="cell100 column2">${entry.productid}</td>
                                                <td class="cell100 column2">${entry.productname}</td>
                                                <td class="cell100 column5">${entry.category}</td>
                                                <td class="cell100 column3">${entry.number_of_items}</td>
                                                <td class="cell100 column4">${entry.weight}</td>
                                                <td class="cell100 column5">${entry.price}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:when>
        </c:choose>

        <div id='chart_div' style="display: none;"></div>

        <script>
            google.charts.load('current', {packages: ['corechart', 'bar']});
            google.charts.setOnLoadCallback(drawChart);
$("#clickhere").click(function () {
    $.ajax({
        url: "AdminStockGraph",
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
      subtitle: 'Total Stock Products',
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


    </section>


    <jsp:include page="footer.jsp" />

</body>

</html>
