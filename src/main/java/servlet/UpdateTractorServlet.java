package servlet;

import java.io.IOException;

import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTractorServlet")
public class UpdateTractorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int tractorId = Integer.parseInt(request.getParameter("tractorId"));
        double rentPerDay = Double.parseDouble(request.getParameter("rentPerDay"));
        String status = request.getParameter("status");

        TractorDAO dao = new TractorDAO();
        boolean result = dao.updateTractor(tractorId, rentPerDay, status);

        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        // कॉमन CSS जे यशस्वी आणि अयशस्वी दोन्ही कार्ड्सना सारखे डिझाइन देईल
        String css = "<style>"
                + "body {"
                + "  min-height: 100vh; display: flex; justify-content: center; align-items: center;"
                + "  font-family: 'Segoe UI', sans-serif; background-color: #0b130e; margin: 0;"
                + "  background-image: url('https://images.unsplash.com/photo-1594142394141-8608d81023d5?q=80&w=1920');"
                + "  background-size: cover; background-position: center; position: relative;"
                + "}"
                + "body::before {"
                + "  content: ''; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"
                + "  background: rgba(0, 0, 0, 0.6); backdrop-filter: blur(5px); z-index: 1;"
                + "}"
                + ".card {"
                + "  background: rgba(255, 255, 255, 0.08); border: 1px solid rgba(255, 255, 255, 0.15);"
                + "  padding: 40px; border-radius: 20px; box-shadow: 0 20px 50px rgba(0,0,0,0.5);"
                + "  text-align: center; max-width: 400px; width: 90%; z-index: 2;"
                + "  animation: popUp 0.5s cubic-bezier(0.175, 0.885, 0.32, 1.275);"
                + "}"
                + ".icon { font-size: 4rem; margin-bottom: 15px; }"
                + "h2 { color: #ffffff; margin-bottom: 20px; font-size: 1.8rem; text-transform: uppercase; letter-spacing: 1px; }"
                + ".btn {"
                + "  display: inline-block; padding: 12px 24px; text-decoration: none; font-weight: 700;"
                + "  border-radius: 10px; text-transform: uppercase; letter-spacing: 1px; transition: all 0.3s;"
                + "}"
                + ".btn-success { background: linear-gradient(135deg, #2ecc71, #27ae60); color: white; box-shadow: 0 5px 15px rgba(39,174,96,0.4); }"
                + ".btn-success:hover { background: linear-gradient(135deg, #27ae60, #219653); transform: translateY(-2px); }"
                + ".btn-fail { background: linear-gradient(135deg, #e74c3c, #c0392b); color: white; box-shadow: 0 5px 15px rgba(231,76,60,0.4); }"
                + ".btn-fail:hover { background: linear-gradient(135deg, #c0392b, #b03a2e); transform: translateY(-2px); }"
                + "@keyframes popUp { from { opacity: 0; transform: scale(0.8); } to { opacity: 1; transform: scale(1); } }"
                + "</style>";

        out.println("<html><head>" + css + "</head><body>");

        if(result) {
            // यशस्वी झाल्यावर हिरवा (Green) मेसेज कार्ड
            out.println("<div class='card'>"
                    + "  <div class='icon'>✅</div>"
                    + "  <h2>Tractor Updated Successfully</h2>"
                    + "  <a href='admindashboard.html' class='btn btn-success'>Back to Dashboard</a>"
                    + "</div>");
        } else {
            // फेल झाल्यावर लाल (Red) मेसेज कार्ड
            out.println("<div class='card'>"
                    + "  <div class='icon'>❌</div>"
                    + "  <h2 style='text-shadow: 0 0 10px rgba(231,76,60,0.5);'>Update Failed</h2>"
                    + "  <a href='javascript:history.back()' class='btn btn-fail'>Try Again</a>"
                    + "</div>");
        }

        out.println("</body></html>");
    }
}