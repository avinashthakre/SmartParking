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
<script>
	function showOptions() {
		//alert("In showOptions...");

		var get = document.getElementById("GET").checked;
		var post = document.getElementById("POST").checked;				

		if(post) {
			//alert("Show for POST/PUT...");
			document.getElementById('select').style.display = '';
		}
		else {
			//alert("Hide for GET...");
			document.getElementById('select').style.display = 'none';
		}
		
	}
</script>
<body>

	<FORM method="get" action="/SpringMVC/client/sendrequest">
		<div class="container">
			<div class="starter-template">
				<h1>Spring Rest Client</h1>
			</div>
			<BR>
			<BR> Please enter URL: <INPUT TYPE="TEXT" NAME="requestURI" placeholder="URI" size="50">
			<BR>
			<BR> Select request type: 
			<input type="radio" name="branch" id="GET" value="GET" onclick="showOptions()"> GET 
			<input type="radio" name="branch" id="POST" value="POST" onclick="showOptions()"> POST			
			<input type="radio" name="branch" id="DELETE" value="DELETE" onclick="showOptions()"> DELETE
						
			<div id = "select" style = "display:none">
			<BR>
			<BR>
			Raw
				<select name="contentType">
					<option value="json">JSON</option>
    				<option value="xml">XML</option>
				</select>
			<BR>
			<BR>
			<textarea name="bodyText" placeholder="Enter values" rows="10" cols="100"></textarea>
				
			</div>
			
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