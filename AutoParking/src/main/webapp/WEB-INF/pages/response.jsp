<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		
		<BR>
		<div>
		<%String result =(String) request.getAttribute("result");
		if(result.equals("SUCCESS")){ %>
		<h4>Your parking slot details</h4>
			<span>Result : ${result} </span> <br> <span>Building :
				${buildingId} </span> <br> <span>Floor : ${floorId}</span> <br> <span>Slot
				: ${slotId}</span> <br>
				<%}
		else if(result.equals("FAILED")){
		%>
		<span>Result : Slot booking failed </span>
		<%}else{ %>
		<h4>Success</h4>
		<span>Result : ${result} </span>
		<%} %>
		</div>
	</center>
</body>
</html>