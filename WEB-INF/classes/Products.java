import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

@WebServlet("/Products")

public class Products extends HttpServlet {

    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("pname");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String image = request.getParameter("image");
        String disc = request.getParameter("disc");
        String noofitems = request.getParameter("noofitems");
        String weight = request.getParameter("weight");

     //   System.out.println("the name is"+name);
       // System.out.println("the image is"+image);



        request.setAttribute("name1", name);
        request.setAttribute("price1", price);
        request.setAttribute("category1", category);
        request.setAttribute("image1", image);
        request.setAttribute("disc1", disc);
        request.setAttribute("noofitems1", noofitems);
        request.setAttribute("weight1", weight);

        HashMap<String, ArrayList<Review>> hm= MongoDBDataStoreUtilities.selectReview();
        request.setAttribute("hm", hm);
        //System.out.println("the HashMap is :"+hm);
        request.getRequestDispatcher("shop-details.jsp").forward(request, response);
    }
}