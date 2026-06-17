package servlet;

import java.io.File;
import java.io.IOException;

import dao.TractorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Tractor;

@WebServlet("/AddTractorServlet")
@MultipartConfig
public class AddTractorServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String tractorName =
            request.getParameter("tractorName");

    String model =
            request.getParameter("model");

    double rentPerDay =
            Double.parseDouble(
            request.getParameter("rentPerDay"));

    String status =
            request.getParameter("status");

    Part imagePart =
            request.getPart("image");

    String imageName =
            imagePart.getSubmittedFileName();
    
    System.out.println(
            "IMAGE NAME = "
            + imageName);

    String uploadPath =
            getServletContext()
            .getRealPath("")
            + "tractorimages";

    File folder =
            new File(uploadPath);

    if(!folder.exists()) {
        folder.mkdir();
    }

    imagePart.write(
            uploadPath
            + File.separator
            + imageName);

    Tractor tractor =
            new Tractor(
                    tractorName,
                    model,
                    rentPerDay,
                    status,
                    imageName);

    tractor.setImageName(
            imageName);

    TractorDAO dao =
            new TractorDAO();

    boolean result =
            dao.addTractor(tractor);

    if(result) {

        response.sendRedirect(
                "ViewTractorServlet");

    } else {

        response.getWriter()
                .println(
                "Tractor Not Added");
    }
}


}
	