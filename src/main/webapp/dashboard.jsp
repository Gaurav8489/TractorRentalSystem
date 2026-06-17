<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Farmer Dashboard</title>
  
  <!-- Added modern font styling engine -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
  
  <link rel="stylesheet" href="dash.css">
</head>
<body>

  <header>
    <h1>🚜 Farmer Dashboard</h1>
  </header>

  <main>
    <h2>
      Welcome, <%= session.getAttribute("farmerName") != null ? session.getAttribute("farmerName") : "Farmer" %>
    </h2>
    <nav class="menu">
      <a href="ViewTractorServlet">View Tractors <span>🔍</span></a>
      <a href="booking.html">Book Tractor <span>📅</span></a>
      <a href="MyBookingServlet">My Bookings <span>📋</span></a>
      <a href="ProfileServlet">My Profile <span>👤</span></a>
      <a href="changePassword.html">Change Password <span>🔒</span></a>
      <a href="index.html">Logout <span>🚪</span></a>
    </nav>
  </main>

</body>
</html>