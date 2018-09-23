<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Card Number</title>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Art Signin Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->
    <!-- Index-Page-CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <!-- //Custom-Stylesheet-Links -->
    <!--fonts -->
    <link href="//fonts.googleapis.com/css?family=Mukta+Mahee:200,300,400,500,600,700,800" rel="stylesheet">
    <!-- //fonts -->
    <!-- Font-Awesome-File -->
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="all">
</head>

<body>
    <h1 class="title-agile text-center">Anytime Teller Machine</h1>
    <div class="content-w3ls">
        <div class="mobile-screen">
            <div id="phone">
                <div id="screen">
                    <div class="content-top-agile">
                        <h2>Enter Card Number</h2>
                    </div>
                    <form action="LoginServlet" method="post">
                        <div class="field_w3ls">
                            <div class="field-group">
                                <label>Card Number</label>
                                <input name="cardNumber" id="text1" type="number" placeholder="16 digit card Number" required>
                            </div>
                            <!-- <div class="field-group password-rel">
                                <label>password</label>
                                <input id="password-field" type="password" class="form-control" name="password" value="" placeholder="password">
                                <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            </div> -->
                        </div>
                        <div class="wthree-field">
                            <input id="saveForm" name="saveForm" type="submit" value="Click Here" />
                        </div>
                        <!-- <ul class="list-login text-center">
                            <li class="switch-agileits">
                                <input id="check3" name="check3" type="checkbox">
                                <label class="check" for="check3"> keep me signed in</label>
                            </li>
                            <li>
                                <hr>
                                <a href="#" class="text-right">forgot password?</a>
                            </li>
                        </ul> -->
                    </form>
                </div>
                <div id="home"></div>
                <div id="speaker"></div>
            </div>
        </div>
    </div>
    <div class="copyright text-center">
        <p>© Deepak Sharma
        </p>
    </div>
    <!--//copyright-->
    <script src="js/jquery-2.2.3.min.js"></script>
    <!-- script for Show/Hide password field  -->
    <script>
        $(".toggle-password").click(function () {

            $(this).toggleClass("fa-eye fa-eye-slash");
            var input = $($(this).attr("toggle"));
            if (input.attr("type") == "password") {
                input.attr("type", "text");
            } else {
                input.attr("type", "password");
            }
        });
    </script>
    <!-- /script for Show/Hide password field  -->

</body>
<!-- //Body -->

</html>