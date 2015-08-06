<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Diabetes Dashboard - Your Place to log and track your diabetic information">
<meta name="author" content="DTeam">
<meta name="keyword"
	content="Diabetes, Dashboard, Sugar, Glucose, Graph, Alc, Insulin, Diabetic">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<!--<link rel="shortcut icon" href="img/favicon.png">-->

<title>Diabetes Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<!-- bootstrap theme -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-theme.css" />" />
<!-- bootstrap icons -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.icon.large.min.css" />" />
<!--external css-->
<!-- font icon -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elegant-icons-style.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome.min.css"/> " />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
      <![endif]-->
</head>

<body>
	<!-- container section start -->
	<section id="container" class="">
		<header class="header">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips"
					data-original-title="Toggle Navigation" data-placement="bottom"></div>
			</div>

			<!--logo start-->
			<a href="#" class="logo">Diabetes <span class="lite">Dashboard</span></a>
			<!--logo end-->
			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <span class="profile-ava">
								<img src="${url}" alt="" />

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
		<!--header end-->

		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<div class="nav-header">
					<p>dashboard menu</p>
				</div>
				<ul class="sidebar-menu">
					<li class="active"><a class="" href="index.html"> <i
							class="icon_house_alt"></i> <span>Dashboard</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_calculator_alt"></i> <span>A1c Calculator</span> <!--  <span class="menu-arrow arrow_carrot-right"></span> -->
					</a></li>
				</ul>
				<!--sidebar menu end -->
			</div>
		</aside>
		<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/diabetic_dashboard_data" user="root"
			password="password" />
		<sql:query dataSource="${ds}" var="result">
			SELECT * FROM timeofday;
		</sql:query>
		
		<section id="main-content">
			<section class="wrapper">
				<div class="main-content-container">
					<div class="row">
						<div class="col-md-12">
							<h3 class="page-header">
								<i class="fa fa-laptop"></i> Dashboard
							</h3>
							<ol class="breadcrumb">
								<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
								<li><i class="fa fa-laptop"></i>Dashboard</li>
							</ol>
						</div>
						<div class="col-md-4">
							<section class="glucose-form">
								<div class="panel panel-default">
									<div class="panel-heading">
										Blood Glucose Reading (mg/dl)
									</div><!-- END .panel-heading -->
									<div class="panel-body">
										<form:form method="post" action="dashboard" role="login" id="glucoseEntryForm" commandName="readingForm">
										<div class="form-group">
												<form:input type="hidden" path="" />
												<label for="datepicker">Select Date</label>
												<form:input path="date" class="form-control" name="date" type="date"/>
										</div>
											<div class="row">
												<div class="form-group pull-left">
													<label for="bgreading">Blood Glucose Reading</label>
													<form:input path="bloodGlucose" type="text"
														name="bgreading" id="bgreading"
														placeholder="Please enter glucose reading"
														class="form-control input-lg" />
												</div>
												<div class="form-group pull-right">
													<!--  	<input type="hidden" name="action" value="add"> -->
													<label for="insulinUnits">Insulin Units</label>
													<form:input path="insulin" type="text" name="insulinUnits"
														id="insulinUnits"
														placeholder="Please enter amount of insulin in units"
														class="form-control input-lg" />
												</div>
											</div><!-- END .row for glucose reading and insulin units text input -->
											<div class="row">
												<div class="form-group">
													<label for="timeOfDay">Time of Day</label>
													<form:select path="timeOfDay" class="selector form-control"
														name="timeOfDay">
														<option>Select Time of Day</option>
														<c:forEach var="row" items="${result.rows}">
															<option value=<c:out value="${row.TimeOfDayID}"/>>
																<c:out value="${row.TimeOfDayString}" /></option>
														</c:forEach>
													</form:select>
												</div>
											</div><!-- END .rowfor select time of day -->
											<c:if test="${Msg != null}">
												<p>
													<i>${Msg} </i>
												</p>
											</c:if>
											<button type="submit" name="save_reading" value="save" class="btn btn-lg btn-info btn-block">Save Reading</button>
											<button type="reset" class="btn btn-lg btn-info btn-block">Reset Form</button>
										</form:form>
									</div><!--  END .panel-body -->
								</div>
							</section><!-- END Section .glucose-form -->
						</div><!-- END col for glucose form -->
						<div class="col-md-7">
							<form action="dashboard" method="get" role="select"
								id="TrendEntryForm">
								<div class="form-group">
									<label for="dateRange" style="color: #a5a5a5; font: 15px/1.6em Lato, serif;">Glucose Trend</label> 
									<select class="selector form-control" name="dateRange" onchange="this.form.submit()">
										<option>Select Trend</option>
										<option value="weekly">Weekly</option>
										<option value="monthly">Monthly</option>
									</select>
								</div>
							</form>
							<section class="glucose-chart">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h2>
											<i class="fa fa-icon-tint"></i><strong>Blood Glucose
												Chart</strong>
										</h2>
									</div>

									<div class="canvas-holder">
										<canvas id="chart" width="450" height="200"></canvas>
									</div>
									<div id="chartjs-tooltip"></div>

								</div>
							</section>
						</div>						
					</div><!-- END .row -->
				</div><!-- END .main-content-container -->
			</section><!-- END .wrapper -->
		</section><!-- END #main-content -->
	</section><!-- END #container -->


	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-ui-1.10.4.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.nicescroll.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.customSelect.min.js" />"></script>

	<!--custom script for all page-->
	<script type="text/javascript"
		src="<c:url value="/resources/js/scripts.js" />"></script>
	<!-- custom script for this page -->



	<script type="text/javascript"
		src="<c:url value="/resources/js/Chart.js" />"></script>

	<script>
		Chart.defaults.global.pointHitDetectionRadius = 1;
		Chart.defaults.global.customTooltips = function(tooltip) {
			var tooltipEl = $('#chartjs-tooltip');
			if (!tooltip) {
				tooltipEl.css({
					opacity : 0
				});
				return;
			}
			tooltipEl.removeClass('above below');
			tooltipEl.addClass(tooltip.yAlign);
			var innerHtml = '';
			for (var i = tooltip.labels.length - 1; i >= 0; i--) {
				innerHtml += [
						'<div class="chartjs-tooltip-section">',
						'   <span class="chartjs-tooltip-key" style="background-color:' + tooltip.legendColors[i].fill + '"></span>',
						'   <span class="chartjs-tooltip-value">'
								+ tooltip.labels[i] + '</span>', '</div>' ]
						.join('');
			}
			tooltipEl.html(innerHtml);
			tooltipEl.css({
				opacity : 1,
				left : tooltip.chart.canvas.offsetLeft + tooltip.x + 'px',
				top : tooltip.chart.canvas.offsetTop + tooltip.y + 'px',
				fontFamily : tooltip.fontFamily,
				fontSize : tooltip.fontSize,
				fontStyle : tooltip.fontStyle,
			});
		};
		var dates = ${dates};
		var bg = ${bloodGlucose};
		var insulin = ${insulin};
		var lineChartData = {
			labels : dates,
			datasets : [ {
				label : "My First dataset",
				fillColor : "rgba(220,220,220,0.2)",
				strokeColor : "rgba(220,220,220,1)",
				pointColor : "rgba(220,220,220,1)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(220,220,220,1)",
				data : bg
			}, {
				label : "My Second dataset",
				fillColor : "rgba(151,187,205,0.2)",
				strokeColor : "rgba(151,187,205,1)",
				pointColor : "rgba(151,187,205,1)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(151,187,205,1)",
				data : insulin
			} ]
		};
		var ctx2 = document.getElementById("chart").getContext("2d");
		window.myLine = new Chart(ctx2).Line(lineChartData, {
			responsive : true
		});
	</script>
	<script>
		function signOut() {

			document.cookie = "id"
					+ '=; Path=/DiabetesDashboard; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
			document.cookie = "user"
					+ '=; Path=/DiabetesDashboard; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
			document.cookie = "image"
					+ '=; Path=/DiabetesDashboard; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
			document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/DiabetesDashboard/login";
		};
	</script>

</body>
</html>
