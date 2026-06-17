package servlet;

import java.io.IOException;

import dao.BookingDAO;
import dao.FarmerDAO;
import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Booking;
import java.time.LocalDate;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String mobile =
                (String) session.getAttribute("mobile");

        if (mobile == null) {

            response.sendRedirect("login.html");
            return;
        }

        int tractorId =
                Integer.parseInt(
                request.getParameter("tractorId"));

        int days =
                Integer.parseInt(
                request.getParameter("days"));

        TractorDAO tractorDAO =
                new TractorDAO();

        double rentPerDay =
                tractorDAO.getRentPerDay(tractorId);

        double totalRent =
                days * rentPerDay;

        FarmerDAO farmerDAO =
                new FarmerDAO();

        int farmerId =
                farmerDAO.getFarmerIdByMobile(mobile);
        
        String bookingDate =
                LocalDate.now().toString();
        
        System.out.println("Days = " + days);
        System.out.println("Rent Per Day = " + rentPerDay);
        System.out.println("Total Rent = " + totalRent);

        Booking booking =
                new Booking(
                        tractorId,
                        days,
                        totalRent,
                        farmerId,
                        bookingDate);

        session.setAttribute(
                "booking",
                booking);

        int otp =
                (int)(Math.random() * 9000)
                + 1000;

        session.setAttribute(
                "otp",
                otp);

        System.out.println(
                "Generated OTP = "
                + otp);

        response.sendRedirect(
                "otp.jsp");
    }
}