package servlet;

import java.io.IOException;

import dao.AdminDAO;
import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        AdminDAO dao = new AdminDAO();

        request.setAttribute(
                "totalFarmers",
                
                dao.getTotalFarmers());

        request.setAttribute(
                "totalTractors",
                dao.getTotalTractors());

        request.setAttribute(
                "totalBookings",
                dao.getTotalBookings());
        
        request.setAttribute(
                "totalRevenue",
                dao.getTotalRevenue());

        TractorDAO tractorDAO =
                new TractorDAO();

        int availableTractors =
                tractorDAO.getAvailableTractorCount();

        int bookedTractors =
                tractorDAO.getBookedTractorCount();

        request.setAttribute(
                "availableTractors",
                availableTractors);

        request.setAttribute(
                "bookedTractors",
                bookedTractors);

        request.getRequestDispatcher(
                "admindashboard.jsp")
                .forward(request, response);
    }
}