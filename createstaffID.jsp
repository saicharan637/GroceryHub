<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    
</head>

<body>

    <jsp:include page="Header.jsp" />

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">

                </div>

            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Form Section Begins -->
    <section class="id form">
        <div class="container">
            <div class="checkout__form">
                <div class="row">
                    <form id="staff-form" action="<%= request.getContextPath() %>/StaffRegistration" method="post">
                        <div class="col-lg-8 col-md-6">
                            <div class="checkout__input3">
                                <p>Username<span>*</span></p>
                                <input type="text" name = "username">
                            </div>

                            <div class="checkout__input3">
                                <p>Email id<span>*</span></p>
                                <input type="text" name = "email">
                            </div>
                            <div class="checkout__input3">
                                <p>Store ID<span>*</span></p>
                                <select name="storeid" >
                                    <option value="1">Store ID 1</option>
                                    <option value="2">Store ID 2</option>
                                    <option value="3">Store ID 3</option>
                                    <option value="4">Store ID 4</option>
                                    <option value="5">Store ID 5</option>
                                </select>
                                <br>&nbsp;
                            </div>
                            <div class="checkout__input3">
                                <p>Password<span>*</span></p>
                                <input type="password" name = "password" id="password">
                            </div>
                            <div class="checkout__input3">   
                                <p>ConfirmPassword<span>*</span></p>
                                <input type="password" name="repass">
                            </div>
                            <div id="userexist">
                                <br>
                            </div>
                            <br><br>
                            <button type="submit" class="site-btn8">CreateID</button>
                        </div>
                    </form>
                    <script>     
                        $('#staff-form').validate({
                            rules: {
                                username: "required",
                                email : {
                                    required: true,
                                    email: true,
                                },
                                password: "required",
                                repass:{
                                    required: true,
                                    equalTo: '#password',
                                },
                            },

                            submitHandler: function(form){


                                $.ajax({
                                    url: "StaffRegistration",
                                    type: "POST",
                                    data: $("form").serialize(),
                                    success: function(msg){
                                        console.log(msg);
                                        if(msg === 'true'){
                                            $('#userexist').html('<h5 style="color: red;">User already exists</h5>');
                                        }else{
                                            window.location.href = msg;
                                        }
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