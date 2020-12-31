<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<html>
<body>
<h3> Traffic estimates </h3>
<P>  ${traffic.writeReqFormula} 
	<br>
	 ${traffic.readReqFormula}
	 <br>
	 <br>
	 Write requests per second = ${traffic.writeReqs}
	 <br> 
	 Read requests per second = ${traffic.readReqs}
</P>
<br>
<h3> Storage estimates </h3>
<P>  ${storage.consideration} 
	 <br>
	 ${storage.formula}
	 <br> 
	 Total storage required for 10 years = ${storage.estimatedStorage}
</P>
<br>
<h3> Cache estimates </h3>
<P>  ${memory.consideration} 
	 <br>
	 ${memory.formula}
	 <br> 
	 Required cache = ${memory.estimatedCache}
</P>
<br>
<h3> Bandwidth estimates </h3>
<P>  ${bandwidth.formula}
	 <br> 
	 Required bandwidth = ${bandwidth.requiredBandwidth}
</P>
<br>
<br>
</body>
</html>