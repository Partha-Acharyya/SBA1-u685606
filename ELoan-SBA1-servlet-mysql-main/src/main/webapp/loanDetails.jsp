<%@ page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%LoanInfo loan=(LoanInfo)request.getAttribute("LoanInfo"); %>
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
<form action="user?action=editLoanProcess" method="post">
<table style="width: 80% , height:80%">
	<tr>
		<td><label>Loan Number</label></td>
		<td><label><%=loan.getPurpose() %></label></td>
	</tr>
	<tr>
		<td><label>Edit Loan Name</label></td>
		<td><input type="text" id="lname" name="eloanname" value="<%out.println(loan.getPurpose()); %>" /></td>
	</tr>

	<tr>
		<td><label>Enter Amount</label></td>
		<td><input type="number" id="lamt" name="eamount" value="<%out.println(loan.getAmtrequest()); %>" required/></td>
	</tr>
	<tr>
		<td><label>Enter Date</label></td>
		<td><input type="date" id="ldate" name="edate" value="<%out.println(loan.getDoa()); %>" required/></td>
	</tr>
	<tr>
		<td><label>Enter Business Structure</label></td>
		<td><select name="eBusinessStructure" value="<%out.println(loan.getBstructure()); %>" required>
						<option value="Individual">Individual</option>
						<option value="Organisation">Organisation</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Billing Indicator</label></td>
		<td><select name="eBillingInd" value="<%out.println(loan.getBindicator()); %>" required>
						<option value="Salaried">Salaried</option>
						<option value="Non-Salaried">Non-Salaried</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Tax Indicator</label></td>
		<td><select name="eTaxInd" value="<%out.println(loan.getTaxInd()); %>" required>
						<option value="Tax Payer">Tax Payer</option>
						<option value="Non-Tax Payer">Non-Tax Payer</option>
			</select></td>
	</tr>
	<tr>
		<td><label>Enter Contact Number</label></td>
		<td><input type="number"  name="MobileNumber" value="<%out.println(loan.getTaxInd()); %>" /></td>
	</tr>
	<tr>
		<td><label>Email Id</label></td>
		<td><input type="email" name="eEmail" value="<%out.println(loan.getEmail()); %>"/></td>
	</tr>
	<tr>
		<td><label>Address</label></td>
		<td><input type="text" name="eAddress" value="<%out.println(loan.getAddress()); %>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Edit Loan"/></td>
	</tr>
</table>
</form>
	
</body>
</html>