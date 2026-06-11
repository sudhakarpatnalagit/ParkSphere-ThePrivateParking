<%@page import="java.util.List"%>
<%@page import="com.parksphere.model.Location"%>

<!DOCTYPE html>
<html>
<head>

<title>Location Management</title>

<style>

body{
font-family:Arial;
background:#f4f6f9;
padding:20px;
}

table{
width:100%;
border-collapse:collapse;
background:white;
}

th{
background:#1976D2;
color:white;
padding:12px;
}

td{
padding:10px;
border:1px solid #ddd;
text-align:center;
}

.add-btn{
background:green;
color:white;
padding:10px;
text-decoration:none;
border-radius:5px;
}

.delete-btn{
background:red;
color:white;
padding:8px;
text-decoration:none;
border-radius:5px;
}

</style>

</head>

<body>

<h2>Location Management</h2>

<br>

<a href="add-location.jsp"
class="add-btn">
Add Location
</a>

<br><br>

<%
List<Location> locations =
(List<Location>)
request.getAttribute("locations");
%>

<table>

<tr>

<th>ID</th>
<th>Location Name</th>
<th>Address</th>
<th>Total Slots</th>
<th>Action</th>

</tr>

<%
if(locations != null){

for(Location location : locations){
%>

<tr>

<td>
<%=location.getLocationId()%>
</td>

<td>
<%=location.getLocationName()%>
</td>

<td>
<%=location.getAddress()%>
</td>

<td>
<%=location.getTotalSlots()%>
</td>

<td>

<a class="delete-btn"
href="delete-location?id=<%=location.getLocationId()%>">
Delete
</a>

</td>

</tr>

<%
}
}
%>

</table>

</body>
</html>