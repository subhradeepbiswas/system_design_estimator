<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script language="javascript">
			function submitServerDetails(){
				var servers = $("#servers").val();
				var avgcores = $("#cores").val();
			    var minReqstProcessingTime = $("#reqtime").val();
			    var clickFreq = $("#clickFreq").val();
			    
			    $.post('calcusersestimates', { servers : servers, avgcores : avgcores, minReqstProcessingTime : minReqstProcessingTime , clickFreq : clickFreq}, function(data) {
			        $('#userestimate').html(data);
			    } );
			}
			    
	</script>
	<div class = 'content'>
		<h3><u>Calculate # of Users that can be served simultaneously for below specifications</u></h3>
		# of Servers = <input id="servers" name="servers" type="number" min="1" value=50>  <br>
		Avg. Capacity of Servers = <input id="cores" name="cores" type="number" min="1" value=32> CPU cores <br> 
		Avg. Request Processing Time by 1 CPU core= <input id="reqtime" name="reqtime" type="number" min="0.1" value=0.323> Seconds <br>
		Click frequency = <input id="clickFreq" name="clickFreq" type="number" min="1" value=115> Seconds <br>
		<i>[Note: Click frequency formula = Average Session Duration / Avg. clicks per session <br>
		Average user on most of the websites clicks approximately once every 2 minutes (every 115 seconds). <br> 
		However, for E-commerce sites the rule of thumb is one click per minute (i.e. 45 seconds)] </i> <br>
		<br>
		<input class="button" type="submit" value="Calculate" onClick="submitServerDetails()"/>
	</div>
	
	<div id='userestimate' />
	
	
</body>
</html>