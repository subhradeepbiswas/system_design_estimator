<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inconsolata|Montserrat&display=swap" rel="stylesheet">
	<meta content="width=device-width, initial-scale=1" name="viewport" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

	<title>Availability Estimator</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"  href="/landing.css">
	
	<SCRIPT language="javascript">

		function submitDetails(tableID) {
			try{
			
				var table = document.getElementById(tableID);
				var rowCount = table.rows.length;
			    /*var myObjects = [];
			    //window.alert(table.rows[1].cells[1].firstChild.value);
			    for(var i=1; i<rowCount; i++) {
			    	var row = table.rows[i];
			    	//window.alert(row.cells[1].firstChild.value);
			    	//window.alert(row.cells[2].firstChild.value);
			    	//window.alert(row.cells[3].firstChild.value);
			    	myObjects.push({
			    		serviceName:row.cells[1].firstChild.value,
			    		avgAvailability:row.cells[2].firstChild.value,
			    		instanceCount:row.cells[3].firstChild.value
			        });
				}*/
				
				
				var obj = {};
				for(var i=1; i<rowCount; i++) {
			    	var row = table.rows[i];
			    	var innerobj = {};
			    	innerobj["serviceName"] = row.cells[1].firstChild.value;
			    	innerobj["avgAvailability"] = row.cells[2].firstChild.value;
			    	innerobj["instanceCount"] = row.cells[3].firstChild.value;
			    	obj[i-1] = innerobj;
				}
				/*myObjects.forEach(function(value, idx) {
					
				  obj[idx] = value
				});*/

			}catch(e) {
				alert(e);
			}
			
			var count = Object.keys(obj).length;
			console.log(count);

			jQuery.ajax ({
			    url: "/availability",
			    type: "POST",
			    data: JSON.stringify(obj).replace("%", ""),
			    dataType: "html",
			    contentType : "application/json;  charset=utf-8",
			    success: function(data){
			    	$('#availabilityestimate').html(data);
			    }
			});			
		}
		
		function addRow(tableID) {

			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			var row = table.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "checkbox";
			element1.name="chkbox[]";
			cell1.appendChild(element1);
			
			var cell2 = row.insertCell(1);
			var element2 = document.createElement("input");
			element2.type = "text";
			element2.id = "partName";
			element2.name="partName";
			element2.value="Service-"+rowCount;
			//window.alert(element2.name);
			cell2.appendChild(element2);

			var cell3 = row.insertCell(2);
			var element3 = document.createElement("input");
			element3.type = "number";
			element3.name = "availPerc";
			element3.id = "availPerc";
			element3.step=".01";
			element3.value=99
			cell3.appendChild(element3);
			var itemLabel = document.createElement("Label");
			itemLabel.id = "unit"+rowCount;
		    itemLabel.setAttribute("for", element3);
		    itemLabel.innerHTML = " %";
		    cell3.appendChild(itemLabel);
		  	
			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "number";
			element4.name = "insCnt";
			element4.id = "insCnt";
			//window.alert(element4.name);
			element4.value=1
			cell4.appendChild(element4);

		}

		function deleteRow(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			if (rowCount < 3){
				window.alert("This row cannot be deleted \nCause: Input specification needs at least 1 row");
				return;
			}
			
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}

			}
			}catch(e) {
				alert(e);
			}
		}

	</SCRIPT>
</head>
<body>
	<header>
	    <h1><u>Calculate System Availability</u></h1>
	    <!-- <span class="menu"><i class="material-icons" style="font-size: 48px;">menu</i></span>  -->
	</header>
  	<div class='content'>
  	<h3> Provide the high-level architecture of your system below:</h3>
  	<br>
  	<INPUT class="button1" id=addbtn type="button" value="Add Row" onclick="addRow('compTable')" />
	<INPUT class="button1" id=dltbtn type="button" value="Delete Row" onclick="deleteRow('compTable')" />
  	<TABLE id="compTable" width="950px" border="0">
		<TR>
			<TD> Select row to delete </TD>
			<TD> Service name </TD>
			<TD> Avg. instance availability </TD>
			<TD> # of instances running in parallel </TD>
		</TR>
		<TR>
			<!-- <TD> <INPUT type="checkbox" name="chk"/> </TD> -->
			<TD></TD>
			<TD><input id="partName" name="partName" type="text" value="Service-1"></TD>
			<TD><input id="availPerc" name="availPerc" type="number" min="1" max="100" value="99" step=".01"><label id="unit1" for="availPerc"> %</label></TD>
			<TD><input id="insCnt" name="insCnt" type="number" min="1" value="1"> </TD>
		</TR>
		
	</TABLE>
    <br>
  	<input class="button" type="submit" value="Calculate" onclick="submitDetails('compTable')"/>

  	<br>
	For better understanding on this topic, refer to : <a href="https://www.eventhelix.com/RealtimeMantra/FaultHandling/system_reliability_availability.htm"> System Reliability and Availability </a>
	<br>
	
	<div id='availabilityestimate' > </div> 
  	</div>
  	
  	<footer>
	Copyright details
	</footer>
	
	<!--
	<script>
		var table = document.getElementById("compTable");
		var row = table.rows[1];
	
		var cell = row.Cells(2);
		var txtElement = document.getElementById("partName");
		var itemLabel = document.createElement("Label");
		itemLabel.id = "unit1";
	    itemLabel.setAttribute("for", txtElement);
	    itemLabel.innerHTML = " %";
	    cell.appendChild(itemLabel);
	</script>
	-->
	
</body>
</html>