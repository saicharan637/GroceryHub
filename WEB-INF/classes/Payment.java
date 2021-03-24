import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


@WebServlet("/Payment")

public class Payment extends HttpServlet {
	
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Utilities utility = new Utilities(request);
            HttpSession session = request.getSession(true);				
            if(!utility.isLoggedin()){
                session.setAttribute("login_msg", "Session timed out. Please try again");
                response.sendRedirect("ErrorLogin.jsp");
                return;
        }
        
        // String saveaddress = "";
        // String deliveryType="Home Delivery";
        String orderNotes = "none";
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String apt = request.getParameter("apt");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        // if(request.getParameter("saveadd")!=null){
        //         saveaddress = request.getParameter("saveadd");
        // }
        if(request.getParameter("orderNotes")!=null){
                orderNotes = request.getParameter("orderNotes");
        }       
        String deliveryType = request.getParameter("deliveryoption");

        // if(request.getParameter("deliveryoption")!=null){
        //         deliveryType = request.getParameter("deliveryoption");
        // }
        String ccno = request.getParameter("creditcardno");
        long creditCardNo = Long.parseLong(ccno);

        String ot = request.getParameter("tot");
        double orderTotal = Double.parseDouble(ot);


        String fulladdress  = street+ "," +apt+"," +city+ "," +state+ "," + "," + zip;
        long zipcode = Long.parseLong(zip);
        long phoneno = Long.parseLong(request.getParameter("phone"));

        double productSubTotal = 0;
        String storeadd="";
        String Stozip = (String)session.getAttribute("stozip");
        int stzip;
	String sid1 = (String)session.getAttribute("sid");

        if (sid1 != null){
                storeadd = (String)session.getAttribute("storeaddress");
                stzip = Integer.parseInt(Stozip);      
        }else{
                sid1 = "1";
                storeadd="19 South LaSalle Street, Chicago, IL";
                stzip=60353;
        }

            

        LocalDate purchaseDate = LocalDate.now();
        LocalDate expectedDeliveryDate = purchaseDate.plus(2, ChronoUnit.WEEKS);
        int OrderId=utility.getOrderPaymentSize()+1;
        String username = utility.username();
        // int prodWeight = 0;

        // if(saveaddress.equals("save"))
        // {
        //     //Save user address to db 
        //     SqlQueries.SaveAddress(username,fulladdress,zipcode);
        // }

        if(deliveryType.equals("Store Pickup")){
                // String location = request.getParameter("location");
                // String [] StoreInfo = location.split("/");
                // System.out.println(StoreInfo[2]);
                // long Stzip = Long.parseLong(StoreInfo[2]);


                for (OrderItem oi : utility.getCustomerOrders()){
                        String itemId = oi.getId(); 
                        int a = oi.getStock()-oi.getQuant();
                        SqlQueries.updateQuantity(itemId, a);
        
                        productSubTotal = oi.getPrice()*oi.getQuant();
                        SqlQueries.insertOrder(OrderId, username, email, firstname, lastname, fulladdress, zipcode,creditCardNo, phoneno,orderNotes,oi.getId(), oi.getName(), oi.getPrice(), oi.getQuant(),oi.getCategory(), productSubTotal, oi.getWeight(), orderTotal, oi.getImage(),sid1, storeadd, stzip, deliveryType, purchaseDate, expectedDeliveryDate);
                }
                

        } else{

        

        for (OrderItem oi : utility.getCustomerOrders()){
                String itemId = oi.getId(); 
                int a = oi.getStock()-oi.getQuant();
                SqlQueries.updateQuantity(itemId, a);

                productSubTotal = oi.getPrice()*oi.getQuant();
                SqlQueries.insertOrder(OrderId, username, email, firstname, lastname, fulladdress, zipcode,creditCardNo, phoneno,orderNotes,oi.getId(), oi.getName(), oi.getPrice(), oi.getQuant(),oi.getCategory(), productSubTotal, oi.getWeight(), orderTotal,oi.getImage(),sid1, "none", 0, "Home Delivery", purchaseDate, expectedDeliveryDate);
        }
}

        OrdersHashMap.orders.remove(utility.username());
        response.setCharacterEncoding("UTF-8");             
        response.getWriter().write("http://localhost:8080/Grocery%20Hub/orderplaced.jsp");
        }
}
