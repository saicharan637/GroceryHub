import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;


@WebServlet("/SeeAllReviews")

public class SeeAllReviews extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("productlist");
        HashMap<String, ArrayList<Review>> review = new HashMap<String, ArrayList<Review>>();

        review = MongoDBDataStoreUtilities.selectReview();
        String val="";
        if(!review.containsKey(name)){
            val = "true";
        }
        request.setAttribute("val", val);
        request.setAttribute("name1", name);
        request.setAttribute("rev", review);
        request.getRequestDispatcher("AdminFindReview.jsp").forward(request, response);
    }
}