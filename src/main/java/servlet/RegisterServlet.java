package servlet;

import java.io.IOException;

import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Farmer;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String village = request.getParameter("village");
        String password = request.getParameter("password");

        Farmer farmer =
                new Farmer(name, mobile, village, password);

        FarmerDAO dao = new FarmerDAO();

        boolean status = dao.registerFarmer(farmer);

        if(status) {

            response.sendRedirect("login.html");

        } else {

            response.getWriter()
                    .println("Registration Failed");

        }
    }
}