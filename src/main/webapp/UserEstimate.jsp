<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<div class = 'content'>
		<h3><u>User estimates </u></h3>
		<P>  ${user.formula} 
			 <br>
			 Infrastructure's processing capacity per second = ${user.totalProcessCapacityPerSec}
			 <br>
			 Max. simultaneous users = ${user.totalSimultaneousUserCount}
			 <br>
		</P>
	</div>
	
	<footer>
	Copyright details
	</footer>
</body>
</html>