<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">

<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->
<h1>Enter Loan Details to Apply</h1>
<form action="user?action=placeloan" method="post">
<table style="width: 80% , height:80%">
	<tr>
		<td><label>Enter Loan Name</label></td>
		<td><input type="text" id="lname" name="loanname" required/></td>
	</tr>

	<tr>
		<td><label>Enter Amount</label></td>
		<td><input type="number" id="lamt" name="amount" required/></td>
	</tr>
	<tr>
		<td><label>Enter Date</label></td>
		<td><input type="date" id="ldate" name="date" required/></td>
	</tr>
	<tr>
		<td><label>Enter Business Structure</label></td>
		<td><select name="BusinessStructure" required>
						<option value="Individual">Individual</option>
						<option value="Organisation">Organisation</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Billing Indicator</label></td>
		<td><select name="BillingInd" required>
						<option value="Salaried">Salaried</option>
						<option value="Non-Salaried">Non-Salaried</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Tax Indicator</label></td>
		<td><select name="TaxInd" required>
						<option value="Tax Payer">Tax Payer</option>
						<option value="Non-Tax Payer">Non-Tax Payer</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Contact Number</label></td>
		<td><input type="number" maxLength="10" pattern="[0-9]{10}$" title="Enter only digits" name="MobileNumber" required/></td>
	</tr>
	<tr>
		<td><label>Email Id</label></td>
		<td><input type="email" name="Email" required/></td>
	</tr>
	<tr>
		<td><label>Address</label></td>
		<td><input type="text" name="Address" required/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Apply Loan"/></td>
	</tr>
</table>
</form>



</body>
</html>