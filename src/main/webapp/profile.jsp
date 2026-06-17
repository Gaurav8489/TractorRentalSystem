<%@ page import="model.Farmer" pageEncoding="UTF-8" %>

<%
Farmer farmer = (Farmer)request.getAttribute("farmer");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= (farmer == null) ? "Error - Data Not Found" : "My Profile" %></title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="profile.css">
</head>
<body>

<%
if(farmer == null){
%>
    <div class="profile-container" style="text-align: center; margin-top: 10vh;">
        <div style="font-size: 3.5rem; margin-bottom: 15px;">⚠️</div>
        <h2>Farmer Data Not Found</h2>
        <a href="farmerdashboard.html" style="margin-top: 15px;">Back To Dashboard</a>
    </div>
<%
} else {
%>
    <div class="profile-container">
        
        <div class="profile-header">
            <div class="profile-avatar">🧑‍🌾</div>
            <h1>My Profile</h1>
        </div>

        <div class="profile-details">
            <div class="detail-row">
                <span class="label">Farmer ID</span>
                <span class="value"><%= farmer.getFarmerId() %></span>
            </div>
            
            <div class="detail-row">
                <span class="label">Name</span>
                <span class="value"><%= farmer.getFarmerName() %></span>
            </div>
            
            <div class="detail-row">
                <span class="label">Mobile</span>
                <span class="value"><%= farmer.getMobile() %></span>
            </div>
            
            <div class="detail-row">
                <span class="label">Village</span>
                <span class="value"><%= farmer.getVillage() %></span>
            </div>
        </div>

        <a href="dashboard.jsp">Back</a>

    </div>
<%
}
%>

</body>
</html>