package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import dao.BookingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllBookingsServlet")
public class ViewAllBookingsServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BookingDAO dao =
                new BookingDAO();

        ResultSet rs =
                dao.getAllBookings();

        request.setAttribute(
                "bookingData",
                rs);

        request.getRequestDispatcher(
                "viewallbookings.jsp")
                .forward(
                        request,
                        response);
    }
}