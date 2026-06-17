<%@ page import="java.sql.*" %>

<%
ResultSet rs =
(ResultSet)request.getAttribute(
        "bookingData");
%>

<html>
<head>
<title>All Bookings</title>
<link rel="stylesheet" href="viewallbookings.css">

</head>

<body>

<h2>All Bookings</h2>

<table border="1">

<tr>
<th>Booking ID</th>
<th>Farmer ID</th>
<th>Tractor ID</th>
<th>Days</th>
<th>Total Rent</th>
<th>Date</th>
</tr>

<%
while(rs.next()){
%>

<tr>
<td><%=rs.getInt("booking_id")%></td>
<td><%=rs.getInt("farmer_id")%></td>
<td><%=rs.getInt("tractor_id")%></td>
<td><%=rs.getInt("booking_days")%></td>
<td><%=rs.getDouble("total_rent")%></td>
<td><%=rs.getString("booking_date")%></td>
</tr>

<%
}
%>

</table>

</body>
</html>