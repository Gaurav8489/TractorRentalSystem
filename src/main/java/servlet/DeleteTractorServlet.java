package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteTractorServlet")
public class DeleteTractorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int tractorId = Integer.parseInt(request.getParameter("tractorId"));
        TractorDAO dao = new TractorDAO();
        boolean result = dao.deleteTractor(tractorId);

        // Injecting the awesome mixed color background and custom layout
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Delete Status</title>");
        out.println("<style>");
        
        // --- INJECTED CSS ---
        out.println("body {");
        out.println("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("    background: linear-gradient(-45deg, #0b2545, #134074, #007f5f, #2b9348);");
        out.println("    background-size: 400% 400%;");
        out.println("    animation: gradientShift 12s ease infinite;");
        out.println("    color: #fff;");
        out.println("    margin: 0;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    min-height: 100vh;");
        out.println("}");
        
        out.println("@keyframes gradientShift {");
        out.println("    0% { background-position: 0% 50%; }");
        out.println("    50% { background-position: 100% 50%; }");
        out.println("    100% { background-position: 0% 50%; }");
        out.println("}");
        
        out.println(".container {");
        out.println("    background: rgba(255, 255, 255, 0.12);");
        out.println("    backdrop-filter: blur(12px);");
        out.println("    -webkit-backdrop-filter: blur(12px);");
        out.println("    border: 1px solid rgba(255, 255, 255, 0.2);");
        out.println("    padding: 40px;");
        out.println("    border-radius: 20px;");
        out.println("    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.3);");
        out.println("    text-align: center;");
        out.println("    max-width: 400px;");
        out.println("    width: 100%;");
        out.println("    animation: cardAppear 0.5s ease-out;");
        out.println("}");
        
        out.println("@keyframes cardAppear {");
        out.println("    from { opacity: 0; transform: translateY(20px); }");
        out.println("    to { opacity: 1; transform: translateY(0); }");
        out.println("}");
        
        out.println(".icon { font-size: 4rem; margin-bottom: 15px; }");
        
        out.println("h2 { margin: 0 0 20px 0; font-size: 1.8rem; text-shadow: 0 2px 4px rgba(0,0,0,0.2); }");
        
        out.println("a {");
        out.println("    display: inline-block;");
        out.println("    background: #ffffff;");
        out.println("    color: #134074;");
        out.println("    text-decoration: none;");
        out.println("    padding: 12px 30px;");
        out.println("    border-radius: 10px;");
        out.println("    font-weight: 700;");
        out.println("    transition: all 0.3s ease;");
        out.println("    box-shadow: 0 4px 15px rgba(0,0,0,0.2);");
        out.println("}");
        
        out.println("a:hover {");
        out.println("    background: #134074;");
        out.println("    color: #fff;");
        out.println("    transform: translateY(-2px);");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='container'>");
        
        // Dynamically changes UI elements depending on success or failure
        if (result) {
            out.println("<div class='icon'>✅</div>");
            out.println("<h2>Tractor Deleted Successfully</h2>");
        } else {
            out.println("<div class='icon'>❌</div>");
            out.println("<h2>Tractor Not Found</h2>");
        }
        
        // Redirect back to the dashboard or tractor list page
        out.println("<a href='AdminDashboardServlet'>Back To Dashboard</a>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");
    }
}