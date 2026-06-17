package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import dao.BookingDAO;
import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyBookingServlet")
public class MyBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();

            String mobile =
                    (String) session.getAttribute("mobile");

            // login check
            if (mobile == null) {
                response.sendRedirect("login.html");
                return;
            }

            // farmer id get
            FarmerDAO farmerDAO = new FarmerDAO();

            int farmerId =
                    farmerDAO.getFarmerIdByMobile(mobile);

            // only that farmer bookings
            BookingDAO dao = new BookingDAO();

            ResultSet rs =
                    dao.getBookingsByFarmerId(farmerId);

            request.setAttribute("bookingData", rs);

            request.getRequestDispatcher("mybookings.jsp")
                   .forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}