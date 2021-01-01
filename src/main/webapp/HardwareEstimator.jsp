<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inconsolata|Montserrat&display=swap" rel="stylesheet">
	<meta content="width=device-width, initial-scale=1" name="viewport" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

	<title>Hardware Estimator</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"  href="/landing.css">
	
	<SCRIPT language="javascript">

		function updateText(selectId){
			//window.alert("I am in");
			var lastChar = selectId.substr(selectId.length - 1);
			var elemId = 'avglength'+lastChar;
			var labelId = 'unit'+lastChar;

			//window.alert(elemId);
			
			if (document.getElementById(selectId).value == "Video"){
				//window.alert(document.getElementById(elemId).value);
				document.getElementById(elemId).value = 1;
				document.getElementById(labelId).innerHTML = "Minute";
			} 
			if (document.getElementById(selectId).value == "Image"){
				document.getElementById(elemId).value = 200;
				document.getElementById(labelId).innerHTML = "KB";
			}
			if (document.getElementById(selectId).value == "Text (UTF-8)"){
				document.getElementById(elemId).value = 100;
				document.getElementById(labelId).innerHTML = "Chars";
			}
			if (document.getElementById(selectId).value == "Text (ASCII)"){
				document.getElementById(elemId).value = 100;
				document.getElementById(labelId).innerHTML = "Chars";
			}
		}
	
		function submitDetails(tableID){
	
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			
		    var frqncy = $("#frqncy").val();
		    var select1 = $("#select1").val();
		    var avglength1 = $("#avglength1").val();
		    var reqcnt1 = $("#reqcnt1").val();
		    var readRatio = $("#readRatio").val();
		    var writeRatio = $("#writeRatio").val();
		    var cachePercent = $("#cachePercent").val();

		    if (cachePercent > 100 || cachePercent < 0){
		    	//rangeError = "0 >= valid input <= 100";
		    	window.alert("Cache Percent range error \n0 >= valid input <= 100");
		        //document.getElementById("range_error").innerHTML = rangeError;
		        return;
			}
		    
		    if (rowCount == 3){
			    var select2 = $("#select2").val();
			    var avglength2 = $("#avglength2").val();
			    var reqcnt2 = $("#reqcnt2").val();
			    
			    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1,
			    							select2 : select2, avglength2 : avglength2, reqcnt2 : reqcnt2, readRatio : readRatio, writeRatio : writeRatio, cachePercent : cachePercent}, function(data) {
			        $('#results').html(data);   //.hide().slideDown('slow')
			    } );
			    return;
			}
		    if (rowCount == 4){
			    var select2 = $("#select2").val();
			    var avglength2 = $("#avglength2").val();
			    var reqcnt2 = $("#reqcnt2").val();
			    var select3 = $("#select3").val();
			    var avglength3 = $("#avglength3").val();
			    var reqcnt3 = $("#reqcnt3").val();
	
			    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1,
			    							select2 : select2, avglength2 : avglength2, reqcnt2 : reqcnt2,
			    							select3 : select3, avglength3 : avglength3, reqcnt3 : reqcnt3, readRatio : readRatio, writeRatio : writeRatio, cachePercent : cachePercent}, function(data) {
			        $('#results').html(data);   //.hide().slideDown('slow')
			    } );
			    return;
			}

		    if (rowCount == 5){
			    var select2 = $("#select2").val();
			    var avglength2 = $("#avglength2").val();
			    var reqcnt2 = $("#reqcnt2").val();
			    var select3 = $("#select3").val();
			    var avglength3 = $("#avglength3").val();
			    var reqcnt3 = $("#reqcnt3").val();
			    var select4 = $("#select4").val();
			    var avglength4 = $("#avglength4").val();
			    var reqcnt4 = $("#reqcnt4").val();
	
			    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1,
			    							select2 : select2, avglength2 : avglength2, reqcnt2 : reqcnt2,
			    							select3 : select3, avglength3 : avglength3, reqcnt3 : reqcnt3,
			    							select4 : select4, avglength4 : avglength4, reqcnt4 : reqcnt4, readRatio : readRatio, writeRatio : writeRatio, cachePercent : cachePercent}, function(data) {
			        $('#results').html(data);   //.hide().slideDown('slow')
			    } );
			    return;
			}
		    
		    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1, readRatio : readRatio, writeRatio : writeRatio, cachePercent : cachePercent}, function(data) {
		        $('#results').html(data);   //.hide().slideDown('slow')
		    } );
		    
		}


		function addRow(tableID) {

			var table = document.getElementById(tableID);

			var rowCount = table.rows.length;

			if (rowCount == 5){
				window.alert("New row not required \nCause: All available content types are used already");
				return;
			}
			
			var row = table.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "checkbox";
			element1.name="chkbox[]";
			cell1.appendChild(element1);
			
			var cell2 = row.insertCell(1);
			var element2 = document.createElement("select");
			element2.id = "select"+rowCount;
			element2.name="select"+rowCount;
			element2.onchange=function(){updateText(element2.id);};
			//window.alert(element2.name);
			cell2.appendChild(element2);

			var z = document.createElement("option");
			z.text= "Text (ASCII)";
			element2.options.add(z);
			var z = document.createElement("option");
			z.text= "Text (UTF-8)";
			element2.options.add(z);
			var z = document.createElement("option");
			z.text= "Image";
			element2.options.add(z);
			var z = document.createElement("option");
			z.text= "Video";
			element2.options.add(z);

			var cell3 = row.insertCell(2);
			var element3 = document.createElement("input");
			element3.type = "number";
			element3.name = "avglength"+rowCount;
			element3.id = "avglength"+rowCount;
			element3.value=100
			cell3.appendChild(element3);
			var itemLabel = document.createElement("Label");
			itemLabel.id = "unit"+rowCount;
		    itemLabel.setAttribute("for", element3);
		    itemLabel.innerHTML = "Chars";
		    cell3.appendChild(itemLabel);
		  	
			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "number";
			element4.name = "reqcnt"+rowCount;
			element4.id = "reqcnt"+rowCount;
			//window.alert(element4.name);
			element4.value=100
			cell4.appendChild(element4);

			/*if (table.rows.length == 5){
				var btnAdd = document.getElementById("addbtn");
				btnAdd.disabled = true;
			} 
			if (table.rows.length > 2){
				var btnDlt = document.getElementById("dltbtn");
				btnDlt.disabled = false;
			}*/

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
	    <h1><u>Fillup the details of the 'Write' requests below</u></h1>
	    <!-- <span class="menu"><i class="material-icons" style="font-size: 48px;">menu</i></span>  -->
	</header>
	<div class='content'>
	<!--  <form name="f1" method="post" action="hardwareestimates"> -->
    Frequency*  <select id="frqncy" name="frqncy">
          <option>Minute</option>
          <option>Hour</option>
          <option>Day</option>
          <option>Week</option>   
          <option>Month</option>
       </select> 
       <br>
       <h3> Write requests contains : </h3> 
       
       <INPUT class="button1" id=addbtn type="button" value="Add Row" onclick="addRow('contentTable')" />
		<INPUT class="button1" id=dltbtn type="button" value="Delete Row" onclick="deleteRow('contentTable')" /> 
       <TABLE id="contentTable" width="950px" border="0">
		<TR>
			<TD> Select row to delete </TD>
			<TD> Request content type </TD>
			<TD> Avg.size or length/request </TD>
			<TD> Request# / Frequency (above) </TD>
		</TR>
		<TR>
			<!-- <TD> <INPUT type="checkbox" name="chk"/> </TD> -->
			<TD><select id="select1" name="select1" onchange="updateText('select1')">
		            <option>Text (ASCII)</option>
		            <option>Text (UTF-8)</option>
		            <option>Image</option>
		            <option>Video</option>
	        	</select>
	        </TD>
			<TD> <input id="avglength1" name="avglength1" type="number" value=100><label id="unit1" for="avglength1">Chars</label></TD>
			<TD> <input id="reqcnt1" name="reqcnt1" type="number" value=100> </TD>
		</TR>
	</TABLE>
    <br>
    "Read:Write" ratio for your system = <input id="readRatio" name="readRatio" type="number" value=99> <b>:</b> <input id="writeRatio" name="writeRatio" type="number" value=1> 
    <br>
    Cache Requirement: <input id="cachePercent" name="cachePercent" type="number" min="0" max="100" value=20> % of the total read requests to be cached
    <div class="error"><p id="range_error"></p></div>
    <br>
    <br>
    <input class="button" type="submit" value="Calculate" onclick="submitDetails('contentTable')"/>
	<!--  </form> -->
	<br>
	</div>
    
    <div id="results" />
	
	
	<footer>
	Copyright details
	</footer>
	
	<%-- To display selected value from dropdown list. --%>
    <% 
            String s=request.getParameter("frqncy");
            
    %>
</body>
</html>

