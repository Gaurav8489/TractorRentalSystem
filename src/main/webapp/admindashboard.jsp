<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="admindashboard.css">
</head>
<body>

<div class="dashboard-container">

    <h1>🛡️ Admin Dashboard</h1>

    <div class="stats-container">
        <div class="stat-card">
            <div class="icon">🧑‍🌾</div>
            <p>Total Farmers</p>
            <h3><%= request.getAttribute("totalFarmers") %></h3>
        </div>
        
        <div class="stat-card">
            <div class="icon">🚜</div>
            <p>Total Tractors</p>
            <h3><%= request.getAttribute("totalTractors") %></h3>
        </div>
        
        <div class="stat-card">
            <div class="icon">📅</div>
            <p>Total Bookings</p>
            <h3><%= request.getAttribute("totalBookings") %></h3>
        </div>
    </div>

    <!-- Tractor stats section -->
    <div class="stats-container">
        <div class="stat-card">
            <div class="icon">✅</div>
            <p>Available Tractors</p>
            <h3><%= request.getAttribute("availableTractors") %></h3>
        </div>
        
        <div class="stat-card">
            <div class="icon">❌</div>
            <p>Booked Tractors</p>
            <h3><%= request.getAttribute("bookedTractors") %></h3>
        </div>
    </div>

    <!-- Revenue card -->
    <div class="stats-container">
        <div class="stat-card revenue-card">
            <div class="icon">💰</div>
            <p>Total Revenue</p>
            <h3>₹<%= request.getAttribute("totalRevenue") %></h3>
        </div>
    </div>

    <div class="menu-grid">
        <a href="addtractor.html">Add Tractor</a>
        <a href="searchtractor.html">Search Tractor</a>
        <a href="updatetractor.html">Update Tractor</a>
        <a href="deletetractor.html">Delete Tractor</a>
        <a href="ViewFarmersServlet" style="grid-column: span 2;">View Farmers</a>
        <a href="admindashboard.html"> More Information </a>
        <a href="AdminAllBookingsServlet">View All Bookings</a>
        
    </div>

    <div class="logout-container">
        <a href="index.html">Logout</a>
    </div>

</div>

</body>
</html>
