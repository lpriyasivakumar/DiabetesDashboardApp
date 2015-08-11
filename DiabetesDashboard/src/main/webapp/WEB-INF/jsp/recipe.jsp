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
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
						</div>
					</div>
					
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4 img-container">
						<h2>Heading</h2>
						<div class="image">
							<img alt="" src="https://placeimg.com/250/200/any/grayscale">
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/offcanvas.js" />"></script>

	<script type="text/javascript">
	function loadImages(url, container){
		/*$.ajax({
			  dataType: "json",
			  url: 'https://api.edamam.com/search?q=chicken',
			  success: function(data){
				  var items = [];
				  $.each( data['image'], function( key, image ) {
				    var mylist = '<img src="' +image['url']+ '" alt="' + image['title']+ '">';
				    $('.image').append(mylist);
				  });
			  }
			});*/
		 $.getJSON(url, function (data) {
		        if (typeof data === 'object') {
		        	$.each(data['image'], function (key, image) {
		        	    $.each(image, function(i,val){
		        	        var mylist = '<img src="' + image['url'] + '" alt="' + image['title'] + '">';
		        	        $(container).append(mylist);
		        	    })
		        	});
		        }
		    });
	};
	
	 $(function(){
	     loadImages('https://api.edamam.com/search?q=chicken', '.image');
	  });
	</script>


	<!--  
	<script>
	(function() {
	  var edamamAPI = "https://api.edamam.com/search?q=chicken&app_id=$&app_key=$3a57699b3ae8620a12b8f41048d3e9b2";
	  $.getJSON( edamamAPI, {
	    tags: "chicken",
	    app_id:2c83fd2e
	    app_key:3a57699b3ae8620a12b8f41048d3e9b2
	    tagmode: "any",
	    format: "json"
	  })
	    .done(function( data ) {
	      $.each( data.items, function( i, item ) {
	        $( "<img>" ).attr( "src", item.media.m ).appendTo( "#images" );
	        if ( i === 3 ) {
	          return false;
	        }
	      });
	})();
	</script>	
	-->
</body>
</html>

