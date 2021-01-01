<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Inconsolata|Montserrat&display=swap" rel="stylesheet">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

<title>System Design Estimator</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"  href="/landing.css">

</head>
<body>
	<header>
	    <h1><u>Welcome to System Design Estimator</u></h1>
	    <!-- <span class="menu"><i class="material-icons" style="font-size: 48px;">menu</i></span>  -->
	</header>
	<div class='content'>
	<form name="landing" action="landing" method="get">
		<p>	
	    <h3>This service estimates on traffic, bandwidth, storage and memory requirement for your system </h3>
	    <input class="button" type="button" value="Hardware Estimates" name="HardwareEstimates"
	     onclick="openPage('HardwareEstimator.jsp')"/>
	    </p>
	    <br>
	    <p>	
	    <h3>This service estimates the number of instances for every service to meet the system's availability requirement </h3>
	    <input class="button" type="button" value="Ensure Availability" name="EnsureAvailability"
	     onclick="openPage('EnsureAvailability.jsp')" />
		</p>
	</form>
	</div>
	<footer>
	Copyright details
	</footer>
	<script type="text/javascript">
	 function openPage(pageURL)
	 {
	 window.location.href = pageURL;
	 }
	</script>

</body>
</html>