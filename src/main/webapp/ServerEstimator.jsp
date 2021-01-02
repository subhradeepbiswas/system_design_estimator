<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<body>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script language="javascript">
			function submitLoadDetails(){
			    var reqProcessingTime = $("#reqtime").val();
			    var qps = $("#qps").val();
			    var qpsPerc = $("#qpsPerc").val();
			    var cores = $("#cores").val();
			    var replicationFactor = $("#repfactor").val();
			    
			    $.post('calcserverestimates', { reqProcessingTime : reqProcessingTime , qps : qps, qpsPerc : qpsPerc, cores : cores, replicationFactor : replicationFactor}, function(data) {
			        $('#serverestimate').html(data);
			    } );
			}
			    
	</script>
	<div class = 'content'>
		<h3><u>Calculate # of Servers required to best serve your visitors</u></h3>

		Every request to the website on average uses (Avg. Processing Time) <input id="reqtime" name="reqtime" type="number" min="0" value=0.323> seconds of CPU time <br>
		<i>(i.e. the Avg. Processing Time of 1 CPU core)</i> <br>
		Query Per Second (QPS): <input id="qps" name="qps" type="number" min="0" value=5000> <br> 
		Guarantee the Avg. Processing Time for <input id="qpsPerc" name="qpsPerc" type="number" min="0" max="100" value=95> % of the total QPS <br>
		Capacity of each server is <input id="cores" name="cores" type="number" min="1" value=32> CPU cores <br>
		Replication factor (To ensure service durability): <input id="repfactor" name="repfactor" type="number" min="0" value=3><br>
		<br>
		<input class="button" type="submit" value="Calculate" onClick="submitLoadDetails()"/>
	</div>
	
	<div id='serverestimate' />
	
	
</body>
</html>