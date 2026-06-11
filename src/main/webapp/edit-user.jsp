<%@page import="com.parksphere.model.User"%>

<%
User user = (User) request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit User</title>
</head>

<body>

	<h2>Edit User</h2>

	<form action="update-user" method="post">

		<input type="hidden" name="userId" value="<%=user.getUserId()%>">

		Name: <input type="text" name="fullName"
			value="<%=user.getFullName()%>"> <br>
		<br> Email: <input type="email" name="email"
			value="<%=user.getEmail()%>"> <br>
		<br> Phone: <input type="text" name="phone"
			value="<%=user.getPhone()%>"> <br>
		<br> Password: <input type="text" name="password"
			value="<%=user.getPassword()%>"> <br>
		<br>

		<button type="submit">Update User</button>

	</form>

</body>
</html>