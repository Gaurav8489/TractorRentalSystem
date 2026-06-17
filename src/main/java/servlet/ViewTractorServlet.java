package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewTractorServlet")
public class ViewTractorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TractorDAO dao =
                    new TractorDAO();

            ResultSet rs =
                    dao.getAllTractors();

            request.setAttribute(
                    "tractorData",
                    rs);

            request.getRequestDispatcher(
                    "viewtractors.jsp")
                    .forward(request,
                             response);

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}