package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dao.BookingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DownloadPDFServlet")
public class DownloadPDFServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("application/pdf");

    response.setHeader(
            "Content-Disposition",
            "attachment; filename=BookingReceipt.pdf");

    try {

        BookingDAO dao =
                new BookingDAO();

        int bookingId =
                dao.getLastBookingId();

        ResultSet rs =
                dao.getReceiptDetails(bookingId);

        Document document =
                new Document();

        PdfWriter.getInstance(
                document,
                response.getOutputStream());

        document.open();

        if(rs.next()) {

            document.add(
                    new Paragraph(
                    "🚜 TRACTOR BOOKING RECEIPT"));

            document.add(
                    new Paragraph(
                    "================================"));

            document.add(
                    new Paragraph(
                    "Booking ID : "
                    + rs.getInt("booking_id")));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                    "Farmer Name : "
                    + rs.getString("farmer_name")));

            document.add(
                    new Paragraph(
                    "Mobile : "
                    + rs.getString("mobile")));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                    "Tractor ID : "
                    + rs.getInt("tractor_id")));

            document.add(
                    new Paragraph(
                    "Tractor Name : "
                    + rs.getString("tractor_name")));

            document.add(
                    new Paragraph(
                    "Model : "
                    + rs.getString("model")));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                    "Booking Days : "
                    + rs.getInt("booking_days")));

            document.add(
                    new Paragraph(
                    "Rent Per Day : ₹"
                    + rs.getDouble("rent_per_day")));

            document.add(
                    new Paragraph(
                    "Total Rent : ₹"
                    + rs.getDouble("total_rent")));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                    "Booking Date : "
                    + rs.getDate("booking_date")));

            document.add(
                    new Paragraph(
                    "Status : "
                    + rs.getString("status")));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                    "Thank You For Using Tractor Rental System"));
        }

        document.close();

    } catch(Exception e) {

        e.printStackTrace();
    }
}


}
