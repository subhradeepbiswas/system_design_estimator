<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<html>
<body>
<P>  ${traffic.readReqFormula} 
	<br>
	 ${traffic.writeReqFormula}
	 <br> 
	 ${traffic.readReqs} per second
	 <br>
	 ${traffic.writeReqs} per second
</P>
</body>
</html>