package servlet;

import java.io.IOException;

import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Farmer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String mobile =
                request.getParameter("mobile");

        String password =
                request.getParameter("password");

        FarmerDAO dao =
                new FarmerDAO();

        boolean status =
                dao.loginFarmer(mobile, password);

        if(status) {

            Farmer farmer =
                    dao.getFarmerByMobile(mobile);

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "mobile",
                    mobile);

            session.setAttribute(
                    "farmerName",
                    farmer.getFarmerName());

            response.sendRedirect(
                    "dashboard.jsp");

        }else {


response.sendRedirect(
        "login.html?error=1");


}

    }
}