package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewFarmersServlet")
public class ViewFarmersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            FarmerDAO dao =
                    new FarmerDAO();

            ResultSet rs =
                    dao.getAllFarmers();

            request.setAttribute(
                    "farmerData",
                    rs);

            request.getRequestDispatcher(
                    "viewfarmers.jsp")
                    .forward(request,
                             response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}