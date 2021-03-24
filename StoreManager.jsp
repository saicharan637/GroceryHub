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
                                <span>Support 24/7 timeline</span>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Login Form Begins -->
    <section class="id form">
        <div class="container">
            <!-- <div style="color:red;">
                <br>${login_msg}
            </div> -->
            <form action="<%= request.getContextPath() %>/StoreManager" method="post">
                <% pageContext.setAttribute("val", request.getParameter("operation"), PageContext.APPLICATION_SCOPE);%>
                <%String usr =(String)session.getAttribute("usr");%>
                <input type="hidden" name = username value = "${usr}">
                <c:choose>
                <c:when test= "${val == 'add'}" >
                <h2>Add Product</h2><br>
                <div class="checkout__input">
                    <p>ProductId<span>*</span></p>
                    <input type="text" name = "ProductId">
                </div>
                

                <div class="row">
                    <div class="col-lg-6">
                        <div class="checkout__input3">
                         <p>Category<span>*</span></p>
                         <select name='Category' class='input'><option value='Fruits&Vegetables' selected>Fruits&Vegetables</option><option value='Dairy&Bakery' >Dairy&Bakery</option><option value='FreshMeat' >FreshMeat</option><option value='frozen' >frozen</option><option value='canned' >canned</option><option value='Beverages'>Beverages</option><option value='Personal Care'>Personal Care</option><option value='Home Care'>Home Care</option></select>
                         <div class="error" id="cerror"></div>
                     </div>
                 </div>
             </div>


             <div class="checkout__input">
                <p>ProductName<span>*</span></p>
                <input type="text" name = "ProductName">
            </div>
            <div class="checkout__input">
                <p>Image<span>*</span></p>
                <input type='file' id='image' name='productImage'size='50'></input>
            </div>
            <div class="checkout__input">
                <p>Price<span>*</span></p>
                <input type="text" name = "Price">
            </div>
            <div class="checkout__input">
                <p>Discount<span>*</span></p>
                <input type="text" name = "Discount">
            </div>
            <div class="checkout__input">
                <p>Weight<span>*</span></p>
                <input type="text" name = "Weight">
            </div>
            <div class="checkout__input">
                <p>Number_Of_Items<span>*</span></p>
                <input type="text" name = "Number_Of_Items">
            </div>
            <input type="hidden" name = "button" value="add" >
            <button type="submit" class="site-btn">Add</button>
        </c:when>
        <c:when test= "${val == 'update'}" >
        <h2>Update Product</h2><br>
        <div class="checkout__input">
            <p>ProductId<span>*</span></p>
            <input type="text" name = "ProductId">
        </div>
        
        <div class="row">
            <div class="col-lg-6">
                <div class="checkout__input3">
                 <p>Category<span>*</span></p>
                 <select name='Category' class='input'><option value='Fruits&Vegetables' selected>Fruits&Vegetables</option><option value='Dairy&Bakery' >Dairy&Bakery</option><option value='FreshMeat' >FreshMeat</option><option value='frozen' >frozen</option><option value='canned' >canned</option><option value='Beverages'>Beverages</option><option value='Personal Care'>Personal Care</option><option value='Home Care'>Home Care</option></select>
                 <div class="error" id="cerror"></div>
             </div>
         </div>
     </div>

     <div class="checkout__input">
        <p>ProductName<span>*</span></p>
        <input type="text" name = "ProductName">
    </div>
    <div class="checkout__input">
        <p>Image<span>*</span></p>
        <input type='file' id='image' name='productImage'size='50'></input>
    </div>
    <div class="checkout__input">
        <p>Price<span>*</span></p>
        <input type="text" name = "Price">
    </div>
    <div class="checkout__input">
        <p>Discount<span>*</span></p>
        <input type="text" name = "Discount">
    </div>
    <div class="checkout__input">
        <p>Weight<span>*</span></p>
        <input type="text" name = "Weight">
    </div>
    <div class="checkout__input">
        <p>Number_Of_Items<span>*</span></p>
        <input type="text" name = "Number_Of_Items">
    </div>
    <input type="hidden" name = "button" value="update" >
    <button type="submit" class="site-btn">Update</button>
</c:when>
<c:when test= "${val == 'delete'}" >
<h2>Delete Product</h2><br>
<div class="checkout__input">
    <p>ProductId<span>*</span></p>
    <input type="text" name = "ProductId">
</div>
<input type="hidden" name = "button" value="delete" >
<button type="submit" class="site-btn">Delete</button>
</c:when>
<c:otherwise>
<div class="checkout__input">
    <h2>${message}</h2><br>
</div>
</c:otherwise>
</c:choose>
</form>
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