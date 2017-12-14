<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Login</title>
</head>
<body>
	<center>
		<FORM method="post" action="/AutoParking/rest/admin/login">
			<div class="container">
				<div class="starter-template">
					<h1>Administrator Login</h1>
				</div>
				<BR> <BR>Username: <INPUT TYPE="TEXT" NAME="username"
					placeholder="user name" size="25"> <BR> <BR>Password: <INPUT TYPE="password" NAME="password"
					placeholder="password" size="25"> <BR> <BR>
				<INPUT TYPE="SUBMIT" value="Submit"><BR>
			</div>
		</FORM>
		<!-- /.container -->
		<div>${errorMessage}</div>
	</center>
</body>
</html>