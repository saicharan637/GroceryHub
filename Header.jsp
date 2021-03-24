<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">


<!-- Header Section Begin -->
<header class="header">
    <div class="container">
        <div class="row">
            <!-- <div class="col-lg-3"> -->
                <div class="header__logo">
                    <a href="./index.html"><img src="" alt=""></a>
                    <!-- </div> -->
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul style="width: 1400px;">
                            <li ><a href="./index.jsp">Home</a></li>
                            <c:choose><c:when test= "${usertype == 'Admin'}" ></c:when>
                            <c:otherwise><li><a href="contact.jsp">Contact Us</a></li></c:otherwise>
                        </c:choose>
                        
                        <li class="header__top__right__auth"><a href="#"><i class="fa fa-user"></i> Account</a>
                            <ul class="header__menu__dropdown">
                                <c:choose>
                                <c:when test= "${usr == ''}" >
                                <li><a href="./Login.jsp">Login</a></li>
                                <li><a href="./CreateID.jsp">Create Account</a></li>

                            </c:when>
                            <c:otherwise>
                            <li><a href="./Logout">Log out</a></li>
                            <c:choose><c:when test= "${usertype == 'Admin'}" ></c:when>
                            <c:otherwise>
                            <li><a href="./CustomerOrderHistory">Order History</a></li>
                        </c:otherwise>
                    </c:choose>



                </c:otherwise>
            </c:choose>
        </ul></li>
        <c:choose>
        <c:when test= "${usertype == 'StoreManager' && usr != 'Customer'}" >
        <li class="header__top__right__auth"><a href="#"><i class="fa fa-user"></i> Actions</a>
            <ul class="header__menu__dropdown">
                <li><a href="./StoreManager.jsp?operation=add">Add</a></li>
                <li><a href="./StoreManager.jsp?operation=update">Update</a></li>
                <li><a href="./StoreManager.jsp?operation=delete">Delete</a></li>
                <li><a href="./smsalesreport.jsp">Analytics</a></li>
            </ul></li>
        </c:when>
        <c:when test= "${usertype == 'Admin' && usr != 'Customer'}" >
        <li class="header__top__right__auth"><a href="#"><i class="fa fa-user"></i> Actions</a>
            <ul class="header__menu__dropdown">
                <li><a href="./AdminPage.jsp?operation=add">Add</a></li>
                <li><a href="./AdminPage.jsp?operation=update">Update</a></li>
                <li><a href="./AdminPage.jsp?operation=delete">Delete</a></li>
                <li><a href="./Admin?operation=stocks">Product Stock</a></li>
                <li><a href="./AdminProductsSold">Analytics</a></li>
                <li><a href="./createstaffID.jsp">Store Manager Creation</a></li>
                <li><a href="./heatmaps.jsp">Heat Maps</a></li>
                <li><a href="./CustomerCare">Customer Feedback</a></li>
                <li><a href="./SelectProdReview">Reviews</a></li>
            </ul></li>
        </c:when>
    </c:choose>
    <c:choose><c:when test= "${usertype == 'Admin'}" ></c:when>
    <c:otherwise>
    <li><a href="./Cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
</c:otherwise>
</c:choose>


<c:choose>
<c:when test= "${usr == 'Customer' || usertype ==null || usertype=='Customer'}" >
<li><a href="./StoreList"><i class="fa fa-user"></i>Stores</a></li>

</c:when>
<c:otherwise>
<li><a href="./StoreList"><i class="fa fa-user"></i>Stores</a></li>
</c:otherwise>

</c:choose>

<li><a href="#"><i class="fa fa-user"></i>Welcome ${usertype}&nbsp;${usr}</a></li>
<li><a>${sid}&nbsp;${storeLocation}, ${stozip}</a></li>        
</div>
</ul>
</nav>
</div>

</div>
<div class="humberger__open">
    <i class="fa fa-bars"></i>
</div>
</div>
</header>
<!-- Header Section End -->
</html>
