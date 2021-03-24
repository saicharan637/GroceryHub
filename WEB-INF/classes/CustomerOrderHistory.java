import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;

@WebServlet("/CustomerOrderHistory")

public class CustomerOrderHistory extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilities utility = new Utilities(request);
        if(!utility.isLoggedin()){
            HttpSession session = request.getSession(true);             
            session.setAttribute("login_msg", "Session Timed out. Please try again");
            response.sendRedirect("ErrorLogin.jsp");
            return;
        }
        displayAccount(request, response);
    }

    /* Display Account Details of the Customer (Name and Usertype) */

    protected void displayAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilities utility = new Utilities(request);
        User user=utility.getUser();
        String uname = utility.username();
        HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
        try{
            if(uname.equals("s1")||uname.equals("s2")||uname.equals("s3")||uname.equals("s4")||uname.equals("s5")){orderPayments=SqlQueries.selecStoreOrder(uname);}
            else{orderPayments=SqlQueries.selectOrder();}
        }
        catch(Exception e)
        {
            System.out.println("it exists here"+e);

        }
        int size=0;
        for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet())
        {
            for(OrderPayment od:entry.getValue())   
            if(od.getUserName().equals(user.getUserName()))
            size= size+1;
        }
        if(size>0){
            request.setAttribute("uname", uname);
            request.setAttribute("orders", orderPayments);
        }
        else
        {
            String error_msg = "true";
            request.setAttribute("no_order", error_msg);
        }
        // request.setAttribute("uname", uname);
        // request.setAttribute("orders", orderPayments);
        request.getRequestDispatcher("OrderHistory.jsp").forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilities utility = new Utilities(request);
        if(!utility.isLoggedin()){
            HttpSession session = request.getSession(true);             
            session.setAttribute("login_msg", "Session Timed out. Please try again");
            response.sendRedirect("ErrorLogin.jsp");
            return;
        }
        int OrderId = Integer.parseInt(request.getParameter("oid"));
        String name = request.getParameter("pname");

        SqlQueries.deleteOrder(OrderId, name);
        response.sendRedirect("CustomerOrderHistory");
    }

}

            
