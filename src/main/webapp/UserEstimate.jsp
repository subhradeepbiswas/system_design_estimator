<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<div >
		<h3><u>User estimates </u></h3>
		<P>  ${user.formula} 
			 <br>
			 Infrastructure's processing capacity per second = ${user.totalProcessCapacityPerSec}
			 <br>
			 Max. simultaneous users = ${user.totalSimultaneousUserCount}
			 <br>
		</P>
	</div>
	
</body>
</html>