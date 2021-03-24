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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>


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
                    <div class="hero__categories">


                    </div>
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
                        <h2>Checkout</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Home</a>
                            <span>Checkout</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">

            </div>
            <div class="checkout__form">
                <h4>Billing Details</h4>
                <form id="billing" action="<%= request.getContextPath() %>/Payment" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p><i class="fa fa-user"></i>&nbsp;First Name<span>*</span></p>
                                        <input type="text" name="firstname"  placeholder="John" >
                                        <div class="error" id="ferror"></div>
                                        <p><i class="fa fa-user"></i>&nbsp;Last Name<span>*</span></p>
                                        <input type="text" name="lastname" placeholder="Doe" >
                                        <!-- <div class="error" id="lerror"></div> -->
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p><i class="fa fa-envelope"></i>&nbsp;Email<span>*</span></p>
                                        <input type="text" name="email" placeholder="groceryhub@ewa.com">
                                        <!-- <div class="error" id="emailerror"></div> -->
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p><i class="fa fa-address-card-o"></i>&nbsp;Address<span>*</span></p>
                                        <input type="text" name="street" placeholder="Street Address" class="checkout__input2__add">
                                        <div class="error" id="serror"></div>
                                        <input type="text" name="apt" placeholder="Apartment/Suite/Unit">
                                        <div class="error" id="aerror"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p><i class="fa fa-institution"></i>Town/City<span>*</span></p>
                                        <input type="text" placeholder="Chicago" name = "city">
                                        <div class="error" id="terror"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p>State<span>*</span></p>
                                        <input type="text" name="state" placeholder="IL">
                                        <div class="error" id="serror"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p>Postcode / ZIP<span>*</span></p>
                                        <input type="number" name="zip" placeholder="100001">
                                        <div class="error" id="perror"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input2">
                                        <p><i class="fa fa-flag" aria-hidden="true"></i>&nbsp;Country<span>*</span></p>
                                        <select name="country"  >
                                            <option>Select</option>
                                            <option>India</option>
                                            <option>United States</option>
                                            <option>United Kingdom</option>
                                        </select>
                                        <div class="error" id="cerror"></div>
                                    </div>
                                </div>
                            </div>
                      <!--   <div class="checkout__input2__checkbox">
                            <label for="diff-acc">
                                Save Address?
                                <input type="checkbox" name="saveadd" id="diff-acc" value="save">
                                <span class="checkmark"></span>

                            </label>
                        </div> -->
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input2">
                                    <p> <i class="fa fa-phone"></i>&nbsp;Phone<span>*</span></p>
                                    <input type="number"  name="phone" placeholder="+1 123 456 7890" >
                                    <div class="error" id="phoneerror"></div>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input2">
                                    <p><i class="fa fa-sticky-note"></i>&nbsp;Order notes<span></span></p>
                                    <input type="text" name="orderNotes" placeholder="Notes about your order, e.g. delivery notes ">
                                    <div class="error" id="oerror"></div>

                                </div>
                            </div>
                        </div>

                        <div class="checkout__input2__checkbox">
                            <!-- <label for="stores__list">
                                Store pickup?
                                <input type="checkbox" id="stores__list" name="deliveryoption" onclick="getStores()" value="Store Pickup">
                                <span class="checkmark"></span>
                            </label> -->
                            <input type="radio" name="deliveryoption" value="Home Delivery">
                            <label for="home_dev">Home Delivery</label>
                            <input type="radio" name="deliveryoption" value="Store Pickup">
                            <label for="storepick">Store Pickup</label>
                        </div>

                        <!-- <div class= "store__List" id="store__List" style="display: none;">
                            <table class ='gridtable'>
                              <tr>
                                <td></td>
                                <td><h4>Locations: </h4></td> 
                                <td><h4>Zipcode: </h4></td>
                                <td><h4>Address: </h4></td>
                            </tr>
                            <c:forEach items="${storez}" var="city">
                            <tr>
                                <td>

                                    <input type='radio' name='location' value = "${city.storeID}/${city.storeAddress}/${city.storeZIP}">&nbsp;&nbsp;</td>
                                    <td>${city.storeName}&nbsp;&nbsp;</td>
                                    <td>${city.storeZIP} &nbsp;&nbsp;</td>
                                    <td>${city.storeAddress}&nbsp;&nbsp;</td>
                                </c:forEach>

                            </tr>

                        </table>
                    </div>
                    <script>
                        function getStores() {
                            var x = document.getElementById("store__List");
                            console.log(x);
                            if (x.style.display === "none") {
                                x.style.display = "block";
                            } else {
                                x.style.display = "none";
                            }
                        }
                    </script> -->
                    <div class="col-50">
                        <h3>Payment Details:</h3>
                        <label for="fname">Accepted Cards</label>
                        <div class="icon-container">
                          <i class="fa fa-cc-visa" style="color:navy;"></i>
                          <i class="fa fa-cc-amex" style="color:blue;"></i>
                          <i class="fa fa-cc-mastercard" style="color:red;"></i>
                          <i class="fa fa-cc-discover" style="color:orange;"></i>
                      </div>
                      <div class="row">
                        <div class="col-lg-6">
                            <div class="checkout__input2">
                                <p> <i class=""></i>&nbsp;Credit card number<span>*</span></p>
                                <input type="text" name = "creditcardno">
                                <div class="error" id="crediterror"></div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="checkout__input2">
                                <p> <i class=""></i>&nbsp;Exp Month<span>*</span></p>
                                <input type="text" placeholder="September" name = "exmonth">
                                <div class="error" id="exerror"></div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="checkout__input2">
                                <p> <i class=""></i>&nbsp;Exp Year<span>*</span></p>
                                <input type="text" placeholder="2025" name = "exyear">
                                <div class="error" id="exyerror"></div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="checkout__input2">
                                <p> <i class=""></i>&nbsp;CVV<span>*</span></p>
                                <input type="text" placeholder="123" name = "cvv">
                                <div class="error" id="cvverror"></div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>

            <div class="col-lg-4 col-md-6">
                <div class="checkout__order">
                    <h4>Your Order Summary</h4>
                    <div class="checkout__order__products">Products <span>Total</span></div>
                    <ul>
                        <c:forEach items="${orders}" var="order">
                        <c:set var = "prodSubTotal" scope = "session" value = "${order.price*order.quant}"/>
                        <li>${order.name} <span>$${prodSubTotal}</span></li>
                    </c:forEach>
                                <!-- <li>Fresh Vegetable <span>$151.99</span></li>
                                    <li>Organic Bananas <span>$53.99</span></li> -->
                                </ul>
                                <div class="checkout__order__total">Total <span>$${orderTotal}</span></div>
                                <input type="hidden" name = "tot" value="${orderTotal}">


                                <!-- Trigger the modal with a button -->
                                <button type="submit" class="btn btn-info btn-lg" >PLACE ORDER</button>
                                
                                <style>
                                    .btn-info {
                                        color: #fff;
                                        background-color: #7fad39;
                                        border-color: #46b8da;
                                    }
                                </style>
                                
                            </div>
                        </form>

                        <script>     
                            $('#billing').validate({
                                rules: {
                                    firstname: "required",
                                    lastname: "required",
                                    email : {
                                        required: true,
                                        email: true,
                                    },
                                    street:"required",
                                    apt:"required",
                                    city:"required",
                                    state:"required",
                                    zip:"required",
                                    phone:"required",
                                    creditcardno:"required",
                                    exmonth:"required",
                                    exyear:"required",
                                    cvv:"required",
                                },

                                submitHandler: function(form){

                                    
                                    $.ajax({
                                        url: "Payment",
                                        type: "POST",
                                        data: $("form").serialize(),
                                        success: function(msg){
                                            console.log(msg);
                                            window.location.href = msg;
                                        },
                                        error: function(){
                                            console.log("error occurred while making ajax call;")
                                        }
                                    });
                                }
                            });
                        </script>



                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Checkout Section End -->

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
