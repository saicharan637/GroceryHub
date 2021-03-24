import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



@WebServlet("/Utilities")
public class Utilities extends HttpServlet{
    HttpSession session;
    HttpServletRequest req;

    public Utilities(HttpServletRequest req) {
		this.req = req;
		this.session = req.getSession(true);
	}

	public Utilities(){	
	}

    public String username(){
    if (session.getAttribute("usr")!=null || session.getAttribute("usr").equals("Welcome to Grocery Hub"))
        return session.getAttribute("usr").toString();
    return null;
}

public boolean isLoggedin(){
    if (session.getAttribute("usr")==null||session.getAttribute("usr").equals("Welcome to Grocery Hub"))
        return false;
    return true;
}

public ArrayList<OrderItem> getCustomerOrders(){
    ArrayList<OrderItem> order = new ArrayList<OrderItem>(); 
    if(OrdersHashMap.orders.containsKey(username()))
        order= OrdersHashMap.orders.get(username());
    return order;
}

public int CartCount(){
    if(isLoggedin())
    return getCustomerOrders().size();
    return 0;
}

public User getUser(){
    String usertype = "customer";
    HashMap<String, User> hm=new HashMap<String, User>();
    try
    {	
            hm=SqlQueries.selectUser();
           
        }
    catch(Exception e){
        }	
    User user = hm.get(username());
    return user;
}


public void logout(){
    session.removeAttribute("usr");
}

/*  getOrdersPaymentSize Function gets  the size of OrderPayment */
public int getOrderPaymentSize(){
    HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
    int size = 0;
        try
        {
            orderPayments =SqlQueries.selectOrder();
        }
        catch(Exception e)
        {
        
        }
        for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()){
            size=entry.getKey();
        }
        return size;		
}

public void storeProduct(String name,String type, int quant){
    if(!OrdersHashMap.orders.containsKey(username())){	
        ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
        OrdersHashMap.orders.put(username(), arr);
    }
    ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
    HashMap<String,Product> fruits = new HashMap<String,Product>();
    HashMap<String,Product> dairys = new HashMap<String,Product>();
    HashMap<String,Product> meats = new HashMap<String,Product>();
    HashMap<String,Product> frozens = new HashMap<String,Product>();
    HashMap<String,Product> canneds = new HashMap<String,Product>();
    HashMap<String,Product> beverages = new HashMap<String,Product>();
    HashMap<String,Product> personalcares = new HashMap<String,Product>();
    HashMap<String,Product> homecares = new HashMap<String,Product>();

    if(type.equals("Fruits&Vegetables")){
        try{
            fruits=SqlQueries.getfruits();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = fruits.get(name);
        for(Product p : fruits.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }


    else if(type.equals("Dairy&Bakery")){
        try{
            dairys=SqlQueries.getdairys();
        }
        catch(Exception e){
        }
        Product product = null;
        for(Product p : dairys.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }        
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("FreshMeat")){
        try{
            meats=SqlQueries.getmeats();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = meats.get(name);
        for(Product p : meats.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     

        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("frozen")){
        try{
            frozens=SqlQueries.getfrozens();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = frozens.get(name);
        for(Product p : frozens.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     


        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("canned")){
        try{
            canneds=SqlQueries.getcanneds();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = canneds.get(name);

        for(Product p : canneds.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("Beverages")){
        try{
            beverages=SqlQueries.getbeverages();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = beverages.get(name);

        for(Product p : beverages.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("Personal Care")){
        try{
            personalcares=SqlQueries.getpersonalcares();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = personalcares.get(name);
        for(Product p : personalcares.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }
    else if(type.equals("Home Care")){
        try{
            homecares=SqlQueries.gethomecares();
        }
        catch(Exception e){
        }
        Product product = null;
        // product = homecares.get(name);
        for(Product p : homecares.values()){
            if(p.getProductname().equals(name)){
                product = p;
                break;
            }
        }     
        OrderItem orderitem = new OrderItem(product.getIndex(),product.getProductid(),product.getProductname(),product.getImage(), product.getPrice(),product.getDiscount(), type, product.getNumber_of_items(),product.getWeight(), quant);
        orderItems.add(orderitem);
    }

}

public String storeReview(String productName, String username, String productType, int StoreZip, String reviewRating, String reviewDate, String reviewText, Double price, String image)
    {
        String message=MongoDBDataStoreUtilities.insertReview(productName,username(),productType, StoreZip,reviewRating,reviewDate,reviewText,price,image);
        if(!message.equals("Successfull"))
            { return "UnSuccessfull";
    }
    else
    {
        HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
        try
        {
            reviews=MongoDBDataStoreUtilities.selectReview();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(reviews==null)
        {
            reviews = new HashMap<String, ArrayList<Review>>();
        }
            // if there exist product review already add it into same list for productname or create a new record with product name
        
        if(!reviews.containsKey(productName)){  
            ArrayList<Review> arr = new ArrayList<Review>();
            reviews.put(productName, arr);
        }
        ArrayList<Review> listReview = reviews.get(productName);        
        Review review = new Review(productName,username(),productType,StoreZip,reviewRating,reviewDate,reviewText,price,image);
        listReview.add(review); 
        
            // add Reviews into database
        
        return "Successfull";   
    }
}

}