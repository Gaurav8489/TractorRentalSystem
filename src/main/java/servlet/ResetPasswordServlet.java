package servlet;

import java.io.IOException;

import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet
extends HttpServlet {


protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session =
            request.getSession(false);

    int enteredOtp =
            Integer.parseInt(
            request.getParameter("otp"));

    int originalOtp =
            (Integer) session.getAttribute(
                    "forgotOtp");

    String password =
            request.getParameter(
                    "password");

    String confirmPassword =
            request.getParameter(
                    "confirmPassword");

    if(enteredOtp != originalOtp) {

        response.getWriter().println(
                "<h2>Invalid OTP</h2>");

        return;
    }

    if(!password.equals(
            confirmPassword)) {

        response.getWriter().println(
                "<h2>Passwords Do Not Match</h2>");

        return;
    }

    String mobile =
            (String) session.getAttribute(
                    "mobile");

    FarmerDAO dao =
            new FarmerDAO();

    boolean status =
            dao.updatePassword(
                    mobile,
                    password);

    if(status) {

        response.getWriter().println(
                "<h2>Password Updated Successfully</h2>");

        response.getWriter().println(
                "<a href='login.html'>Login Now</a>");

    } else {

        response.getWriter().println(
                "<h2>Password Update Failed</h2>");
    }
}


}
