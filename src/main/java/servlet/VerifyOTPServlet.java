package servlet;

import java.io.IOException;

import dao.BookingDAO;
import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Booking;

@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session =
            request.getSession(false);

    if(session == null) {

        response.sendRedirect("login.html");
        return;
    }

    int enteredOTP =
            Integer.parseInt(
            request.getParameter("otp"));

    int originalOTP =
            (Integer) session.getAttribute("otp");

    if(enteredOTP == originalOTP) {

        Booking booking =
                (Booking) session.getAttribute("booking");

        BookingDAO dao =
                new BookingDAO();

        TractorDAO tractorDAO =
                new TractorDAO();

        // Tractor exists check
        if(!tractorDAO.isTractorExists(
                booking.getTractorId())) {

            response.getWriter().println(
            "<h2 style='color:red;text-align:center;'>Invalid Tractor ID</h2>");

            return;
        }

        boolean status =
                dao.bookTractor(booking);

        if(status) {

            tractorDAO.updateStatus(
                    booking.getTractorId());

            int bookingId =
                    dao.getLastBookingId();

            session.setAttribute(
                    "bookingId",
                    bookingId);

            response.sendRedirect(
                    "receipt.jsp");

        } else {

            response.getWriter().println(
                    "<h2>Booking Failed</h2>");
        }

    } else {

        response.getWriter().println(
        "<h2 style='color:red;'>Invalid OTP</h2>");

        response.getWriter().println(
        "<a href='otp.jsp'>Try Again</a>");
    }
}


}
