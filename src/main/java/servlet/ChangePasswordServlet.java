package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import dao.FarmerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        String mobile = (String) session.getAttribute("mobile");

        if (mobile == null) {
            response.sendRedirect("login.html");
            return;
        }

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!newPassword.equals(confirmPassword)) {
            showResponsePage(response, "❌ Error", "Passwords do not match", "कृपया दोन्ही पासवर्ड सारखे टाका.", "error");
            return;
        }

        FarmerDAO dao = new FarmerDAO();
        boolean result = dao.changePassword(mobile, oldPassword, newPassword);

        if (result) {
            showResponsePage(response, "🎉 Success", "Password Changed Successfully", "तुमचा पासवर्ड यशस्वीरीत्या बदलला गेला आहे.", "success");
        } else {
            showResponsePage(response, "❌ Error", "Old Password Incorrect", "कृपया तुमचा जुना पासवर्ड तपासा आणि पुन्हा प्रयत्न करा.", "error");
        }
    }

    private void showResponsePage(HttpServletResponse response, String status, String title, String message, String type) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String icon = type.equals("success") ? "✅" : "⚠️";
        String accentColor = type.equals("success") ? "#00c853" : "#e74c3c";
        String hoverColor = type.equals("success") ? "#1b5e20" : "#c0392b";

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>" + status + "</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body, html { margin: 0; padding: 0; width: 100%; min-height: 100vh; font-family: 'Poppins', sans-serif; }");
        out.println("body { background: url('img/adb.png') no-repeat center center fixed; background-size: cover; display: flex; justify-content: center; align-items: center; padding: 20px; box-sizing: border-box; }");
        out.println(".card-container { background: rgba(0, 0, 0, 0.45); backdrop-filter: blur(15px); -webkit-backdrop-filter: blur(15px); border: 1px solid rgba(255, 255, 255, 0.18); padding: 40px; border-radius: 20px; box-shadow: 0 15px 35px rgba(0, 0, 0, 0.4); text-align: center; max-width: 420px; width: 100%; box-sizing: border-box; animation: cardAppear 0.5s ease-out; }");
        out.println("@keyframes cardAppear { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }");
        out.println(".icon { font-size: 4rem; margin-bottom: 15px; text-shadow: 0 4px 10px rgba(0,0,0,0.3); }");
        out.println("h2 { margin: 0 0 10px 0; font-size: 1.8rem; color: #fff; text-shadow: 0 2px 4px rgba(0,0,0,0.5); }");
        out.println("p { margin: 0 0 25px 0; color: #ddd; font-size: 0.95rem; text-shadow: 0 1px 2px rgba(0,0,0,0.4); }");
        out.println("a { display: inline-block; background: " + accentColor + "; color: #fff; text-decoration: none; padding: 12px 35px; border-radius: 30px; font-weight: 600; letter-spacing: 0.5px; border: 1px solid transparent; transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }");
        out.println("a:hover { background: " + hoverColor + "; transform: translateY(-3px); box-shadow: 0 8px 20px " + accentColor + "80; border-color: rgba(255,255,255,0.2); }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='card-container'>");
        out.println("<div class='icon'>" + icon + "</div>");
        out.println("<h2>" + title + "</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='dashboard.jsp'>Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}