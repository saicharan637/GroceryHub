import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Formatter;


@WebServlet("/Cart")

public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* From the HttpServletRequest variable name,type,maker and acessories information are obtained.*/
        Utilities utility = new Utilities(request);
        if(!utility.isLoggedin()){
            HttpSession session = request.getSession(true);             
            session.setAttribute("login_msg", "Please Login to add items to cart");
            response.sendRedirect("ErrorLogin.jsp");
            return;
        }

        String name = request.getParameter("prodname");
        String type = request.getParameter("prodcat");
        String q = request.getParameter("quant");

        // System.out.println(z);
        int quant = Integer.parseInt(q);

        boolean isInCart = false;

        String us=utility.username();
        ArrayList<OrderItem> list = OrdersHashMap.orders.get(us);
        if(list != null){
            for(int i=0;i<list.size();i++){
                if(list.get(i).getName().equalsIgnoreCase(name)){
                    isInCart = true;
                    break;
                }
            }
            if(isInCart){
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getName().equalsIgnoreCase(name)){
                            list.get(i).setQuant(list.get(i).getQuant()+quant);
                        }
            }
                }else{
                    utility.storeProduct(name, type,quant);  
                }
            }else{
                utility.storeProduct(name, type,quant);
            }

        /* StoreProduct Function stores the Purchased product in Orders HashMap.*/
        // utility.storeProduct(name, type,quant);  
        displayCart(request, response);
    }

    protected void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilities utility = new Utilities(request);
       
        int cartCount = utility.CartCount();
        if(cartCount>0)
        {

            ArrayList<OrderItem> orderitem = new ArrayList<OrderItem>();
            double total = 0;
            orderitem = utility.getCustomerOrders();
            for (OrderItem oi : utility.getCustomerOrders()) 
            {   
                total = total +oi.getPrice()*oi.getQuant();
            }
            Formatter fmt = new Formatter();
            fmt.format("%.2f", total);

            request.setAttribute("orders", orderitem);
            request.setAttribute("total", fmt);
            request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }
    else{
        // HttpSession session = request.getSession(true);              
        request.setAttribute("cartempty","Your Cart is empty!!");
        request.getRequestDispatcher("CartEmpty.jsp").forward(request, response);
    }
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    Utilities utility = new Utilities(request);
    if(!utility.isLoggedin()){
        HttpSession session = request.getSession(true);             
        session.setAttribute("login_msg", "Please Login/Create an Account");
        response.sendRedirect("ErrorLogin.jsp");
        return;
    }
    
    displayCart(request, response);
}
}
