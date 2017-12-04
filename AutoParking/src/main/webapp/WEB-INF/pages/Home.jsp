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

	<FORM method="get" action="/SpringMVC/client/sendrequest">
		<div class="container">
			<div class="starter-template">
				<h1>Parking Slot Booking</h1>
			</div>
			<BR>
			<BR>Email Address: <INPUT TYPE="TEXT" NAME="emailAddress" placeholder="email" size="25">
			<BR>
			<BR>Password: <INPUT TYPE="TEXT" NAME="password" placeholder="password" size="25">
			
			<BR>
			<BR>
			<INPUT TYPE="SUBMIT" value="Submit"><BR>
		</div>
	</FORM>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>