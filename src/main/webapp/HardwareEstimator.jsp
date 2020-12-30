<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<SCRIPT language="javascript">
	
		function submitDetails(tableID){
	
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			
		    var frqncy = $("#frqncy").val();
		    var select1 = $("#select1").val();
		    var avglength1 = $("#avglength1").val();
		    var reqcnt1 = $("#reqcnt1").val();
		    var readRatio = $("#readRatio").val();
		    var writeRatio = $("#writeRatio").val();
		    if (rowCount == 3){
			    var select2 = $("#select2").val();
			    var avglength2 = $("#avglength2").val();
			    var reqcnt2 = $("#reqcnt2").val();
	
			    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1,
			    							select2 : select2, avglength2 : avglength2, reqcnt2 : reqcnt2, readRatio : readRatio, writeRatio : writeRatio}, function(data) {
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
			    							select3 : select3, avglength3 : avglength3, reqcnt3 : reqcnt3, readRatio : readRatio, writeRatio : writeRatio}, function(data) {
			        $('#results').html(data);   //.hide().slideDown('slow')
			    } );
			    return;
			}
		    
		    $.post('hardwareestimates', { frqncy : frqncy , select1 : select1, avglength1 : avglength1, reqcnt1 : reqcnt1, readRatio : readRatio, writeRatio : writeRatio}, function(data) {
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
			//element2.type = "number";
			element2.name="select"+rowCount;
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
			element3.value=100
			cell3.appendChild(element3);

			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "number";
			element4.name = "reqcnt"+rowCount;
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
<body style="margin-left:2.5em">
	<br>
	<!--  <form name="f1" method="post" action="hardwareestimates"> -->
    Frequency*  <select id="frqncy" name="frqncy">
          <option>Minute</option>
          <option>Hour</option>
          <option>Day</option>
          <option>Week</option>   
          <option>Month</option>
       </select> 
       <br>
       <h5> Write requests contains : &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; 
       
       <INPUT id=addbtn type="button" value="Add Row" onclick="addRow('contentTable')" />
		<INPUT id=dltbtn type="button" value="Delete Row" onclick="deleteRow('contentTable')" />  </h5>
       <TABLE id="contentTable" width="850px" border="0">
		<TR>
			<TD> Select row to delete </TD>
			<TD> Request content type </TD>
			<TD> Avg.size or length/request </TD>
			<TD> Request# / Frequency (above) </TD>
		</TR>
		<TR>
			<TD> <INPUT type="checkbox" name="chk"/> </TD>
			<TD><select id="select1" name="select1">
		            <option>Text (ASCII)</option>
		            <option>Text (UTF-8)</option>
		            <option>Image</option>
		            <option>Video</option>
	        	</select>
	        </TD>
			<TD> <input id="avglength1" name="avglength1" type="number" value=100> </TD>
			<TD> <input id="reqcnt1" name="reqcnt1" type="number" value=100> </TD>
		</TR>
	</TABLE>
    <br>
    "Read:Write" ratio for your system = <input id="readRatio" name="readRatio" type="number" value=99>:<input id="writeRatio" name="writeRatio" type="number" value=1> 
    <br>
    <br>
    <input type="submit" value="Calculate" onclick="submitDetails('contentTable')"/>
	<!--  </form> -->
	<br>
    <br>
	<div id="results" />
	
	
	
	<%-- To display selected value from dropdown list. --%>
    <% 
            String s=request.getParameter("frqncy");
            
    %>
</body>
</html>

