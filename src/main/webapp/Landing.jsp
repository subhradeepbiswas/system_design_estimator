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
<link rel="shortcut icon" type="image/x-icon" href="PairDesignlogo.png" />
</head>
<body>
	<header>
	    <h1><u>Welcome to System Design Estimator </u> </h1>
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
	    <h3>This service estimates <br>
	    (1) the number of servers you would need to guarantee performance while serving any number of QPS (Read requests) <br>
	    (2) the number of simultaneous visitors you can serve with a guaranteed performance with your current infrastructure (no. of servers)</h3>
	    <input class="button" type="button" value="Ensure Performance" name="EnsurePerformance"
	     onclick="openPage('EnsurePerformance.jsp')" />
		</p>
	    <br>
	    <p>	
	    <h3>This service estimates the overall availability of a system based on its service specifications</h3>
	    <input class="button" type="button" value="Estimate Availability" name="EnsureAvailability"
	     onclick="openPage('EstimateAvailability.jsp')" />
		</p>
	</form>
	</div>
	
	<footer>
	<center> Copyright &#169; 2021 Subhradeep Biswas </center>
	</footer>
	
	<script type="text/javascript">
	 function openPage(pageURL)
	 {
	 window.location.href = pageURL;
	 }
	</script>

</body>
</html>