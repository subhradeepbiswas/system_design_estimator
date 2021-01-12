<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<head>
<link href="https://fonts.googleapis.com/css?family=Inconsolata|Montserrat&display=swap" rel="stylesheet">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

<title>Performance Estimator</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"  href="/landing.css">
<link rel="shortcut icon" type="image/x-icon" href="PairDesignlogo.png" />
	
	<SCRIPT language="javascript">
		$(function(){
		   $('form').on('submit',function(){
		   event.preventDefault();
		       var value=$("input[name=performancetype]:checked").val();
		       if (value == null){
			       return;
			   }
		       var targetpage = ""
			   switch(value){
			     case "server":  targetpage = 'ServerEstimator.jsp'; break;
				 case "user":  targetpage='UserEstimator.jsp'; break;
			   }
		       $('#targetpage').load(targetpage); 
		   });
		});
	</SCRIPT>

</head>
<body>
	<header>
	    <h1><u>Maintaining performance</u></h1>
	    <!-- <span class="menu"><i class="material-icons" style="font-size: 48px;">menu</i></span>  -->
	</header>
	<div class = 'content'>
		<form >
		    <input type="radio" name="performancetype" value="server"> Estimate the number of servers you need to guarantee performance
		    <br>
		    <input type="radio" name="performancetype" value="user"> Estimate the number of simultaneous visitors you can serve with specific infrastructure
		    <br>
		    <br>
		    <input class="button1" type="submit" value="Submit">
		</form>
		<br>
		For better understanding on this topic, refer to : <a href="https://servebolt.com/articles/calculate-how-many-simultaneous-website-visitors/"> Article by Erlend Eide, CEO of Servebolt </a>
		<br>
		<br>
		<div id="targetpage" > </div>
		
	</div>
	
	
	<footer>
	<center> Copyright &#169; 2021 Subhradeep Biswas </center>
	</footer>
</body>
</html>