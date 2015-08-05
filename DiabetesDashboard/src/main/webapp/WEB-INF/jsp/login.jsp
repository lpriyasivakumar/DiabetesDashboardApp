<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Diabetes Dashboard Login Page">
<meta name="author" content="DTeam">
<meta name="keyword"
	content="Diabetes, Dashboard, Login, Glucose, Insulin">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="1008285497817-qjhgv7deojafc7ibfm4pb9psncmh29m0.apps.googleusercontent.com">


<script src="https://apis.google.com/js/platform.js" async defer></script>
<!--<link rel="shortcut icon" href="../img/favicon.png">-->

<title>Diabetes Dashboard Login Page</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<!-- bootstrap theme -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-theme.css" />" />
<!--external css-->
<!-- font icon -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elegant-icons-style.css" />" />

<!-- Custom styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style-responsive" />" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
	
</script>
<script src="https://apis.google.com/js/client:platform.js?onload=start"
	async defer>
	
</script>

</head>

<body class="login-img3-body">

	<div class="container">

		<!-- Login Form Servlet will collect data and send to dashboard page -->
		<form class="login-form" action="login" method="post">
			<div class="login-wrap">
				<p class="login-img">
					<i class="icon_lock_alt"></i>
				</p>
				<p>Diabetes Dashboard</p>
				<!-- <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input type="text" class="form-control" placeholder="Username" autofocus>
            </div> -->
				<!--<div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="Password">
            </div> -->
				<!-- <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right"> <a href="#"> Forgot Password?</a></span>
            </label>  -->

				<div class="g-signin2" data-onsuccess="onSignIn"></div>
					
			</div>
		</form>
	</div>

	<script type="text/javascript">
		function setCookie(c_name, value, exdays) {
			var exdate = new Date();
			exdate.setDate(exdate.getDate() + exdays);
			var c_value = escape(value)
					+ ((exdays == null) ? "" : ("; expires=" + exdate
							.toUTCString()));
			document.cookie = c_name + "=" + c_value;
		}
		
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			var getname = profile.getName();
			var getimageurl = profile.getImageUrl;
			var getid = profile.getId();
			var id_token = googleUser.getAuthResponse().id_token;
			setCookie("user", getname, 7,{path:'/'});
			setCookie("image", getimageurl, 7,{path:'/'});
			setCookie("id", getid, 7,{path:'/'});
			console.log("ID Token: " + id_token); // The ID token you need to pass to your backend:
			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
			console.log("Name: " + profile.getName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());
			
			//Make ajax call to google to authenticate the id_token 
			var xhr = new XMLHttpRequest();			
			xhr.onload = function() {
			  console.log('Signed in as: ' + xhr.responseText);
			};
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					post("http://localhost:8080/DiabetesDashboard4.0/login","post");
				}
			}
			xhr.open('POST', 'https://www.googleapis.com/oauth2/v3/tokeninfo?id_token='+id_token);
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhr.send();	

		};
		function post(path, method) {
		    method = method || "post"; // Set method to post by default if not specified.

		    // The rest of this code assumes you are not using a library.
		    // It can be made less wordy if you use one.
		    var form = document.createElement("form");
		    form.setAttribute("method", method);
		    form.setAttribute("action", path);		    
		    document.body.appendChild(form);
		    form.submit();
		}
		</script>
		
	
</body>

</html>

