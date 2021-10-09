<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng ký - Đăng Nhập</title>
    <style>
        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }

        .pagination a.active {
            background-color: dodgerblue;
            color: white;
        }

        .pagination a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
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
<!-- header_top -->
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
                <h2><span></span> Call us : 0379517607</h2>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- header -->
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
                        <form >
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
<!-- content -->
<div class="container">
    <div class="women_main">
        <!-- start sidebar -->
        <div class="col-md-3 s-d">
            <div class="w_sidebar">
                <div class="w_nav1">
                    <h4>All</h4>
                    <ul>
                        <li><a href="#">Shirt</a></li>
                        <li><a href="#">Book</a></li>
                        <li><a href="#">Water Bottle</a></li>
                        <li><a href="#">Course</a></li>
                        <li><a href="#">Other Products</a></li>
                        <li><a href="#">Sale</a></li>
                    </ul>
                </div>
                <h3>filter by</h3>
                <section class="sky-form">
                    <h4>catogories</h4>
                    <div class="row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Shirt</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Book</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Water Bottle</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Course</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other Products</label>
                        </div>
                    </div>
                </section>
                <section class="sky-form">
                    <h4>brand</h4>
                    <div class="row1 scroll-pane">
                        <div class="col col-4">
                            <label class="checkbox"><input type="checkbox" name="checkbox"
                                                           checked=""><i></i>Codegym</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Huongtran</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>HungNoi</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>SiNgu</label>
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>HuongNguyen</label>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- start content -->
        <div class="col-md-9 w_content">
            <div class="women">
                <a href="#"><h4>Product - <span>4449 itemms</span></h4></a>
                <ul class="w_nav">
                    <li>Sort :</li>
                    <li><a class="active" href="#">popular</a></li>
                    |
                    <li><a href="#">new </a></li>
                    |
                    <li><a href="#">discount</a></li>
                    |
                    <li><a href="#">price: Low High </a></li>
                    <div class="clear"></div>
                </ul>
                <div class="clearfix"></div>
            </div>
            <!-- grids_of_4 -->
            <c:forEach items="${products}" var="product">
                <div class="grids_of_4">
                    <div class="grid1_of_4">
                        <div class="content_box" style="margin: 20px"><a
                                href="/product?action=view&product_id=${product.product_id}">
                            <img src="${product.product_image}" alt="ava" height="100" width="100">
                        </a>
                            <h4><a href="/product?action=view&product_id=${product.product_id}">${product.product_name}</a></h4>
                            <p>${product.description}</p>
                            <div class="grid_1 simpleCart_shelfItem">
                                <div class="item_add"><span class="item_price"><h6>${product.product_price}</h6></span>
                                </div>
                                <div class="item_add"><span class="item_price"><a href="/order?action=add&product_id=${product.product_id}">add to cart</a></span></div>
                            </div>
                        </div>
                    </div>

                </div>
            </c:forEach>
            <div class="clearfix"></div>
            <div class="pagination" style="margin-left: 250px">
                <a href="#">«</a>
                <a class="active" href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">6</a>
                <a href="#">»</a>
            </div>
        </div>
        <!-- end content -->
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
