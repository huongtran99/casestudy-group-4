<%--
  Created by IntelliJ IDEA.
  User: dangv
  Date: 10/2/2021
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary JavaScript plugins) -->
    <script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- Custom Theme files -->
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
    <!-- start menu -->
    <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/megamenu.js"></script>
    <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
    <script src="js/menu_jquery.js"></script>
</head>
<body>
<!-- header_top -->
<div class="top_bg">
    <div class="container">
        <div class="header_top">
            <div class="top_right">
                <ul>
                    <li><a href="#">help</a></li>|
                    <li><a href="contact.html">Contact</a></li>|
                    <li><a href="#">Delivery information</a></li>
                </ul>
            </div>
            <div class="top_left">
                <h2><span></span> Call us : 032 2352 782</h2>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<div class="header_bg">
    <div class="container">
        <div class="header">
            <div class="head-t">
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo3h1s.jpg" class="img-responsive" width="300" height="60" alt=""/> </a>
                </div>
                <!-- start header_right -->
                <div class="header_right">
                    <div class="rgt-bottom">
                        <div class="log">
                            <div class="login" >
                                <div id="loginContainer"><a href="/?action=login" id="loginButton"><span>Login</span></a>
                                    <div id="loginBox">
                                        <form id="loginForm" method="post">
                                            <fieldset id="body">
                                                <fieldset>
                                                    <label for="user_name">User Name</label>
                                                    <input type="text" name="user_name" id="user_name">
                                                </fieldset>
                                                <fieldset>
                                                    <label for="password">Password</label>
                                                    <input type="text" name="password" id="password">
                                                </fieldset>
                                                <input type="submit" id="login" value="Sign in">
                                                <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
                                            </fieldset>
                                            <span><a href="#">Forgot your password?</a></span>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="reg">
                            <a href="/?action=register">REGISTER</a>
                        </div>
                        <div class="cart box_1">
                            <a href="#">
                                <h3> <span class="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span> items)<img src="images/bag.png" alt=""></h3>
                            </a>
                            <p><a href="javascript:;" class="simpleCart_empty">(empty card)</a></p>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="create_btn">
                            <a href="#">CHECKOUT</a>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="search" style="height: 39px">
                        <form>
                            <input type="text" value="" placeholder="search...">
                            <input type="submit" value="">
                        </form>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <!-- start header menu -->
            <ul class="megamenu skyblue">
                <li class="active grid"><a class="color1" href="#">Home</a></li>
                <li class="grid"><a class="color2" href="#">Shirt</a></li>
                <li class="grid"><a class="color2" href="#">Book</a></li>
                <li class="grid"><a class="color2" href="#">Water Bottle</a></li>
                <li class="grid"><a class="color2" href="#">Course</a></li>
                <li class="grid"><a class="color2" href="#">Other Products</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- content -->
<div class="container">
    <div class="main">
        <!-- start registration -->
        <div class="registration">
            <div class="registration_left">
                <h2><span> create an account </span></h2>
                <c:if test="${message}">
                    <p>${message}</p>
                </c:if>
                <!-- [if IE]
                    < link rel='stylesheet' type='text/css' href='ie.css'/>
                 [endif] -->

                <!-- [if lt IE 7]>
                    < link rel='stylesheet' type='text/css' href='ie6.css'/>
                <! [endif] -->
                <script>
                    (function() {

                        // Create input element for testing
                        var inputs = document.createElement('input');

                        // Create the supports object
                        var supports = {};

                        supports.autofocus   = 'autofocus' in inputs;
                        supports.required    = 'required' in inputs;
                        supports.placeholder = 'placeholder' in inputs;

                        // Fallback for autofocus attribute
                        if(!supports.autofocus) {

                        }

                        // Fallback for required attribute
                        if(!supports.required) {

                        }

                        // Fallback for placeholder attribute
                        if(!supports.placeholder) {

                        }

                        // Change text inside send button on submit
                        var send = document.getElementById('register-submit');
                        if(send) {
                            send.onclick = function () {
                                this.innerHTML = '...Sending';
                            }
                        }

                    })();
                </script>
                <div class="registration_form">
                    <!-- Form -->
                    <form id="registration" method="post">
                        <div>
                            <label>
                                <input placeholder="user name:" type="text" tabindex="1" name="user_name" required autofocus>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="email address:" type="email" name="email" tabindex="3" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="phone number:" type="text" tabindex="2" name="phone" required autofocus>
                            </label>
                        </div>
                        <div class="sky-form">
                            <div class="sky_form1">
                                <ul>
                                    <li><label class="radio left"><input type="radio" name="gender" value="Nam" checked=""><i></i>Male</label></li>
                                    <li><label class="radio"><input type="radio" name="gender" value="Nữ"><i></i>Female</label></li>
                                    <div class="clearfix"></div>
                                </ul>
                            </div>
                        </div>
                        <div>
                            <label>
                                <input placeholder="password" type="password" name="password" tabindex="4" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="about:" type="text" tabindex="2" name="about" required autofocus>
                            </label>
                        </div>
                        <div>
                            <input type="submit" value="create an account" id="register">
                        </div>
                        <div class="sky-form">
                            <label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>i agree to shoppe.com &nbsp;<a class="terms" href="#"> terms of service</a> </label>
                        </div>
                    </form>
                    <!-- /Form -->
                </div>
            </div>
            <div class="registration_left">
                <h2>existing user</h2>
                <div class="registration_form">
                    <!-- Form -->
                    <form id="registration_form" action="contact.php" method="post">
                        <div>
                            <label>
                                <input placeholder="email:" type="email" tabindex="3" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="password" type="password" tabindex="4" required>
                            </label>
                        </div>
                        <div>
                            <input type="submit" value="sign in" id="register-submit">
                        </div>
                        <div class="forget">
                            <a href="#">forgot your password</a>
                        </div>
                    </form>
                    <!-- /Form -->
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- end registration -->
    </div>
</div>
<div class="foot-top">
    <div class="container">
        <div class="col-md-6 s-c">
            <li>
                <div class="fooll">
                    <h5>follow us on</h5>
                </div>
            </li>
            <li>
                <div class="social-ic">
                    <ul>
                        <li><a href="#"><i class="facebok"> </i></a></li>
                        <li><a href="#"><i class="twiter"> </i></a></li>
                        <li><a href="#"><i class="goog"> </i></a></li>
                        <li><a href="#"><i class="be"> </i></a></li>
                        <li><a href="#"><i class="pp"> </i></a></li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
            </li>
            <div class="clearfix"> </div>
        </div>
        <div class="col-md-6 s-c">
            <div class="stay">
                <div class="stay-left">
                    <form>
                        <input type="text" placeholder="Enter your email to join our newsletter" required="">
                    </form>
                </div>
                <div class="btn-1">
                    <form>
                        <input type="submit" value="join">
                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="col-md-3 cust">
            <h4>CUSTOMER CARE</h4>
            <li><a href="#">Help Center</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="buy.html">How To Buy</a></li>
            <li><a href="#">Delivery</a></li>
        </div>
        <div class="col-md-2 abt">
            <h4>ABOUT US</h4>
            <li><a href="#">Our Stories</a></li>
            <li><a href="#">Press</a></li>
            <li><a href="#">Career</a></li>
            <li><a href="contact.html">Contact</a></li>
        </div>
        <div class="col-md-2 myac">
            <h4>MY ACCOUNT</h4>
            <li><a href="register.html">Register</a></li>
            <li><a href="#">My Cart</a></li>
            <li><a href="#">Order History</a></li>
            <li><a href="buy.html">Payment</a></li>
        </div>
        <div class="col-md-5 our-st">
            <div class="our-left">
                <h4>OUR STORES</h4>
            </div>
            <div class="our-left1">
                <div class="cr_btn">
                    <a href="#">SOLO</a>
                </div>
            </div>
            <div class="our-left1">
                <div class="cr_btn1">
                    <a href="#">BOGOR</a>
                </div>
            </div>
            <div class="clearfix"> </div>
            <li><i class="add"> </i>Jl. Haji Muhidin, Blok G no.69</li>
            <li><i class="phone"> </i>025-2839341</li>
            <li><a href="mailto:info@example.com"><i class="mail"> </i>info@sitename.com </a></li>

        </div>
        <div class="clearfix"> </div>
        <p>Copyrights © 2015 Gretong. All rights reserved | Template by <a href="http://w3layouts.com/">W3layouts</a></p>
    </div>
</div>
</body>
</html>
