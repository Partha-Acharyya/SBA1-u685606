<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body>
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->

<h2>Enter Loan Number to Edit</h2>
<form action="user?action=editloan" method="post">
<table style="width: 80% , height:80%">
	<tr>
		<td><label>Enter Loan Name</label></td>
		<td><input type="text" id="lname" name="loanno" required/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Edit Loan"/></td>
	</tr>
</table>
</form>
</body>
</html>