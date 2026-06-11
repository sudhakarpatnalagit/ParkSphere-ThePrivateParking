<%@page import="com.parksphere.model.Employee"%>

<%

Employee emp =
(Employee)
request.getAttribute("employee");

%>

<!DOCTYPE html>
<html>

<head>

<title>Edit Employee</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
}

.container{

width:500px;
margin:50px auto;
background:white;
padding:25px;
border-radius:10px;
box-shadow:0 0 10px #ccc;
}

input,select{

width:100%;
padding:10px;
margin-top:10px;
margin-bottom:15px;
}

button{

width:100%;
padding:12px;
background:#1976D2;
color:white;
border:none;
cursor:pointer;
}

</style>

</head>

<body>

<div class="container">

<h2>Edit Employee</h2>

<form action="update-employee"
method="post">

<input type="hidden"
name="employeeId"
value="<%=emp.getEmployeeId()%>">

<input type="text"
name="fullName"
value="<%=emp.getFullName()%>"
required>

<input type="email"
name="email"
value="<%=emp.getEmail()%>"
required>

<input type="text"
name="phone"
value="<%=emp.getPhone()%>"
required>

<input type="text"
name="password"
value="<%=emp.getPassword()%>"
required>

<select name="status">

<option value="ACTIVE"
<%= "ACTIVE".equals(emp.getStatus())
? "selected" : "" %>>
ACTIVE
</option>

<option value="INACTIVE"
<%= "INACTIVE".equals(emp.getStatus())
? "selected" : "" %>>
INACTIVE
</option>

</select>

<button type="submit">
Update Employee
</button>

</form>

</div>

</body>
</html>