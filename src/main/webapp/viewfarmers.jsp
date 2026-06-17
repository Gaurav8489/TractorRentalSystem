<%@ page import="java.sql.ResultSet" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Farmers</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="viewfarmers.css">
</head>
<body>

<h1>🧑‍🌾 Farmer Details</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Mobile</th>
        <th>Village</th>
    </tr>

    <%
    ResultSet rs = (ResultSet)request.getAttribute("farmerData");

    while(rs.next()){
    %>
    <tr>
        <td><%= rs.getInt("farmer_id") %></td>
        <td><%= rs.getString("farmer_name") %></td>
        <td><%= rs.getString("mobile") %></td>
        <td><%= rs.getString("village") %></td>
    </tr>
    <%
    }
    %>
</table>

<a href="AdminDashboardServlet" class="back-btn">Back</a>

</body>
</html>