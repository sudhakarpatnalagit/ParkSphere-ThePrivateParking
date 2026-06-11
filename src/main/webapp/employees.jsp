<%@page import="java.util.*"%>
<%@page import="com.parksphere.model.Employee"%>

<!DOCTYPE html>
<html>
<head>

<title>Employees</title>

<style>

table{
width:100%;
border-collapse:collapse;
}

th,td{
border:1px solid #ddd;
padding:10px;
text-align:center;
}

th{
background:#1976D2;
color:white;
}

.btn{
padding:8px 12px;
text-decoration:none;
color:white;
border-radius:5px;
}

.edit{
background:orange;
}

.delete{
background:red;
}

.add{
background:green;
padding:10px;
display:inline-block;
margin-bottom:20px;
color:white;
text-decoration:none;
}

</style>

</head>

<body>

<h2>Employee Management</h2>

<a class="add"
href="add-employee.jsp">
Add Employee
</a>

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
List<Employee> employees =
(List<Employee>)request.getAttribute("employees");

for(Employee emp : employees){
%>

<tr>

<td><%=emp.getEmployeeId()%></td>

<td><%=emp.getFullName()%></td>

<td><%=emp.getEmail()%></td>

<td><%=emp.getPhone()%></td>

<td><%=emp.getStatus()%></td>

<td>

<a class="btn edit"
href="edit-employee?id=<%=emp.getEmployeeId()%>">
Edit
</a>

<a class="btn delete"
href="delete-employee?id=<%=emp.getEmployeeId()%>">
Delete
</a>

</td>

</tr>

<%
}
%>

</table>

</body>
</html>