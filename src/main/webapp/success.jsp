<%@ page import="dao.BookingDAO" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Booking Success</title>
<link rel="stylesheet" href="success.css">
</head>
<body>

<div class="container">

<h1> Tractor Booked Successfully</h1>

<p class="msg">
Your booking has been confirmed!
</p>

<h3>
Booking ID :
<%= new BookingDAO().getLastBookingId() %>
</h3>

<br>

<a href="DownloadPDFServlet"
class="btn">
 Download Receipt PDF </a>

<br><br>

<a href="dashboard.jsp"
class="btn">
 Go To Dashboard </a>

</div>

</body>
</html>
