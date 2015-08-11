<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description"
	content="Recipes designed to encourage healthy eating habbits to help fight type 2 diabetes">
<meta name="author" content="DTeam">
<link rel="icon" type="image/ico"
	href="<c:url value="/resources/img/favicon.ico" />" />

<title>Choose your favorite recipe</title>

<!-- Bootstrap CSS
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />  -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/recipe.css" />" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elegant-icons-style.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome.min.css"/> " />


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<header class="header">
		<div class="toggle-nav">
			<div class="icon-reorder tooltips"
				data-original-title="Toggle Navigation" data-placement="bottom"></div>
		</div>

		<!--logo start-->
		<a href="dashboard" class="logo">Recipes <span class="lite">Dashboard</span></a>
		<!--logo end-->
		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <span class="profile-ava">
							<img src="<c:url value="resources/img/user-icon.png" />"
							alt="Default User Image" />

					</span> <span class="username" id="userName">${userName}</span> <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>

						<li><a href="#" onclick="signOut()"><i
								class="icon_key_alt"></i> Log Out</a></li>
					</ul></li>
				<!-- user login dropdown end -->
			</ul>
			<!-- notificatoin dropdown end-->
		</div>
	</header>

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron"></div>
				
				<div class="row">
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="chicken barley wraps" src="<c:url value="resources/img/chicken_barley_wraps.jpg"/> " />
							<h2>Healthy Grilled Chicken Barley Wraps</h2>
							<span class="teaser">These quick and easy lettuce wraps</span><span class="complete"> have the veggie crunch 
							of a salad, but with added grains and protein to keep you satisfied until dinner.</span>
							<a href="#" class="more"> more...</a>
						</div>
						
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="Tuscan Tuna with Tomato Salad" src="<c:url value="resources/img/tuscan-tuna-with-tomato-salad.jpg"/> " />
							<h2>Tuscan Tuna with Tomato Salad</h2>
							<span class="teaser">For a light 15-minute dinner, grill tuna</span><span class="complete"> steaks and 
							serve on top of a fresh fennel and tomato salad.</span>
							<a href="#" class="more"> more...</a>
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="Tuscan Tuna with Tomato Salad" src="<c:url value="resources/img/parmesan-crusted-fish.jpg"/> " />
							<h2>Parmesan-Crusted Fish</h2>
							<span class="teaser">A Parmesan cheese and bread crumb topping coats this baked 
							fish main dish </span><span class="complete"> that's ready to serve in less than 30 minutes.  Add carrots and greens to round out the meal.</span>
							<a href="#" class="more"> more...</a>
						</div>
					</div>
					</div>
					<div class="row row-2">
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="Roasted Vegetables with Fresh Mozzarella" src="<c:url value="resources/img/roasted-vegetables-with-fresh-mozzarella.jpg"/> " />
							<h2>Roasted Vegetables with Fresh Mozzarella</h2>
							<span class="teaser">Tent the roasted vegetables after cooking</span><span class="complete">  to allow the mozzarella to melt
							 without any additional heat.</span>
							<a href="#" class="more"> more...</a>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="Mediterranean Breakfast Sandwiches" src="<c:url value="resources/img/mediterranean-breakfast-sandwiches.jpg"/> " />
							<h2>Mediterranean Breakfast Sandwiches</h2>
							<span class="teaser">Hallelujah, a breakfast sandwich with real, fresh vegetables!</span><span class="complete">  This egg dish takes less than 10 minutes 
							(translation: quicker than a trip to the drive-thru).</span>
							<a href="#" class="more"> more...</a>
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<div class="image">
							<img alt="Chipotle-&-Orange Grilled Chicken" src="<c:url value="resources/img/chipotle-orange-grilled-chicken.jpg"/> " />
							<h2>Chipotle-&-Orange Grilled Chicken</h2>
							<span class="teaser">Chipotle peppers in adobo sauce contribute</span><span class="complete"> a rich smokiness to this 
							quick orange-infused barbecue sauce.</span>
							<a href="#" class="more"> more...</a>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div><!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->

		<!--  	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item active">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a>
				</div>
			</div> -->
			<!--/.sidebar-offcanvas-->
		</div><!--/row-->
	</div><!--/.container-->

	<!-- Bootstrap core JavaScript-->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.1.7.0.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/offcanvas.js" />"></script>

</body>
</html>

