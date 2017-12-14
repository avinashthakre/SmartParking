<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<FORM method="post" action="/AutoParking/rest/client/sendrequest">
		<div class="container">
			<div class="starter-template">
				<h4>Parking Slot Booking</h4>
			</div>
			<BR>
			<BR>Email Address: <INPUT TYPE="TEXT" NAME="empId" placeholder="Employee ID" size="25">
			<BR>
			<BR>Password: <INPUT TYPE="TEXT" NAME="password" placeholder="password" size="25">
			
			<BR>
			<BR>
			<INPUT TYPE="SUBMIT" value="Confirm Booking"><BR>
		</div>
	</FORM>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>