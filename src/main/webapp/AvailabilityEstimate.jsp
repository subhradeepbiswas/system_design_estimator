<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<div>
		<h3><u>Availability Estimates </u></h3>
		<P>  
			Availability Calculation formula = <br>
			${availability.calculationDetails} 
			<br>
			<br>
			Availability = ${availability.result}
			<br> 
			Yearly downtime = ${availability.outage}
			<br>
		</P>
	</div>

</body>
</html>