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

<title>Entry OTP Verification</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container mt-5">

		<div class="row justify-content-center">

			<div class="col-md-6">

				<div class="card shadow">

					<div class="card-header bg-primary text-white">

						<h3>Vehicle Entry Verification</h3>

					</div>

					<div class="card-body">

						<%
						if (request.getParameter("success") != null) {
						%>

						<div class="alert alert-success">Vehicle Entry Verified
							Successfully</div>

						<%
						}
						%>

						<%
						if (request.getParameter("error") != null) {
						%>

						<div class="alert alert-danger">Invalid OTP</div>

						<%
						}
						%>

						<form action="entry-check" method="post">

							<div class="mb-3">

								<label class="form-label"> Enter Entry OTP </label> <input
									type="text" name="otp" class="form-control"
									placeholder="Enter OTP" required>

							</div>

							<button type="submit" class="btn btn-success">Verify
								Entry</button>

						</form>

					</div>

				</div>

			</div>

		</div>

	</div>

</body>

</html>