<%@ page import="java.sql.ResultSet" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Result</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="searchresult.css">
</head>
<body>

<h1>🚜 Tractor Details</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Model</th>
        <th>Rent</th>
        <th>Status</th>
    </tr>
    <%
    ResultSet rs = (ResultSet)request.getAttribute("tractorData");

    while(rs.next()){
    %>
    <tr>
        <td><%= rs.getInt("tractor_id") %></td>
        <td><%= rs.getString("tractor_name") %></td>
        <td><%= rs.getString("model") %></td>
        <td><%= rs.getDouble("rent_per_day") %></td>
        <td><%= rs.getString("status") %></td>
    </tr>
    <%
    }
    %>
</table>

<a href="admindashboard.html">Back</a>

</body>
</html>