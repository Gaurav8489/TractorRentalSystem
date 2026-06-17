<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
ResultSet rs = (ResultSet) request.getAttribute("tractorData");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium Tractor Inventory</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        /* Advanced CSS Variables for Easy Theming */
        :root {
            --primary-grad: linear-gradient(135deg, #1e4620 0%, #2e7d32 100%);
            --bg-mesh: radial-gradient(at 0% 0%, rgba(244, 247, 246, 1) 0, transparent 50%),
                       radial-gradient(at 50% 0%, rgba(232, 245, 233, 0.7) 0, transparent 50%),
                       radial-gradient(at 100% 0%, rgba(200, 230, 201, 0.5) 0, transparent 50%);
            --card-bg: rgba(255, 255, 255, 0.85);
            --text-main: #2d3748;
            --text-muted: #718096;
            --border-color: rgba(226, 232, 240, 0.8);
            --radius-lg: 16px;
            --radius-sm: 8px;
            --transition-smooth: all 0.4s cubic-bezier(0.16, 1, 0.3, 1);
        }

        body {
            background-color: #f4f7f6;
            background-image: var(--bg-mesh);
            background-attachment: fixed;
            font-family: 'Inter', system-ui, -apple-system, sans-serif;
            color: var(--text-main);
            min-height: 100vh;
        }

        /* Modern Dashboard Header */
        .page-title {
            font-weight: 800;
            background: var(--primary-grad);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            letter-spacing: -1px;
            position: relative;
            display: inline-block;
        }
        
        .page-title::after {
            content: '';
            position: absolute;
            bottom: -6px;
            left: 50%;
            transform: translateX(-50%);
            width: 50px;
            height: 4px;
            background: var(--primary-grad);
            border-radius: 10px;
        }

        /* Glassmorphic Table Container */
        .table-container {
            background: var(--card-bg);
            backdrop-filter: blur(20px);
            -webkit-backdrop-filter: blur(20px);
            border-radius: var(--radius-lg);
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.04), 
                        0 1px 3px rgba(0, 0, 0, 0.02);
            padding: 24px;
            border: 1px solid rgba(255, 255, 255, 0.6);
            transition: var(--transition-smooth);
        }

        /* Responsive Table Scrollbar styling */
        .table-responsive::-webkit-scrollbar {
            height: 6px;
        }
        .table-responsive::-webkit-scrollbar-thumb {
            background: rgba(0,0,0,0.1);
            border-radius: 10px;
        }

        /* Advanced Table Overrides */
        .table {
            vertical-align: middle;
            margin-bottom: 0;
            border-collapse: separate;
            border-spacing: 0 8px; /* Creates clean separated row styling */
        }

        .table thead th {
            background: transparent !important;
            color: var(--text-muted);
            font-weight: 700;
            text-transform: uppercase;
            font-size: 0.75rem;
            letter-spacing: 1px;
            padding: 16px;
            border: none;
        }

        /* Advanced Row Micro-interactions */
        .table tbody tr {
            background: #ffffff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.01);
            border-radius: var(--radius-sm);
            transition: var(--transition-smooth);
        }

        .table tbody tr:hover {
            transform: translateY(-3px) scale(1.005);
            box-shadow: 0 12px 20px rgba(46, 125, 50, 0.08);
            background: #ffffff !important;
        }

        .table td {
            padding: 16px;
            border-top: 1px solid var(--border-color);
            border-bottom: 1px solid var(--border-color);
            transition: var(--transition-smooth);
        }
        
        /* Rounding row corners cleanly since border-spacing is active */
        .table td:first-child { 
            border-left: 1px solid var(--border-color);
            border-top-left-radius: var(--radius-sm); 
            border-bottom-left-radius: var(--radius-sm); 
        }
        .table td:last-child { 
            border-right: 1px solid var(--border-color);
            border-top-right-radius: var(--radius-sm); 
            border-bottom-right-radius: var(--radius-sm); 
        }

        /* Advanced Image Zoom & Frame */
        .tractor-img-container {
            position: relative;
            overflow: hidden;
            border-radius: var(--radius-sm);
            width: 100px;
            height: 68px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.06);
        }

        .tractor-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transform: scale(1);
            transition: var(--transition-smooth);
        }

        .table tr:hover .tractor-img {
            transform: scale(1.15);
        }

        /* Typography Customization */
        .tractor-id {
            font-size: 0.85rem;
            font-weight: 700;
            color: #94a3b8;
            background: #f8fafc;
            padding: 4px 8px;
            border-radius: 6px;
        }

        .tractor-name {
            font-size: 1rem;
            font-weight: 600;
            color: #1e293b;
        }

        .price-tag {
            font-weight: 700;
            color: #1e4620;
            font-size: 1.05rem;
        }

        /* Advanced Soft Glowing Badges */
        .badge-custom {
            padding: 6px 14px;
            font-weight: 600;
            font-size: 0.8rem;
            border-radius: 100px;
            display: inline-flex;
            align-items: center;
            gap: 6px;
        }
        
        .badge-custom::before {
            content: '';
            width: 6px;
            height: 6px;
            border-radius: 50%;
        }

        .status-available {
            background-color: #e6f4ea;
            color: #137333;
        }
        .status-available::before { background-color: #137333; }
        
        .status-rented {
            background-color: #fce8e6;
            color: #c5221f;
        }
        .status-rented::before { background-color: #c5221f; }
        
        /* 🔙 Back to Dashboard Button */
a {
  display: block;
  text-align: center;
  margin-top: 15px;
  padding: 10px 0;
  width: 100%;
  background: rgba(46, 204, 113, 0.15);
  color: #00ff77;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 1px;
  border-radius: 25px;
  text-decoration: none;
  box-shadow: 0 0 15px rgba(0, 255, 119, 0.3);
  transition: all 0.3s ease;
  backdrop-filter: blur(6px);
  -webkit-backdrop-filter: blur(6px);
}

a:hover {
  background: linear-gradient(135deg, #00ff77, #00aa50);
  color: #fff;
  transform: translateY(-2px);
  box-shadow: 0 0 25px rgba(0, 255, 119, 0.6);
}
        
    </style>
</head>
<body>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-11">
            
            <div class="text-center mb-5">
                <h2 class="page-title py-1">🚜 Available Tractors</h2>
            </div>
            
            <div class="table-container">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="width: 12%;">ID</th>
                                <th style="width: 18%;">Vehicle</th>
                                <th style="width: 25%;">Tractor Name</th>
                                <th style="width: 20%;">Model</th>
                                <th style="width: 15%;">Rent Rate</th>
                                <th style="width: 10%;">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            if (rs != null) {
                                while(rs.next()){
                                    String status = rs.getString("status");
                            %>
                            <tr>
                                <td>
                                    <span class="tractor-id">#<%= rs.getInt("tractor_id") %></span>
                                </td>
                                <td>
                                    <div class="tractor-img-container">
                                        <img src="tractorimages/<%= rs.getString("image_name") %>" 
                                             class="tractor-img" alt="Tractor Machine">
                                    </div>
                                </td>
                                <td>
                                    <div class="tractor-name"><%= rs.getString("tractor_name") %></div>
                                </td>
                                <td class="text-secondary fw-medium"><%= rs.getString("model") %></td>
                                <td>
                                    <span class="price-tag">₹<%= rs.getDouble("rent_per_day") %></span>
                                    <span class="text-muted d-block" style="font-size: 0.75rem;">per day</span>
                                </td>
                                <td>
                                    <% if("Available".equalsIgnoreCase(status) || "Active".equalsIgnoreCase(status)) { %>
                                        <span class="badge-custom status-available">Available</span>
                                    <% } else { %>
                                        <span class="badge-custom status-rented">Rented</span>
                                    <% } %>
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr>
                                <td colspan="6" class="text-center text-muted py-5">
                                    <div class="fs-5 fw-medium mb-1">No machinery available</div>
                                    <small>Your inventory is currently empty.</small>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    
                    <a  href="AdminDashboardServlet">
                Back To Dashboard
                  </a>
                </div>
            </div>
            
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>