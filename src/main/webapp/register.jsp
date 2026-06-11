<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>

<title>User Registration</title>

<style>

body{
font-family:Arial;
background:#f5f5f5;
}

.container{

width:400px;
margin:50px auto;
background:white;
padding:25px;
border-radius:10px;
box-shadow:0 0 10px gray;
}

input{

width:100%;
padding:10px;
margin-top:10px;
}

button{

width:100%;
padding:10px;
background:#28a745;
color:white;
border:none;
margin-top:15px;
cursor:pointer;
}

.error{
color:red;
}

.success{
color:green;
}

</style>

</head>

<body>

<div class="container">

<h2>User Registration</h2>

<%
if(request.getParameter("error") != null){
%>

<p class="error">
Registration Failed
</p>

<%
}
%>

<form action="register" method="post">

<input
type="text"
name="fullName"
placeholder="Full Name"
required>

<input
type="email"
name="email"
placeholder="Email"
required>

<input
type="text"
name="phone"
placeholder="Phone Number"
required>

<input
type="password"
name="password"
placeholder="Password"
required>

<button type="submit">
Register
</button>

</form>

<br>

<p style="text-align:center;">
Already have an account?
<a href="login.jsp">
Login Here
</a>
</p>

</div>

</body>
</html>