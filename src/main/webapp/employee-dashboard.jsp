<%@ page session="true"%>

<%
if(session.getAttribute("employee")==null){

response.sendRedirect("login.jsp");
return;

}

com.parksphere.model.Employee emp =
(com.parksphere.model.Employee)
session.getAttribute("employee");
%>

<!DOCTYPE html>

<html>

<head>

<title>Employee Dashboard</title>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>
body {
	background: #f4f6f9;
}

.navbar {
	box-shadow: 0px 2px 10px rgba(0, 0, 0, .1);
}

.card {
	border: none;
	border-radius: 15px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, .1);
}

.hero-card {
	background: linear-gradient(135deg, #198754, #157347);
	color: white;
}

.action-card {
	text-align: center;
	transition: 0.3s;
}

.action-card:hover {
	transform: translateY(-5px);
}

.icon {
	font-size: 45px;
	margin-bottom: 10px;
}
</style>

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success">

		<div class="container-fluid">

			<a class="navbar-brand" href="#"> <i
				class="fa-solid fa-square-parking"></i> ParkSphere Employee

			</a>

			<div class="ms-auto">

				<span class="text-white"> Welcome, <%=emp.getFullName()%>

				</span> <a href="logout" class="btn btn-warning btn-sm ms-3"> Logout </a>

			</div>

		</div>

	</nav>

	<div class="container mt-4">

		<div class="card hero-card mb-4">

			<div class="card-body">

				<h2>

					<i class="fa-solid fa-user-shield"></i> Employee Control Panel

				</h2>

				<p>Manage vehicle entry and exit verification.</p>

			</div>

		</div>

		<div class="row">

			<div class="col-md-6">

				<div class="card action-card">

					<div class="card-body">

						<div class="icon text-success">

							<i class="fa-solid fa-right-to-bracket"></i>

						</div>

						<h4>Entry Verification</h4>

						<p>Verify vehicle entry OTP and allow parking.</p>

						<a href="entry-check.jsp" class="btn btn-success"> Verify
							Entry OTP </a>

					</div>

				</div>

			</div>

			<div class="col-md-6">

				<div class="card action-card">

					<div class="card-body">

						<div class="icon text-danger">

							<i class="fa-solid fa-right-from-bracket"></i>

						</div>

						<h4>Exit Verification</h4>

						<p>Verify exit OTP and allow checkout.</p>

						<a href="exit-check.jsp" class="btn btn-danger"> Verify Exit
							OTP </a>

					</div>

				</div>

			</div>

		</div>

		<div class="card mt-4">

			<div class="card-header bg-dark text-white">Today's
				Responsibilities</div>

			<div class="card-body">

				<ul>

					<li>Verify Entry OTPs</li>

					<li>Verify Exit OTPs</li>

					<li>Manage Vehicle Flow</li>

					<li>Assist Customers</li>

					<li>Monitor Parking Operations</li>

				</ul>

			</div>

		</div>

		<div class="text-center mt-4">

			<p class="text-muted">ParkSphere Employee Portal</p>

		</div>

	</div>

</body>

</html>
