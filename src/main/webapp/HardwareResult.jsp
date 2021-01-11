<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<html>
<body>
	<div >
		<h3><u>Traffic estimates </u></h3>
		<P>  ${traffic.writeReqFormula} 
			<br>
			 ${traffic.readReqFormula}
			 <br>
			 <br>
			 Write requests per second = ${traffic.writeReqs}
			 <br> 
			 Query (Read requests) per second (QPS) = ${traffic.readReqs}
		</P>
		<br>
		<h3><u>Storage estimates</u></h3>
		<P>  ${storage.consideration} 
			 <br>
			 ${storage.formula}
			 <br> 
			 Total storage required for 10 years = ${storage.estimatedStorage}
		</P>
		<br>
		<h3><u>Cache estimates</u></h3>
		<P>  ${memory.consideration} 
			 <br>
			 ${memory.formula}
			 <br> 
			 Required cache = ${memory.estimatedCache}
		</P>
		<br>
		<h3><u>Bandwidth estimates</u></h3>
		<P>  ${bandwidth.formula}
			 Required bandwidth = ${bandwidth.requiredBandwidth}
		</P>
	</div>
	
</body>
</html>