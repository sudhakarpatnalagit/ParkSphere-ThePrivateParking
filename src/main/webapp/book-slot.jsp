<%@page import="java.util.List"%>
<%@page import="com.parksphere.model.Location"%>

<!DOCTYPE html>

<html>

<head>

<title>Book Parking Slot</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container mt-5">

		<div class="card shadow">

			<div class="card-header bg-primary text-white">

				<h3>Book Parking Slot</h3>

			</div>

			<div class="card-body">

				<form action="bookSlot" method="post">

					<div class="mb-3">

						<label class="form-label"> Vehicle Number </label> <input
							type="text" name="vehicleNumber" class="form-control"
							placeholder="AP39AB1234" required>

					</div>

					<div class="mb-3">

						<label class="form-label"> Vehicle Type </label> <input
							type="text" class="form-control" value="CAR" readonly> <input
							type="hidden" name="vehicleType" value="CAR">

					</div>

					<div class="mb-3">

						<label class="form-label"> Select Location </label> <select
							name="locationId" class="form-control" required>

							<%
							List<Location> locations = (List<Location>) request.getAttribute("locations");

							if (locations != null) {

								for (Location loc : locations) {
							%>

							<option value="<%=loc.getLocationId()%>">

								<%=loc.getLocationName()%>

							</option>

							<%
							}
							}
							%>

						</select>

					</div>

					<button type="submit" class="btn btn-success">Book Parking

					</button>

				</form>

			</div>

		</div>

	</div>

</body>

</html>
