package servlet;

import java.io.IOException;

import dao.BookingDAO;
import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId =
                Integer.parseInt(
                request.getParameter("bookingId"));

        BookingDAO dao =
                new BookingDAO();

        int tractorId =
                dao.getTractorIdByBookingId(
                        bookingId);

        boolean result =
                dao.cancelBooking(
                        bookingId);

        if(result) {

            TractorDAO tractorDAO =
                    new TractorDAO();

            tractorDAO.makeAvailable(
                    tractorId);

            response.sendRedirect(
                    "MyBookingServlet");

        } else {

            response.getWriter()
                    .println(
                            "<h2>Cancel Failed</h2>");
        }
    }
}