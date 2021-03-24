import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.io.IOException;

@WebServlet("/StoreList")

public class StoreList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<StoreInfo> stores = new ArrayList<StoreInfo>();
        try{
            stores=SqlQueries.SelectStoreInfo();
        }catch(Exception e){
            System.out.println(e);
        }

        request.setAttribute("storez", stores);
        request.getRequestDispatcher("Store.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String storeloc = request.getParameter("storeSelection");
        String storeid = request.getParameter("stid");
        String storeadd = request.getParameter("stadd");
        String storezip = request.getParameter("stzip");
        // Utilities utility = new Utilities(request);
        OrdersHashMap.orders.clear();

        HttpSession session = request.getSession(true);
        session.setAttribute("sid", storeid);
        session.setAttribute("storeLocation", storeloc);
        session.setAttribute("stozip", storezip);
        session.setAttribute("storeaddress", storeadd);
        response.sendRedirect("index.jsp");
    }
}