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
import model.Farmer;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            showErrorPage(response, "Session Not Found", "कृपया पुन्हा लॉगिन करा.");
            return;
        }

        String mobile = (String) session.getAttribute("mobile");
        System.out.println("Session Mobile = " + mobile);

        if (mobile == null) {
            showErrorPage(response, "Mobile Not Found In Session", "तुमचे सेशन एक्सपायर झाले आहे.");
            return;
        }

        FarmerDAO dao = new FarmerDAO();
        Farmer farmer = dao.getFarmerByMobile(mobile);
        System.out.println("Farmer Object = " + farmer);

        if (farmer == null) {
            showErrorPage(response, "Farmer Data Not Found", "तुमचा प्रोफाइल डेटाबेसमध्ये सापडला नाही.");
            return;
        }

        request.setAttribute("farmer", farmer);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    private void showErrorPage(HttpServletResponse response, String title, String message) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(-45deg, #0b2545, #134074, #007f5f, #2b9348); background-size: 400% 400%; animation: gradientShift 12s ease infinite; color: #fff; margin: 0; display: flex; justify-content: center; align-items: center; min-height: 100vh; }");
        out.println("@keyframes gradientShift { 0% { background-position: 0% 50%; } 50% { background-position: 100% 50%; } 100% { background-position: 0% 50%; } }");
        out.println(".error-card { background: rgba(255, 255, 255, 0.12); backdrop-filter: blur(12px); -webkit-backdrop-filter: blur(12px); border: 1px solid rgba(255, 255, 255, 0.2); padding: 40px; border-radius: 20px; box-shadow: 0 15px 35px rgba(0, 0, 0, 0.3); text-align: center; max-width: 400px; width: 100%; }");
        out.println(".icon { font-size: 4rem; margin-bottom: 15px; }");
        out.println("h2 { margin: 0 0 10px 0; font-size: 1.6rem; }");
        out.println("p { margin: 0 0 25px 0; color: #ddd; font-size: 0.95rem; }");
        out.println("a { display: inline-block; background: #ffffff; color: #134074; text-decoration: none; padding: 12px 30px; border-radius: 10px; font-weight: 700; transition: all 0.3s ease; }");
        out.println("a:hover { background: #134074; color: #fff; transform: translateY(-2px); }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='error-card'>");
        out.println("<div class='icon'>⚠️</div>");
        out.println("<h2>" + title + "</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='login.html'>Login Page</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}