<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>
<title>eLoan system</title>
</head>
<body>
	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
<h1>Welcome to Loan Management Application</h1>
<div class="tab">
  <button class="tablinks" onclick="openUserType(event, 'Admin')">Admin</button>
  <button class="tablinks" onclick="openUserType(event, 'User')">User</button>
  <button class="tablinks" onclick="openUserType(event, 'Register')">Register</button>
</div>

<div id="Admin" class="tabcontent">
  <h2>Admin</h2>
  <form action="user?action=adminvalidate" method="post">
		<div>
			<div><label>Enter Admin Id</label> </div>
			<div><input type="text" id="Adminid" name="Adminid"> </div>
		</div>
		<div>
			<div><label>Enter Admin password</label> </div>
			<div><input type="text" id="Adminpassword" name="Adminpassword"> </div>
		</div>
		<div>
			<div><input type="submit" value="Login as Admin"> </div>
		</div>
	</form>
</div>

<div id="User" class="tabcontent">
  <h2>User</h2>
  <form action="user?action=validate" method="post">
		<div>
			<div><label>Enter User Id</label> </div>
			<div><input type="text" id="Userid" name="Userid"> </div>
		</div>
		<div>
			<div><label>Enter User password</label> </div>
			<div><input type="text" id="Userpassword" name="Userpassword"> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
</div>

<div id="Register" class="tabcontent">
  <h2>Register</h2>
  	<a href="register.jsp">Register New User</a>
</div>

<script>
function openUserType(evt, UserName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(UserName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
</body>
</html>