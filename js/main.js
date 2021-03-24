/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: 
    Version: 1.0
    Created: Colorlib
    ---------------------------------------------------------  */

    'use strict';

    (function ($) {

    /*------------------
        Preloader
        --------------------*/
        $(window).on('load', function () {
            $(".loader").fadeOut();
            $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
            --------------------*/
            $('.featured__controls li').on('click', function () {
                $('.featured__controls li').removeClass('active');
                $(this).addClass('active');
            });
            if ($('.featured__filter').length > 0) {
                var containerEl = document.querySelector('.featured__filter');
                var mixer = mixitup(containerEl);
            }
        });

    /*------------------
        Background Set
        --------------------*/
        $('.set-bg').each(function () {
            var bg = $(this).data('setbg');
            $(this).css('background-image', 'url(' + bg + ')');
        });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
		Navigation
       --------------------*/
       $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
        Categories Slider
        ------------------------*/
        $(".categories__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 4,
            dots: false,
            nav: true,
            navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
            animateOut: 'fadeOut',
            animateIn: 'fadeIn',
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true,
            responsive: {

                0: {
                    items: 1,
                },

                480: {
                    items: 2,
                },

                768: {
                    items: 3,
                },

                992: {
                    items: 4,
                }
            }
        });


        $('.hero__categories__all').on('click', function(){
            $('.hero__categories ul').slideToggle(400);
        });

    /*--------------------------
        Latest Product Slider
        ----------------------------*/
        $(".latest-product__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 1,
            dots: false,
            nav: true,
            navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true
        });

    /*-----------------------------
        Product Discount Slider
        -------------------------------*/
        $(".product__discount__slider").owlCarousel({
            loop: true,
            margin: 0,
            items: 3,
            dots: true,
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true,
            responsive: {

                320: {
                    items: 1,
                },

                480: {
                    items: 2,
                },

                768: {
                    items: 2,
                },

                992: {
                    items: 3,
                }
            }
        });

    /*---------------------------------
        Product Details Pic Slider
        ----------------------------------*/
        $(".product__details__pic__slider").owlCarousel({
            loop: true,
            margin: 20,
            items: 4,
            dots: true,
            smartSpeed: 1200,
            autoHeight: false,
            autoplay: true
        });

    /*-----------------------
		Price Range Slider
       ------------------------ */
       var rangeSlider = $(".price-range"),
       minamount = $("#minamount"),
       maxamount = $("#maxamount"),
       minPrice = rangeSlider.data('min'),
       maxPrice = rangeSlider.data('max');
       rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
       minamount.val('$' + rangeSlider.slider("values", 0));
       maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
        ----------------------------*/
        $("select").niceSelect();

    /*------------------
		Single Product
       --------------------*/
       $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
       --------------------- */
       var proQty = $('.pro-qty');
       proQty.prepend('<span class="dec qtybtn">-</span>');
       proQty.append('<span class="inc qtybtn">+</span>');
       proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find('input').val(newVal);
    });

    // TABLE OPTIONS
    $('.column100').on('mouseover',function(){
      var table1 = $(this).parent().parent().parent();
      var table2 = $(this).parent().parent();
      var verTable = $(table1).data('vertable')+"";
      var column = $(this).data('column') + ""; 

      $(table2).find("."+column).addClass('hov-column-'+ verTable);
      $(table1).find(".row100.head ."+column).addClass('hov-column-head-'+ verTable);
  });

    $('.column100').on('mouseout',function(){
      var table1 = $(this).parent().parent().parent();
      var table2 = $(this).parent().parent();
      var verTable = $(table1).data('vertable')+"";
      var column = $(this).data('column') + ""; 

      $(table2).find("."+column).removeClass('hov-column-'+ verTable);
      $(table1).find(".row100.head ."+column).removeClass('hov-column-head-'+ verTable);
  });

})(jQuery);


// Defining a function to display error message
function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

// Defining a function to validate form 
function validateForm() {
    // Retrieving the values of form elements 
    var first = document.contactForm.First.value;
    var last = document.contactForm.last.value;
    var email = document.contactForm.email.value;
    var saddress = document.contactForm.street.value;
    var aptaddress = document.contactForm.apt.value;
    
    var town = document.contactForm.town.value;
    var state = document.contactForm.state.value;

    var zip = document.contactForm.zip.value;

    var country = document.contactForm.country.value;

    var phone = document.contactForm.phone.value;


    var onotes=document.contactForm.orderNotes.value;

    var creditcardno = document.contactForm.creditcardno.value;
    var exmonth = document.contactForm.exmonth.value;
    var exyear = document.contactForm.exyear.value;
    var cvv = document.contactForm.cvv.value;


    
    // Defining error variables with a default value
    var ferror = lerror = emailErr=aerror=  terror=serror=perror=cerror=phoneerror=oerror  =crediterror=exerror=exyerror=cvverror  = true;
    
    // Validate firstname
    if(first == "") {
        printError("ferror", "Please enter your name");
    } else {
        var regex = /^[a-zA-Z\s]+$/;                
        if(regex.test(first) === false) {
            printError("ferror", "Please enter a valid name");
        } else {
            printError("ferror", "");
            ferror = false;
        }
    }

     // Validate lastname
     if(last == "") {
        printError("lerror", "Please enter your name");
    } else {
        var regex = /^[a-zA-Z\s]+$/;                
        if(regex.test(last) === false) {
            printError("lerror", "Please enter a valid name");
        } else {
            printError("lerror", "");
            lerror = false;
        }
    }
    
    // Validate email address
    if(email == "") {
        printError("emailErr", "Please enter your email address");
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
        } else{
            printError("emailErr", "");
            emailErr = false;
        }
    }
     // Validate street address
     if(saddress == "") {
        printError("serror", "Please enter your street address");
    } else {
        // Regular expression for basic email validation
        var regex = /^\d+\s[A-z]+\s[A-z]+/;
        if(regex.test(saddress) === false) {
            printError("serror", "Please enter a valid street address");
        } else{
            printError("serror", "");
            serror = false;
        }
    }
    
     // Validate apartment address
     if(aptaddress == "") {
        printError("aerror", "Please enter your apartment address");
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(aptaddress) === false) {
            printError("aerror", "Please enter a valid apartment address");
        } else{
            printError("aerror", "");
            aerror = false;
        }
    }



     // Validate town
     if(town == "") {
        printError("terror", "Please Enter your town");
    } else {
        printError("terror", "");
        terror = false;
    }
    

       // Validate state
       if(state == "") {
        printError("serror", "Please Enter your state");
    } else {
        printError("serror", "");
        serror = false;
    }
    
    
     // Validate country
     if(country == "Select") {
        printError("cerror", "Please select your country");
    } else {
        printError("cerror", "");
        cerror = false;
    }



    // Validate mobile number
    if(phone == "") {
        printError("phoneerror", "Please enter your phone number");
    } else {
        var regex = /^[1-9]\d{9}$/;
        if(regex.test(phone) === false) {
            printError("phoneerror", "Please enter a valid 10 digit phone number");
        } else{
            printError("phoneerror", "");
            phoneerror = false;
        }
    }



      // Validate ordernotes
      if(exmonth == "") {
        printError("oerror", "Optional");
    } else {
        printError("oerror", "");
        oerror = false;
    }
    
    

    


        // Validate creditcard
        if(creditcardno == "") {
            printError("crediterror", "Please enter your CreditCard Number");
        } else {
        // Regular expression for basic email validation
        var regex = /^?:3[47][0-9]{13})$/;
        if(regex.test(creditcardno) === false) {
            printError("crediterror", "Please enter a valid CreditCard Number");
        } else{
            printError("crediterror", "");
            crediterror = false;
        }
    }
    


        // Validate month 
        if(exmonth == "") {
            printError("exerror", "Please enter a valid month");
        } else {
            printError("exerror", "");
            exerror = false;
        }



        // Validate year
        if(exyear == "") {
            printError("exyerror", "Please enter a valid year");
        } else {
        // Regular expression for basic email validation
        var regex = /?:(?:19|20)[0-9]{2}/;
        if(regex.test(exyear) === false) {
            printError("exyerror", "Please enter a a valid year");
        } else{
            printError("exyerror", "");
            exyerror = false;
        }
    }
    
    


        // Validate cvv
        if(cvv == "") {
            printError("cvverror", "Please enter a valid cvv");
        } else {
        // Regular expression for basic email validation
        var regex = /^[0-9]{3,4}$/;
        if(regex.test(cvv) === false) {
            printError("cvverror", "Please enter a a valid cvv");
        } else{
            printError("cvverror", "");
            cvverror = false;
        }
    }
    
    // Prevent the form from being submitted if there are any errors
    if((ferror || emailerror || serror || aerror || terror||serror   ||  perror ||cerror || oerror  || crediterror ||  exerror ||  exyerror || cvverror ) == true) {
     return false;
 } 
 // else {
 //        // Creating a string from input data for preview
 //        var dataPreview = "You've entered the following details: \n" +
 //        "First Name: " + first + "\n" +
 //        "Last Name: " + last + "\n" +
 //        "Email Address: " + email + "\n" +
        

 //        // Display input data in a dialog box before submitting the form
 //        // alert(dataPreview);

 //    };
}