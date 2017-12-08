<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Building</title>
</head>
<body>
	<center>
		<FORM method="post" action="/AutoParking/client/addBuildingRequest">
			<div class="container">
				<div class="starter-template">
					<h1>Add Building</h1>
				</div>
				<BR> <BR>Building Id: <INPUT TYPE="TEXT" NAME="buildingId"
					placeholder="Building Id" size="25"> <BR> <BR>Building
				Name: <INPUT TYPE="TEXT" NAME="buildingName"
					placeholder="Building Name" size="25"> <BR> <BR>
				<INPUT TYPE="SUBMIT" value="Submit"><BR>
			</div>
		</FORM>
		<!-- /.container -->
		<div>${message}</div>
	</center>


	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>