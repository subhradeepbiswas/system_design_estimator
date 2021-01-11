<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<div >
		<h3><u>Server estimates </u></h3>
		<P>  ${server.formula} 
			 <br>
			 Minimum # of Servers Required (to achieve specific performance) = ${server.serverRequired}
			 <br>
			 Total # of Servers Required (with replicas) = ${server.totalServerRequiredWithReplica}
			 <br>
		</P>
	</div>

</body>
</html>