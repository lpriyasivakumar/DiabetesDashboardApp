<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="icon" type="image/ico"
	href="<c:url value="/resources/img/favicon.ico" />" />

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
								<img src="<c:url value="resources/img/user-icon.png" />" alt="Default User Image"/>

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
					<li class="active"><a class="" href="dashboard"> <i
							class="icon_house_alt"></i> <span>Dashboard</span>
					</a></li>
					<li class="sub-menu"><a href="recipe" class=""> <i
							class="icon_book"></i> <span>Healthy Recipes</span> <!--  <span class="menu-arrow arrow_carrot-right"></span> -->
					</a></li>
				</ul>
				<!--sidebar menu end -->
			</div>
		</aside>
		<section id="main-content">
			<section class="wrapper">
				<div class="main-content-container">
					<div class="row">
						<div class="col-md-12">
							<h3 class="page-header">
								<i class="fa fa-laptop"></i> Dashboard
							</h3>
							<ol class="breadcrumb">
								<li><i class="fa fa-home"></i><a href="dashboard">Home</a></li>
								<li><i class="fa fa-laptop"></i>Dashboard</li>
							</ol>
						</div>
						<div class="col-md-4">
							<section class="glucose-form">
								<div class="panel panel-default">
									<div class="panel-heading">Blood Glucose Reading (mg/dl)
									</div>
									<!-- END .panel-heading -->
									<div class="panel-body">
										<form:form method="post" action="dashboard" role="login"
											id="glucoseEntryForm" commandName="readingForm">
											<div class="form-group">
												<form:input type="hidden" path="" />
												<label for="datepicker">Select Date</label>
												<form:input path="date" class="form-control" name="date"
													type="date" />
											</div>
											<div class="row">
												<div class="form-group pull-left">
													<label for="bgreading">Blood Glucose Reading</label>
													<form:input path="bloodGlucose" type="number"
														name="bgreading" id="bgreading"
														placeholder="Please enter glucose reading"
														class="form-control input-lg" />
												</div>
												<div class="form-group pull-right">
													<!--  	<input type="hidden" name="action" value="add"> -->
													<label for="insulinUnits">Insulin Units</label>
													<form:input path="insulin" type="number" name="insulinUnits"
														id="insulinUnits"
														placeholder="Please enter amount of insulin in units"
														class="form-control input-lg" />
												</div>
											</div>
											<!-- END .row for glucose reading and insulin units text input -->
											<div class="row">
												<div class="form-group">
													<label for="timeOfDay">Time of Day</label>
													<form:select path="timeOfDay" class="selector form-control"
														name="timeOfDay">
														<option>Select Time of Day</option>														
														<option value="1">Before Breakfast</option>
														<option value="2">After Breakfast</option>
														<option value="3">Before Lunch</option>
														<option value="4">After Lunch</option>
														<option value="5">Before Dinner</option>
														<option value="6">After Dinner</option>
														<option value="7">Bedtime</option>												
													</form:select>
												</div>
											</div>											
											<c:if test="${Msg != null}">
												<p>
													<i>${Msg} </i>
												</p>
											</c:if>
											<button type="submit" name="save_reading" value="save"
												class="btn btn-lg btn-info btn-block">Save Reading</button>
											<button type="reset" class="btn btn-lg btn-info btn-block">Reset
												Form</button>
										</form:form>
									</div>
									<!--  END .panel-body -->
								</div>
							</section>
							<!-- END Section .glucose-form -->
						</div>
						<!-- END col for glucose form -->
						<div class="col-md-7">
							<form action="dashboard" method="get" role="select"
								id="TrendEntryForm">
								<div class="form-group">
									<label for="dateRange"
										style="color: #a5a5a5; font: 15px/1.6em Lato, serif;">Glucose
										Trend</label> <select class="selector form-control" name="dateRange"
										onchange="this.form.submit()">
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
					</div>
					<!-- END .row for glucose and insulin form and glucose and insulin chart -->

					<div class="row">
						<div class="col-md-4">
							<section class="a1c-form">
								<div class="panel panel-default">
									<div class="panel-heading">A1c Calculator</div>
									<div class="panel-body">
										<form method="post" action="A1c" role="entry"
											id="a1cEntryform">
											<input type="hidden" name="action" value="saveLabValue">
											<div class="form-group">
												<label for="labA1c">Lab A1c Value: ${labA1c} </label> 
												<input type="text" name="LabA1c" id="labA1c" class="form-control input"
													maxlength="4" value="" />
												<div class="form-group col-lg-offset-2 col-lg-9">
													<button  type="submit" class="btn btn-info btn-block">Save Lab Value</button>
												</div>
												<c:if test="${errMsg != null}">
												<p>
													<i>${errMsg} </i>
												</p>
											</c:if>
											</div>
											</form>
											<form method="get" action="A1c" role="entry"
											id="a1cEntryform">
											<input type="hidden" name="action" value="CalcA1c">
											<div class="form-group">												
												<label for="estimatedA1c">Estimated A1c Value<span>*: ${calcA1c}</span></label>												
												<div class="form-group col-lg-offset-2 col-lg-9">
													<button  type="submit" class="btn btn-info btn-block">Calculate Estimated A1c</button>												
												</div>
											</div>
										</form>
									</div>
								</div>
							</section><!-- END section for A1c Calculator -->
						</div>
													<section>
								<div class="table-responsive">
							<table class="col-md-6 table-bordered">
								<thead>
									<tr>
										<th colspan="11" class="chart_heading"><span>A1c
												to Blood Sugar Conversion Table</span><span>(1n mg/dl and
												mmol/l)</span></th>
									</tr>
								</thead>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="darkGreen">4.0</td>
									<td class="darkGreen">4.1</td>
									<td class="darkGreen">4.2</td>
									<td class="darkGreen">4.3</td>
									<td class="darkGreen">4.4</td>
									<td class="darkGreen">4.5</td>
									<td class="darkGreen">4.6</td>
									<td class="lightGreen">4.7</td>
									<td class="lightGreen">4.8</td>
									<td class="lightGreen">4.9</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="darkGreen">65</td>
									<td class="darkGreen">69</td>
									<td class="darkGreen">72</td>
									<td class="darkGreen">76</td>
									<td class="darkGreen">79</td>
									<td class="darkGreen">83</td>
									<td class="darkGreen">86</td>
									<td class="lightGreen">90</td>
									<td class="lightGreen">93</td>
									<td class="lightGreen">97</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="lightGreen">5.0</td>
									<td class="lightGreen">5.1</td>
									<td class="oliveGreen">5.2</td>
									<td class="oliveGreen">5.3</td>
									<td class="oliveGreen">5.4</td>
									<td class="oliveGreen">5.5</td>
									<td class="oliveGreen">5.6</td>
									<td class="lightOrange">5.7</td>
									<td class="lightOrange">5.8</td>
									<td class="lightOrange">5.9</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="lightGreen">101</td>
									<td class="lightGreen">104</td>
									<td class="oliveGreen">108</td>
									<td class="oliveGreen">111</td>
									<td class="oliveGreen">115</td>
									<td class="oliveGreen">118</td>
									<td class="oliveGreen">122</td>
									<td class="lightOrange">126</td>
									<td class="lightOrange">129</td>
									<td class="lightOrange">133</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="lightOrange">6.0</td>
									<td class="lightOrange">6.1</td>
									<td class="lightOrange">6.2</td>
									<td class="lightOrange">6.3</td>
									<td class="lightOrange">6.4</td>
									<td class="burntOrange">6.5</td>
									<td class="burntOrange">6.6</td>
									<td class="burntOrange">6.7</td>
									<td class="burntOrange">6.8</td>
									<td class="burntOrange">6.9</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="lightOrange">136</td>
									<td class="lightOrange">140</td>
									<td class="lightOrange">143</td>
									<td class="lightOrange">147</td>
									<td class="lightOrange">151</td>
									<td class="burntOrange">154</td>
									<td class="burntOrange">158</td>
									<td class="burntOrange">161</td>
									<td class="burntOrange">165</td>
									<td class="burntOrange">168</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="burntOrange">7.0</td>
									<td class="lightRed">7.1</td>
									<td class="lightRed">7.2</td>
									<td class="lightRed">7.3</td>
									<td class="lightRed">7.4</td>
									<td class="lightRed">7.5</td>
									<td class="lightRed">7.6</td>
									<td class="lightRed">7.7</td>
									<td class="lightRed">7.8</td>
									<td class="lightRed">7.9</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="burntOrange">172</td>
									<td class="lightRed">176</td>
									<td class="lightRed">180</td>
									<td class="lightRed">183</td>
									<td class="lightRed">186</td>
									<td class="lightRed">190</td>
									<td class="lightRed">193</td>
									<td class="lightRed">197</td>
									<td class="lightRed">200</td>
									<td class="lightRed">204</td>
								</tr>
								<tr>
									<td class="chart_label">mmol/l</td>
									<td class="burntOrange">9.6</td>
									<td class="lightRed">9.8</td>
									<td class="lightRed">10.0</td>
									<td class="lightRed">10.2</td>
									<td class="lightRed">10.4</td>
									<td class="lightRed">10.6</td>
									<td class="lightRed">10.8</td>
									<td class="lightRed">11.0</td>
									<td class="lightRed">11.2</td>
									<td class="lightRed">11.4</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="lightRed">8.0</td>
									<td class="bloodRed">8.1</td>
									<td class="bloodRed">8.2</td>
									<td class="bloodRed">8.3</td>
									<td class="bloodRed">8.4</td>
									<td class="bloodRed">8.5</td>
									<td class="bloodRed">8.6</td>
									<td class="bloodRed">8.7</td>
									<td class="bloodRed">8.8</td>
									<td class="bloodRed">8.9</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="lightRed">207</td>
									<td class="bloodRed">211</td>
									<td class="bloodRed">215</td>
									<td class="bloodRed">218</td>
									<td class="bloodRed">222</td>
									<td class="bloodRed">225</td>
									<td class="bloodRed">229</td>
									<td class="bloodRed">232</td>
									<td class="bloodRed">236</td>
									<td class="bloodRed">240</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td class="chart_label">Hb-A1c</td>
									<td class="bloodRed">9.0</td>
									<td class="bloodRed">9.5</td>
									<td class="bloodRed">10.0</td>
									<td class="bloodRed">10.5</td>
									<td class="bloodRed">11.0</td>
									<td class="bloodRed">11.5</td>
									<td class="bloodRed">12.0</td>
									<td class="bloodRed">12.5</td>
									<td class="bloodRed">13.0</td>
									<td class="bloodRed">13.5</td>
								</tr>
								<tr>
									<td class="chart_label">mg/dl</td>
									<td class="bloodRed">243</td>
									<td class="bloodRed">261</td>
									<td class="bloodRed">279</td>
									<td class="bloodRed">297</td>
									<td class="bloodRed">314</td>
									<td class="bloodRed">332</td>
									<td class="bloodRed">350</td>
									<td class="bloodRed">368</td>
									<td class="bloodRed">386</td>
									<td class="bloodRed">403</td>
								</tr>
								<tr>
									<td colspan="11"></td>

								</tr>
								<tr>
									<td colspan="4" class="darkGreen">Optimal</td>
									<td colspan="4" class="lightGreen">Sub-optimal</td>
									<td colspan="3" class="oliveGreen">Normal</td>
								</tr>
								<tr>
									<td colspan="4" class="lightOrange">Pre-diabetes</td>
									<td colspan="4" class="burntOrange">Diabetes</td>
									<td colspan="3" class="lightRed">Harmful</td>
								</tr>
								<tr>
									<td colspan="11" class="bloodRed">Dangerous</td>

								</tr>
							</table>
						</div>
							</section><!-- END section for A1c to Glucose Table  -->
					</div>
					<!-- END .row for a1c calculator and a1c table -->
				</div>
				<!-- END .main-content-container -->
			</section>
			<!-- END .wrapper -->
		</section>
		<!-- END #main-content -->
	</section>
	<!-- END #container -->


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
			document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://diabetesdashboard-dteamdash.rhcloud.com/DiabetesDashboard-1.0-SNAPSHOT/login";
		};
	</script>

</body>
</html>
