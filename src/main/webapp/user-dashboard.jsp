<%@ page session="true"%>

<%@page import="com.parksphere.model.User"%>
<%@page import="com.parksphere.model.Booking"%>
<%@page import="com.parksphere.dao.BookingDAOImpl"%>

<%
if (session.getAttribute("user") == null) {

	response.sendRedirect("login.jsp");
	return;

}

User user = (User) session.getAttribute("user");

Booking booking = null;

try {

	BookingDAOImpl bookingDAO = new BookingDAOImpl();

	booking = bookingDAO.getActiveBookingByUserId(user.getUserId());

} catch (Exception e) {

	e.printStackTrace();

}
%>


<!DOCTYPE html>

<html>
<head>

<title>ParkSphere User Dashboard</title>

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

.navbar-brand {
	font-weight: bold;
	font-size: 24px;
}

.card {
	border: none;
	border-radius: 15px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}

.stat-card {
	color: white;
}

.booking {
	background: #0d6efd;
}

.total {
	background: #212529;
}

.profile-item {
	margin-bottom: 10px;
}

.wallet-badge {
	font-size: 14px;
	padding: 8px 12px;
}
</style>

</head>

<body>

	<!-- Navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

		<div class="container-fluid">

			<a class="navbar-brand" href="#"> ParkSphere </a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarNav">

				<ul class="navbar-nav ms-auto">

					<li class="nav-item"><a class="nav-link active"
						href="user-dashboard.jsp"> Dashboard </a></li>

					<li class="nav-item"><a class="nav-link" href="load-book-slot">

							Book Slot </a></li>

					<li class="nav-item"><a class="nav-link"
						href="transaction-history"> Transactions </a></li>
					<span class="badge bg-success wallet-badge"> <i
						class="fa-solid fa-wallet"></i> credits <%=user.getWalletBalance()%>

					</span>
					<li class="nav-item"><a class="nav-link text-warning"
						href="logout"> Logout </a></li>

				</ul>

			</div>

		</div>
	</nav>

	<div class="container mt-4">

		<!-- Welcome Card -->

		<div class="card">

			<div class="card-body">

				<h2>
					Welcome
					<%=user.getFullName()%>
				</h2>

				<p class="text-muted"></p>

			</div>

		</div>


		<!-- Book Slot -->

		<div class="card mt-4">

			<div class="card-header">Book Parking Slot</div>

			<div class="card-body">

				<p>Reserve a parking slot at your desired location.</p>

				<%
				if (booking == null) {
				%>

				<a href="load-book-slot" class="btn btn-primary"> Book Slot </a>

				<%
				} else {
				%>

				<button class="btn btn-secondary" disabled>Active Booking
					Exists</button>

				<p class="text-danger mt-2">Complete your current booking before
					creating a new one.</p>

				<%
				}
				%>

			</div>

		</div>
		<div class="card mt-4">


			<div class="card-header bg-primary text-white">Active Booking</div>

			<div class="card-body">

				<%
				if (booking != null) {
				%>

				<p>

					<b>Booking ID :</b>
					<%=booking.getBookingId()%>

				</p>

				<p>

					<b>Vehicle Number :</b>
					<%=booking.getVehicleNumber()%>

				</p>

				<p>

					<b>Vehicle Type :</b>
					<%=booking.getVehicleType()%>

				</p>

				<p>

					<b>Status :</b>
					<%=booking.getBookingStatus()%>

				</p>

				<%
				if ("BOOKED".equals(booking.getBookingStatus())) {
				%>

				<div class="alert alert-success">

					<h4>ENTRY OTP</h4>

					<h1>

						<%=booking.getEntryOtp()%>

					</h1>

					<p>Show this OTP to parking employee.</p>

				</div>

				<%
				}
				%>

				<%
				if ("PARKED".equals(booking.getBookingStatus())) {
				%>

				<div class="alert alert-info">

					<h4>Vehicle Successfully Parked</h4>

					<p>You can now request checkout.</p>

					<a href="checkout-request?bookingId=<%=booking.getBookingId()%>"
						class="btn btn-danger"> Request Checkout </a>

				</div>

				<%
				}
				%>

				<%
				if ("CHECKOUT_REQUESTED".equals(booking.getBookingStatus())) {
				%>
				<div class="alert alert-warning">

					<h4>EXIT OTP</h4>

					<h1>

						<%=booking.getExitOtp()%>

					</h1>

					<hr>

					<h4>Amount To Pay</h4>

					<h2 class="text-danger">

						
						RS. <%=booking.getTotalAmount()%>

					</h2>

					<p>Show this OTP to the parking employee and pay the above
						amount.</p>

				</div>

				<%
				}
				%>

				<%
				if ("COMPLETED".equals(booking.getBookingStatus())) {
				%>

				<div class="alert alert-success">Parking Session Completed</div>

				<%
				}
				%>

				<%
				} else {
				%>

				<div class="alert alert-warning">No Active Booking Found</div>

				<%
				}
				%>

			</div>

		</div>

		<!-- Footer -->

		<div class="text-center mt-4 mb-3">

			<p class="text-muted">ParkSphere Private Parking Management
				System</p>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
