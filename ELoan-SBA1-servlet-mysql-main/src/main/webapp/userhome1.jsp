<%@ page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
</head>
<body>
	<!-- write the html code to display hyperlinks for user functionalities -->
<%LoanInfo loan=(LoanInfo)request.getAttribute("LoanInfo"); %>

<h1>Your loan application is submitted with Loan Number: <%=loan.getApplno() %>
	You can track or Edit your loan application from your User Homepage.</h1>
	
<a href="userhome.jsp">Go to Homepage</a>

</body>
</html>