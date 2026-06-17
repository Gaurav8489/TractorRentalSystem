<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Bookings</title>
    <style>
        /* Modern Background & Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            /* Smooth multi-color gradient background */
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8f0 100%);
            min-height: 100vh;
            padding: 40px 20px;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        /* Glassmorphism Container for the Content */
        .container {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.08);
            border: 1px solid rgba(255, 255, 255, 0.5);
            width: 100%;
            max-width: 1200px;
        }

        h1 {
            font-size: 2rem;
            color: #2c3e50;
            margin-bottom: 24px;
            position: relative;
            padding-bottom: 8px;
        }

        /* Subtle underline effect below heading */
        h1::after {
            content: '';
            position: absolute;
            left: 0;
            bottom: 0;
            width: 60px;
            height: 4px;
            background: #3498db;
            border-radius: 2px;
        }

        /* Responsive Table Container */
        .table-responsive {
            overflow-x: auto;
            margin-bottom: 24px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.03);
        }

        /* Modern Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            background: #ffffff;
            text-align: left;
        }

        th {
            background-color: #2c3e50;
            color: #ffffff;
            padding: 14px 16px;
            font-weight: 600;
            font-size: 0.95rem;
            letter-spacing: 0.5px;
        }

        td {
            padding: 14px 16px;
            border-bottom: 1px solid #eef2f5;
            color: #555;
            font-size: 0.9rem;
        }

        /* Table Row Hover Background Effect */
        tr:nth-child(even) {
            background-color: #f9fbfd;
        }

        tr:hover td {
            background-color: #f1f5f9;
            transition: background-color 0.2s ease;
        }

        /* Status Badges */
        .badge {
            padding: 6px 12px;
            border-radius: 50px;
            font-size: 0.85rem;
            font-weight: 600;
            display: inline-block;
            text-align: center;
        }

        .badge-confirmed {
            background-color: #e8f8f0;
            color: #10b981;
            border: 1px solid #a7f3d0;
        }

        .badge-cancelled {
            background-color: #fee2e2;
            color: #ef4444;
            border: 1px solid #fca5a5;
        }

        /* Back to Dashboard Button styling */
        .btn-back {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-weight: 600;
            font-size: 0.9rem;
            transition: all 0.3s ease;
            box-shadow: 0 4px 6px rgba(52, 152, 219, 0.2);
        }

        .btn-back:hover {
            background-color: #2980b9;
            transform: translateY(-2px);
            box-shadow: 0 6px 12px rgba(52, 152, 219, 0.3);
        }
    </style>
</head>
<body>

<div class="container">
    <h1>All Bookings</h1>

    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>Farmer Name</th>
                    <th>Mobile</th>
                    <th>Tractor ID</th>
                    <th>Days</th>
                    <th>Total Rent</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
                ResultSet rs = (ResultSet)request.getAttribute("bookingData");
                if (rs != null) {
                    while(rs.next()){
            %>
                <tr>
                    <td><%= rs.getInt("booking_id") %></td>
                    <td>**<%= rs.getString("farmer_name") %>**</td>
                    <td><%= rs.getString("mobile") %></td>
                    <td><%= rs.getInt("tractor_id") %></td>
                    <td><%= rs.getInt("booking_days") %></td>
                    <td><%= String.format("%.2f", rs.getDouble("total_rent")) %></td>
                    <td><%= rs.getDate("booking_date") %></td>
                    <td>
                    <%
                        String status = rs.getString("status");
                        if("Confirmed".equals(status)){
                    %>
                        <span class="badge badge-confirmed">Confirmed</span>
                    <%
                        } else {
                    %>
                        <span class="badge badge-cancelled">Cancelled</span>
                    <%
                        }
                    %>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="8" style="text-align: center; padding: 20px; color: #888;">No booking records found.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <a href="AdminDashboardServlet" class="btn-back">
        &larr; Back To Dashboard
    </a>
</div>

</body>
</html>