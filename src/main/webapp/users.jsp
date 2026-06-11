<%@page import="java.util.*"%>
<%@page import="com.parksphere.model.User"%>

<!DOCTYPE html>
<html>
<head>

<title>Users</title>

<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: center;
}

th {
	background: #1976D2;
	color: white;
}

.btn {
	padding: 8px 12px;
	text-decoration: none;
	color: white;
	border-radius: 5px;
}

.block {
	background: red;
}

.activate {
	background: green;
}

.edit{
	background: grey;
}
</style>

</head>

<body>

	<h2>User Management</h2>

	<table>

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Status</th>
			<th>Action</th>
		</tr>

		<%
		List<User> users = (List<User>) request.getAttribute("users");

		for (User user : users) {
		%>

		<tr>

			<td><%=user.getUserId()%></td>

			<td><%=user.getFullName()%></td>

			<td><%=user.getEmail()%></td>

			<td><%=user.getPhone()%></td>



			<td><a class="btn block"
				href="block-user?id=<%=user.getUserId()%>"> Block </a> <a
				class="btn activate" href="activate-user?id=<%=user.getUserId()%>">
					Activate </a></td>

			<td><a class="btn edit"
				href="edit-user?id=<%=user.getUserId()%>"> Edit </a></td>

		</tr>

		<%
		}
		%>

	</table>

</body>
</html>