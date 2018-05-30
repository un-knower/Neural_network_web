<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>猜一猜</title>

<!-- Bootstrap Core CSS -->
<link href="asset/css/bootstrap.min.css" rel="stylesheet">

<!-- Font Awesome CSS -->
<link href="css/font-awesome.min.css" rel="stylesheet">


<!-- Animate CSS -->
<link href="css/animate.css" rel="stylesheet">

<!-- Owl-Carousel -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">

<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

<!-- Colors CSS -->
<link rel="stylesheet" type="text/css" href="css/color/green.css">



<!-- Colors CSS -->
<link rel="stylesheet" type="text/css" href="css/color/green.css"
	title="green">
<link rel="stylesheet" type="text/css" href="css/color/light-red.css"
	title="light-red">
<link rel="stylesheet" type="text/css" href="css/color/blue.css"
	title="blue">
<link rel="stylesheet" type="text/css" href="css/color/light-blue.css"
	title="light-blue">
<link rel="stylesheet" type="text/css" href="css/color/yellow.css"
	title="yellow">
<link rel="stylesheet" type="text/css" href="css/color/light-green.css"
	title="light-green">

<!-- Custom Fonts -->
<link href='http://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>


<!-- Modernizer js -->
<script src="js/modernizr.custom.js"></script>




</head>
<body class="index">
	
		<!-- Start Home Page Slider -->
		<section id="page-top"> <!-- Carousel -->
		<div id="main-slide" class="carousel slide" data-ride="carousel">

			<!-- Carousel inner -->
			<div class="carousel-inner">
				<div class="item active">
					<img class="img-responsive" src="images/header-bg-1.jpg"
						alt="slider">
					<div class="slider-content">
						<div class="col-md-12 text-center">
							<h1 class="animated3">
								<span><strong>猜猜</strong>你可能最喜欢的视频APP</span>
							</h1>
							<p class="animated2">
								目前仅对北京用户开放测试<br> 如果你未曾使用过APP观看视频，让我们预测下你的视频APP的最爱
							</p>
							<h1 class="animated3">
								<span><strong><br><%=request.getAttribute("info")==null ? "":request.getAttribute("info")%></strong></span>
							</h1>
							<a href="#feature" class="page-scroll btn btn-primary animated1">Read
								More</a>
						</div>
					</div>
				</div>
				<!--/ Carousel item end -->
			</div>
			<!-- Carousel inner end-->
		</div>
		<!-- /carousel --> </section>
		<!-- End Home Page Slider -->



		<!-- Start Feature Section -->
		<section id="feature" class="feature-section">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="feature">
						<i class="fa fa-magic"></i>
						<div class="feature-content">
							<h4>AGE</h4>
							<!-- <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit</p>  -->
						</div>
					</div>
				</div>
				<!-- /.col-md-3 -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="feature">
						<i class="fa fa-gift"></i>
						<div class="feature-content">
							<h4>Gender</h4>
						</div>
					</div>
				</div>
				<!-- /.col-md-3 -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="feature">
						<i class="fa fa-magic"></i>
						<div class="feature-content">
							<h4>VOICE</h4>
							<!-- <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor. reprehenderit</p>  -->
						</div>
					</div>
				</div>
				<!-- /.col-md-3 -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="feature">
						<i class="fa fa-gift"></i>
						<div class="feature-content">
							<h4>INTERNET</h4>
						</div>
					</div>
				</div>
				<!-- /.col-md-3 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container --> </section>
		<!-- End Feature Section -->

		<!-- Clients Aside -->


        <form action="doPredict" method="post">
		<section id="contact" class="contact" align="center">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title text-left">
						<h3>请输入你的手机号</h3>
						<!--<p class="white-text">Duis aute irure dolor in reprehenderit in voluptate</p>-->
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="row">
						<div class="col-md-6">
							<div class="form-group" align="center">

								<input type="tel" class="form-control"
									placeholder="Your Phone *" id="phone" name="phone" required
									data-validation-required-message="Please enter your phone number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>

						<div class="col-lg-12 text-left">
							<div id="success"></div>
							<input type="submit" class="btn btn-primary"
								value="  确         定  " />
						</div>
					</div>

				</div>
			</div>
		</div>

		</section>
	</form>

		<div id="loader">
			<div class="spinner">
				<div class="dot1"></div>
				<div class="dot2"></div>
			</div>
		</div>



		<!-- jQuery Version 2.1.1 -->
		<script src="js/jquery-2.1.1.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="asset/js/bootstrap.min.js"></script>

		<!-- Plugin JavaScript -->
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/classie.js"></script>
		<script src="js/count-to.js"></script>
		<script src="js/jquery.appear.js"></script>
		<script src="js/cbpAnimatedHeader.js"></script>
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/jquery.fitvids.js"></script>
		<script src="js/styleswitcher.js"></script>

		<!-- Contact Form JavaScript -->
		<script src="js/jqBootstrapValidation.js"></script>
		<!--<script src="js/contact_me.js"></script>-->

		<!-- Custom Theme JavaScript -->
		<script src="js/script.js"></script>

</body>
</html>