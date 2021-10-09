<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CheckOut</title>
    <link href="../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary JavaScript plugins) -->
    <script type='text/javascript' src="../js/jquery-1.11.1.min.js"></script>
    <!-- Custom Theme files -->
    <link href="../css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
    <!-- start menu -->
    <link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="../js/megamenu.js"></script>
    <script>$(document).ready(function () {
        $(".megamenu").megamenu();
    });</script>
    <script src="../js/menu_jquery.js"></script>
    <script src="../js/simpleCart.min.js"></script>
</head>
<body>
<div class="top_bg" style="color: yellowgreen">
    <div class="container">
        <div class="header_top">
            <div class="top_right">
                <ul>
                    <li><a href="#">help</a></li>
                    |
                    <li><a href="contact.html">Contact</a></li>
                    |
                    <li><a href="#">Delivery information</a></li>
                </ul>
            </div>
            <div class="top_left">
                <h2><span></span> Call us : 032 2352 782</h2>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="header_bg">
    <div class="container">
        <div class="header">
            <div class="head-t">
                <div class="logo">
                    <a href="home.jsp"><img src="images/logo3h1s.jpg" class="img-responsive" width="300" height="60"
                                            alt=""/> </a>
                </div>
                <!-- start header_right -->
                <div class="header_right">
                    <div class="rgt-bottom">
                        <div class="log">
                            <div class="login">
                                <p>${user.user_name}</p>
                                <a href="/">Logout</a>
                            </div>
                        </div>
                        <div class="cart box_1" style="margin-left: 5px">
                            <a href="#">
                                <h3><span class="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity"
                                                                                       class="simpleCart_quantity">0</span>
                                    items)<img src="images/bag.png" alt=""></h3>
                            </a>
                            <p><a href="javascript:;" class="simpleCart_empty">(empty card)</a></p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="create_btn">
                            <a href="/order">CHECKOUT</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="search" style="height: 39px">
                        <form>
                            <input type="text" value="" placeholder="search..." name="q">
                            <input type="submit" value="">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <!-- start header menu -->
            <ul class="megamenu skyblue">
                <li class="active grid"><a class="color1" href="home.jsp">Home</a></li>
                <li class="grid"><a class="color2" href="/categories?action=view&category_id=${1}">Shirt</a></li>
                <li class="grid"><a class="color2" href="/categories?action=view&category_id=${2}">Book</a></li>
                <li class="grid"><a class="color2" href="#">Water Bottle</a></li>
                <li class="grid"><a class="color2" href="#">Course</a></li>
                <li class="grid"><a class="color2" href="/categories?action=view&category_id=${3}">Other Products</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="check">
        <div class="col-md-3 cart-total">
            <a class="continue" href="#">Back</a>
            <div class="price-details">
                <h3>Order</h3>
                <span>Name Customer</span>
                <span class="total1">: ${user.user_name}</span>
                <span>Phone</span>
                <span class="total1">: ${user.phone}</span>
                <span>Discount Code</span>
                <span class="total1">: </span>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
            <a class="order" href="#">Place Order</a>
        </div>
        <div class="col-md-9 cart-items">
            <h1>My Shopping Bag</h1>
            <c:forEach items="${orderDetails}" var="orderDetails">
                <div class="cart-header">

                    <div class="cart-sec simpleCart_shelfItem">

                        <div class="cart-item cyc">
                            <img src="${orderDetails.product.product_image}" style="width: 300px; height: 300px"
                                 class="img-responsive" alt="ava">
                        </div>
                        <div class="cart-item-info">
                            <h3>${orderDetails.product.product_name}<span>${orderDetails.product.product_code}</span>
                            </h3>
                            <form action="/order?action=buynow&product_id=${orderDetails.product.product_id}" method="post">
                            <ul class="qty">
                                <li><p>Quantity: ${orderDetails.quantity}</p></li>
                            </ul>
                                <input type="hidden" name="idDetailO" value="${orderDetails.order_detail_id}">
                                <input type="hidden" name="quantity" value="${orderDetails.quantity}">
                                <button>Buy</button>
                            </form>
                        </div>

                    </div>
                    <div class="clearfix"></div>
                </div>
            </c:forEach>
        </div>
        <div class="clearfix"></div>
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
            <div class="clearfix"></div>
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
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
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
            <div class="clearfix"></div>
            <li><i class="add"> </i>Jl. Haji Muhidin, Blok G no.69</li>
            <li><i class="phone"> </i>025-2839341</li>
            <li><a href="mailto:info@example.com"><i class="mail"> </i>info@sitename.com </a></li>

        </div>
        <div class="clearfix"></div>
        <p>Copyrights © 2015 Gretong. All rights reserved | Template by <a href="http://w3layouts.com/">W3layouts</a>
        </p>
    </div>
</div>
</body>
</html>
