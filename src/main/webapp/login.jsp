<%@ page language="java"%>

<!DOCTYPE html>
<html>
<head>

<title>Private Parking Login</title>

<style>
body {
	font-family: Arial;
	background: #f5f5f5;
}

.container {
	width: 350px;
	margin: 80px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 10px gray;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
}

button {
	width: 100%;
	padding: 10px;
	background: #2196F3;
	color: white;
	border: none;
	margin-top: 15px;
	cursor: pointer;
}

.error {
	color: red;
}
</style>

</head>

<body>

	<div class="container">

		<h2>Private Parking Login</h2>

		<%
		if (request.getParameter("error") != null) {
		%>

		<p class="error">Invalid Credentials</p>

		<%
		}
		%>

		<form action="login" method="post">

			<input type="text" name="email" placeholder="Email / Username"
				required> <input type="password" name="password"
				placeholder="Password" required> <select name="role">

				<option value="USER">User</option>

				<option value="EMPLOYEE">Employee</option>

				<option value="ADMIN">Admin</option>

			</select>

			<button type="submit">Login</button>
			<br>
			<p style="text-align: center;">
				Don't have an account? <a href="register.jsp"> Register Here </a>
			</p>
		</form>

	</div>

</body>
</html>