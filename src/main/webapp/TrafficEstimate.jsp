<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<html>
<body>
<h3> Traffic estimates </h3>
<P>  ${traffic.writeReqFormula} 
	<br>
	 ${traffic.readReqFormula}
	 <br> 
	 Read requests per second = ${traffic.readReqs}
	 <br>
	 Write requests per second = ${traffic.writeReqs}
</P>
</body>
</html>