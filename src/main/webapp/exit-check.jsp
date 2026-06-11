<%@ page session="true"%>

<%
if (session.getAttribute("employee") == null) {

	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>

<head>

<title>Exit OTP Verification</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container mt-5">

		<div class="card shadow">

			<div class="card-header bg-danger text-white">

				<h3>Vehicle Exit Verification</h3>

			</div>

			<div class="card-body">

				<%
				if (request.getParameter("success") != null) {
				%>

				<div class="alert alert-success">Vehicle Checkout Completed</div>

				<%
				}
				%>

				<%
				if (request.getParameter("error") != null) {
				%>

				<div class="alert alert-danger">Invalid Exit OTP</div>

				<%
				}
				%>

				<form action="exit-check" method="post">

					<div class="mb-3">

						<label> Exit OTP </label> <input type="text" name="otp"
							class="form-control" required>

					</div>

					<button class="btn btn-danger">Verify Exit</button>

				</form>

			</div>

		</div>

	</div>

</body>

</html>