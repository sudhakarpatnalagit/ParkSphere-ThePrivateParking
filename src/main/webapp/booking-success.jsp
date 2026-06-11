<!DOCTYPE html>
<html>

<head>

<title>Booking Success</title>

<link href=
"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<div class="alert alert-success">

<h2>

Booking Successful

</h2>

<h1>

OTP :
<%=request.getAttribute("otp")%>

</h1>

<p>

Show this OTP
to the employee
at the parking location.

</p>

<a href="user-dashboard.jsp"
class="btn btn-primary">

Dashboard

</a>

</div>

</div>

</body>

</html>