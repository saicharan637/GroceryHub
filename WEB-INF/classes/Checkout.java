import java.util.HashMap;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;


@WebServlet("/Checkout")
public class Checkout extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String ot = request.getParameter("orderTotal");
        System.out.println(ot);
        double orderTotal = Double.parseDouble(ot);

        Utilities utility = new Utilities(request);
        if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Session Timed out. Please try again");
			response.sendRedirect("ErrorLogin.jsp");
			return;
        }
        // String username = utility.username();

        ArrayList<StoreInfo> stores = new ArrayList<StoreInfo>();
        try{
            stores=SqlQueries.SelectStoreInfo();
        }catch(Exception e){
            System.out.println(e);
        }

        ArrayList<OrderItem> orderitem = new ArrayList<OrderItem>();
        orderitem = utility.getCustomerOrders();

        // double total = 0;
        request.setAttribute("storez", stores);    
        request.setAttribute("orders", orderitem);
        request.setAttribute("orderTotal", orderTotal);

        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    
    }
}