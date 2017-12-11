<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript">
	function onClick() {
		var span = document.getElementById("error");
		span.textContent = "";
	}

	function validateEmail(email) {
		var span = null;
		if (email != null && email.length != 0) {
			var emailPattern = /^[a-zA-Z][a-zA-Z0-9._]+.@infosys.com$/;
			if (!email.match(emailPattern)) {
				//alert("Invalid Email Id Format.");
				span = document.getElementById("error");
				span.textContent = "Invalid Email Id Format.";
			}
		} else {
			//alert("Email Id should not be BLANK.");
			span = document.getElementById("error");
			span.textContent = "Email Id should not be BLANK.";
		}
	}

	function formatPassword(password) {
		if (password != null && password.length != 0) {
			var passwordPattern = /^[a-zA-Z0-9!@#$%^&*_]{8,16}$/ ///^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^\\s])\\w.{8,14}$/;
			if (!password.match(passwordPattern)) {
				//alert(password
				//		+ " Password must have atleast eight characters including one uppercase letter, one special character and one number.");
				span = document.getElementById("error");
				span.textContent = password + " : Password must have atleast eight characters including one uppercase letter, one special character and one number.";
			}
		} else {
			//alert("Password should not be BLANK.");
			span = document.getElementById("error");
			span.textContent = "Password should not be BLANK.";
		}
	}

	function validatePassword(repassword) {
		var password = document.regForm.password.value;
		if (repassword != null && repassword.length != 0) {
			if (repassword != password)
				//alert("Passwords doesn't match.");
				span = document.getElementById("error");
				span.textContent = "Passwords doesn't match.";
		}
	}
</script>
</head>
<body>

	<FORM name="regForm" method="get"
		action="/AutoParking/client/validateRegistration">
		<div class="container">
			<div class="starter-template">
				<h1>Smart Parking : User Registration</h1>
			</div>
			<table style="width: 100%">
				<tr>
					<td>Employee ID:</td>
					<td><INPUT TYPE="TEXT" NAME="empId" placeholder="123"
						size="25"></td>
				</tr>
				<tr>
					<td>Email Address:</td>
					<td><INPUT TYPE="TEXT" NAME="emailAddress" onclick="onClick()"
						onblur="validateEmail(this.value)"
						placeholder="joe.yoko@infosys.com" size="25"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><INPUT TYPE="password" NAME="password" placeholder=""
						onclick="onClick()" onblur="formatPassword(this.value)" size="25"></td>
				</tr>
				<tr>
					<td>Re-Enter Password:</td>
					<td><INPUT TYPE="password" NAME="repassword" placeholder=""
						onclick="onClick()" onblur="validatePassword(this.value)"
						size="25"></td>
				</tr>
				<tr>
					<td></td>
					<td><INPUT TYPE="SUBMIT" value="Submit"></td>
				</tr>
				<tr>
					<td></td>
					<td><font color="red"><span id="error"></span></font></td>
				</tr>
			</table>
		</div>
	</FORM>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>