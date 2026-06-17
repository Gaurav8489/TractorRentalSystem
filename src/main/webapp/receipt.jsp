<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Booking" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Receipt</title>
    
    <!-- Premium Google Fonts Framework Dependencies -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&family=JetBrains+Mono:wght@500&display=swap" rel="stylesheet">

    <!-- Linking the Separated CSS File (Adjust path if it's inside a folder like css/receipt.css) -->
    <link rel="stylesheet" href="receipt.css">
</head>
<body>

<%
Booking booking = (Booking)session.getAttribute("booking");
Integer bookingId = (Integer)session.getAttribute("bookingId");
%>

<div class="receipt">
    <h1>Booking Receipt</h1>
    <hr>

    <div class="receipt-row">
        <b>Booking ID:</b>
        <span class="receipt-value id-highlight">#<%= bookingId %></span>
    </div>

    <div class="receipt-row">
        <b>Farmer ID:</b>
        <span class="receipt-value"><%= booking.getFarmerId() %></span>
    </div>

    <div class="receipt-row">
        <b>Tractor ID:</b>
        <span class="receipt-value"><%= booking.getTractorId() %></span>
    </div>

    <div class="receipt-row">
        <b>Booking Days:</b>
        <span class="receipt-value"><%= booking.getBookingDays() %> Days</span>
    </div>

    <div class="receipt-row">
        <b>Total Rent:</b>
        <span class="receipt-value" style="color: #0f172a; font-size: 1.1rem; font-weight: 700;">&#8377;<%= booking.getTotalRent() %></span>
    </div>

    <div class="receipt-row">
        <b>Booking Date:</b>
        <span class="receipt-value"><%= booking.getBookingDate() %></span>
    </div>

    <div class="receipt-row">
        <b>Status:</b>
        <span class="receipt-value status-badge">Confirmed</span>
    </div>

    <hr>

    <%
    String whatsappMessage =
    "🚜 Tractor Booking Receipt\n\n" +
    "• Booking ID : " + bookingId + "\n" +
    "• Tractor ID : " + booking.getTractorId() + "\n" +
    "• Booking Days : " + booking.getBookingDays() + "\n" +
    "• Total Rent : ₹" + booking.getTotalRent() + "\n" +
    "• Booking Date : " + booking.getBookingDate() + "\n\n" +
    "Status : Confirmed ✅";
    %>

    <div class="action-container">
        <!-- WhatsApp API Action Redirector Link -->
        <a class="btn-action btn-whatsapp" target="_blank"
           href="https://wa.me/?text=<%= java.net.URLEncoder.encode(whatsappMessage, "UTF-8") %>">
           📲 Share Receipt On WhatsApp
        </a>

        <!-- Servlet Core Target Download PDF Action Trigger Link -->
        <a class="btn-action btn-download" href="DownloadPDFServlet">
           📥 Download Receipt PDF
        </a>

        <!-- Home Application Dashboard Navigation Return Link Link -->
        <a class="btn-action btn-dashboard" href="dashboard.jsp">
           ↩ Back To Dashboard
        </a>
    </div>
</div>

</body>
</html>