<%@page import="java.util.List"%>
<%@page import="com.parksphere.model.Transaction"%>

<%
List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
%>

<!DOCTYPE html>

<html>

<head>

<title>Transaction History</title>

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

.card {
	border: none;
	border-radius: 15px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}

.page-header {
	background: linear-gradient(135deg, #0d6efd, #0a58ca);
	color: white;
	padding: 25px;
	border-radius: 15px;
}

.amount {
	font-weight: bold;
	color: #198754;
}
</style>

</head>

<body>

	<div class="container mt-4">

		<div class="page-header">

			<h2>

				<i class="fa-solid fa-money-bill-wave"></i> Transaction History

			</h2>

			<p>View all your parking payments and completed transactions.</p>

		</div>

		<div class="card mt-4">

			<div class="card-body">

				<table class="table table-hover align-middle">

					<thead class="table-dark">

						<tr>

							<th><i class="fa-solid fa-hashtag"></i> Transaction ID</th>

							<th><i class="fa-solid fa-ticket"></i> Booking ID</th>

							<th><i class="fa-solid fa-indian-rupee-sign"></i> Amount</th>

							<th><i class="fa-solid fa-credit-card"></i> Method</th>

							<th><i class="fa-solid fa-circle-check"></i> Status</th>

						</tr>

					</thead>

					<tbody>

						<%
						if (transactions != null && !transactions.isEmpty()) {

							for (Transaction tx : transactions) {
						%>

						<tr>

							<td>#<%=tx.getTransactionId()%>

							</td>

							<td><%=tx.getBookingId()%></td>

							<td class="amount"><%=tx.getAmount()%>

							</td>

							<td><%=tx.getPaymentMethod()%></td>

							<td>
								<%
								if ("SUCCESS".equals(tx.getPaymentStatus())) {
								%> <span class="badge bg-success"> SUCCESS </span> <%
 } else if ("FAILED".equals(tx.getPaymentStatus())) {
 %> <span class="badge bg-danger"> FAILED </span> <%
 } else {
 %> <span class="badge bg-warning text-dark"> PENDING </span> <%
 }
 %>

							</td>

						</tr>

						<%
						}
						} else {
						%>

						<tr>

							<td colspan="5" class="text-center"><i
								class="fa-solid fa-receipt fa-2x"></i> <br>
							<br> No Transactions Found</td>

						</tr>

						<%
						}
						%>

					</tbody>

				</table>

			</div>

		</div>

		<div class="text-center mt-4">

			<a href="user-dashboard.jsp" class="btn btn-primary"> <i
				class="fa-solid fa-arrow-left"></i> Back To Dashboard

			</a>

		</div>

	</div>

</body>

</html>
