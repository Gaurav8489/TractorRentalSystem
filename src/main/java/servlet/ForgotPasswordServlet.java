package servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String mobile =
            request.getParameter("mobile");

    Random random =
            new Random();

    int otp =
            1000 + random.nextInt(9000);

    HttpSession session =
            request.getSession();

    session.setAttribute(
            "forgotOtp",
            otp);

    session.setAttribute(
            "mobile",
            mobile);

    System.out.println(
            "Forgot Password OTP = "
            + otp);

    response.sendRedirect(
            "resetotp.jsp");
}

}
