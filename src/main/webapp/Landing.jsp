<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>System Design Estimator</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body style="background-color:lightblue;">
	<form name="landing" action="landing" method="get">
		<p>	
	    <h3>This service estimates on traffic, bandwidth, storage and memory requirement for your system </h3>
	    <input type="button" value="Hardware Estimates" name="HardwareEstimates"
	     onclick="openPage('HardwareEstimator.jsp')"/>
	    </p>
	    <br>
	    <p>	
	    <h3>This service estimates the number of instances for every service to meet the system's availability requirement </h3>
	    <input type="button" value="Ensure Availability" name="EnsureAvailability"
	     onclick="openPage('EnsureAvailability.jsp')" />
		</p>
	</form>
	<script type="text/javascript">
	 function openPage(pageURL)
	 {
	 window.location.href = pageURL;
	 }
	</script>

</body>
</html>