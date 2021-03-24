import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/Analytics")

public class Analytics extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<MostSoldProducts> mostsold = new ArrayList<MostSoldProducts>();
        ArrayList<LatestProducts> latest = new ArrayList<LatestProducts>();
        ArrayList<Bestrating> bestrated = new ArrayList<Bestrating> ();
        try{
            mostsold=SqlQueries.SelectMostSoldProducts();
            latest=SqlQueries.SelectLatestProducts();
            bestrated=MongoDBDataStoreUtilities.topProducts();
        }catch(Exception e){
            System.out.println("the exception in Analytics is "+e);
        }
        
        RequestDispatcher dispatcher;
        request.setAttribute("bestrated",bestrated);
        request.setAttribute("latest",latest);
        request.setAttribute("mostsold",mostsold);
        System.out.println("the bestrated is "+bestrated);
        System.out.println("the latest is "+latest);
        System.out.println("the MostSoldProducts is "+mostsold);

        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }
}