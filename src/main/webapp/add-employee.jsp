<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>

<title>Add Employee</title>

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
background:#28a745;
color:white;
border:none;
cursor:pointer;
}

</style>

</head>

<body>

<div class="container">

<h2>Add Employee</h2>

<form action="add-employee" method="post">

<input type="text"
name="locationId"
placeholder="Location Id"
required>

<input type="text"
name="fullName"
placeholder="Full Name"
required>

<input type="email"
name="email"
placeholder="Email"
required>

<input type="text"
name="phone"
placeholder="Phone Number"
required>

<input type="password"
name="password"
placeholder="Password"
required>

<select name="status">

<option value="ACTIVE">
ACTIVE
</option>

<option value="INACTIVE">
INACTIVE
</option>

</select>

<button type="submit">
Add Employee
</button>

</form>

</div>

</body>
</html>