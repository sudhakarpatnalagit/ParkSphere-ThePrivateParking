<!DOCTYPE html>
<html>

<head>

<title>Add Location</title>

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
}

input{

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

<h2>Add Parking Location</h2>

<form action="add-location"
method="post">

<input type="text"
name="locationName"
placeholder="Location Name"
required>

<input type="text"
name="address"
placeholder="Address"
required>

<input type="number"
name="totalSlots"
placeholder="Total Slots"
required>

<button type="submit">
Add Location
</button>

</form>

</div>

</body>

</html>