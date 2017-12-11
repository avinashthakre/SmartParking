<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Slot</title>
</head>
<body>
	<center>
		<FORM method="post" action="/AutoParking/client/addSlotRequest"   enctype="multipart/form-data">
			<div class="container">
				<div class="starter-template">
					<h1>Add Slot</h1>
				</div>
				<div>
					<input type="radio" name="submitType" value="single" onclick="hideShow()"
						checked> Single Submit<br> 
						<input type="radio"	name="submitType"  onclick="hideShow()" value="bulk"> bulk Submit<br>
				</div>
				<div id="SingleSubmitForm">
					<BR> <BR> Building Id:
					<!-- <INPUT TYPE="TEXT" NAME="buildingId" placeholder="Building Id" size="25">  -->
					<select name="buildingId">
						<c:forEach var="building" items="${buildingList}">
							<option value="${building.buildingId}">${building.buildingId}</option>
						</c:forEach>
					</select> <BR> <BR> Floor Id: <select name="floorId">
						<option value="F01">1st Floor</option>
						<option value="F02">2nd Floor</option>
						<option value="F03">3rd Floor</option>
						<option value="F04">4th Floor</option>
						<option value="F05">5th Floor</option>
						<option value="F06">6th Floor</option>
						<option value="F07">7th Floor</option>
						<option value="F08">8th Floor</option>
						<option value="F09">9th Floor</option>
					</select> <BR> <BR> Slot Id: <INPUT TYPE="TEXT" NAME="slotId"
						placeholder="9999" size="4">
				</div>
				<div id="BulkSubmitForm">
					<input type="file" name="slotFile" accept=".csv">
				</div>
				<BR> <BR> <INPUT TYPE="SUBMIT" value="Submit"><BR>
			</div>
		</FORM>
		<!-- /.container -->
		<div>${message}</div>
	</center>


	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<script type="text/javascript">
function hideShow() {
    var x = document.getElementById("SingleSubmitForm");
    var y = document.getElementById("BulkSubmitForm");
    if (x.style.display === "none") {
        x.style.display = "block";
        y.style.display = "none";
    } else {
        x.style.display = "none";
        y.style.display = "block";
    }
}
</script>
</html>