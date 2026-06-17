package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchTractorServlet")
public class SearchTractorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String tractorName =
                    request.getParameter("tractorName");

            TractorDAO dao =
                    new TractorDAO();

            ResultSet rs =
                    dao.searchTractor(tractorName);

            request.setAttribute(
                    "tractorData",
                    rs);

            request.getRequestDispatcher(
                    "searchresult.jsp")
                    .forward(request,
                             response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}