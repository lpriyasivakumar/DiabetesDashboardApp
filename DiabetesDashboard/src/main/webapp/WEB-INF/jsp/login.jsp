<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Diabetes Dashboard Login Page">
    <meta name="author" content="DTeam">
    <meta name="keyword" content="Diabetes, Dashboard, Login, Glucose, Insulin">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="1008285497817-qjhgv7deojafc7ibfm4pb9psncmh29m0.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <!--<link rel="shortcut icon" href="../img/favicon.png">-->

    <title>Diabetes Dashboard Login Page</title>

    <!-- Bootstrap CSS -->    
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <!-- bootstrap theme -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.css" />" />
    <!--external css-->
    <!-- font icon -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/elegant-icons-style.css" />" />
  
    <!-- Custom styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style-responsive" />" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-img3-body">

    <div class="container">

        <!-- Login Form Servlet will collect data and send to dashboard page -->
      <form class="login-form" action="login" method="POST">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <p>Diabetes Dashboard</p>
           
            <button class="btn btn-primary btn-lg btn-block g-signin2 " type="submit" data-onsuccess="onSignIn">Google Login</button>
            <!-- <button class="btn btn-info btn-lg btn-block" type="submit">Signup</button> -->
        </div>
      </form>
<!--  data-theme="dark"   g-signin2  -->
    </div>

    <script src="https://apis.google.com/js/platform.js" async defer></script>
    
    <script>
   function setCookie(c_name,value,exdays){     
      var exdate=new Date();
      exdate.setDate(exdate.getDate() + exdays);
      var c_value=escape(value) + 
        ((exdays==null) ? "" : ("; expires="+exdate.toUTCString()));
      document.cookie=c_name + "=" + c_value;
    }
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
    
        var profile = googleUser.getBasicProfile();
        var getname = profile.getName();
        var getimageurl = profile.getImageUrl; 
        var getid = profile.getId();
        
        setCookie("user",getname,7);
        setCookie("image",getimageurl, 7);
        setCookie("id", getid, 7);
        
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    console.log("Name: " + profile.getName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());
    // The ID token you need to pass to your backend:
      
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
    //< input type="hidden" name= name />   
  };
  
  </script>
  <br>
  <div >
  <!--   <a href="#" onclick="signOut();"><img src="images/download.jpg" /></a>-->
  </div>
  <script>
      function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log('User signed out.');
    });
  }
</script>


  </body>
</html>
