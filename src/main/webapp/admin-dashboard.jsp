<%@ page session="true"%>

<%
if (!"ADMIN".equals(session.getAttribute("role"))) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>

<title>Admin Dashboard</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial;
}

.navbar {
	background: #1976D2;
	padding: 15px;
}

.navbar a {
	color: white;
	text-decoration: none;
	margin-right: 20px;
	font-weight: bold;
}

.container {
	padding: 20px;
}

.card {
	background: white;
	padding: 20px;
	margin-bottom: 20px;
	border-radius: 10px;
	box-shadow: 0 0 8px #ccc;
}
</style>

</head>

<body>

	<div class="navbar">

		<a href="admin-dashboard.jsp">Dashboard</a> 
		
		<a href="users-list">Users</a>

		<a href="employees-list">Employees</a> 
		
		<a href="logout">Logout</a>

	</div>

	<div class="container">

		<div class="card">
			<h2>Admin Panel</h2>
			<p>Manage Users and Employees</p>
		</div>

	</div>

</body>
</html>