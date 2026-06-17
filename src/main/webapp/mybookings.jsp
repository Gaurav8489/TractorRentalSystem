<%@ page import="java.sql.ResultSet" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Bookings</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="mybooking.css">

</head>
<body>

<h1>My Bookings</h1>

<table>

<tr>
    <th>Booking ID</th>
    <th>Tractor ID</th>
    <th>Days</th>
    <th>Total Rent</th>
    <th>Booking Date</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
ResultSet rs =
(ResultSet)request.getAttribute("bookingData");

while(rs.next()){
%>

<tr>

<td><%= rs.getInt("booking_id") %></td>

<td><%= rs.getInt("tractor_id") %></td>

<td><%= rs.getInt("booking_days") %></td>

<td><%= rs.getDouble("total_rent") %></td>

<td><%= rs.getDate("booking_date") %></td>

<td>

<%
String status =
rs.getString("status");

if("Confirmed".equalsIgnoreCase(status)){
%>

<span style="
background:green;
color:white;
padding:5px 12px;
border-radius:20px;">
Confirmed </span>

<%
}else{
%>

<span style="
background:red;
color:white;
padding:5px 12px;
border-radius:20px;">
Cancelled </span>

<%
}
%>

</td>

<td>

<%
if("Confirmed".equalsIgnoreCase(
rs.getString("status"))){
%>

<a href="CancelBookingServlet?bookingId=<%= rs.getInt("booking_id") %>">
Cancel </a>

<%
}else{
%>

<span style="color:red;">
Already Cancelled
</span>

<%
}
%>

</td>

</tr>

<%
}
%>

</table>

<br><br>

<a href="dashboard.jsp" class="back-btn">
Back To Dashboard
</a>

</body>
</html>
