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
import java.io.*; 

@WebServlet("/Index")

public class Index extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       ProductRecommenderUtility prodRecUtility = new ProductRecommenderUtility();
       HashMap<String,String> prodRecmMap = new HashMap<String,String>();
       prodRecmMap = prodRecUtility.readOutputFile();
       //System.out.println("the prodRecmMap is "+prodRecmMap);


    //    Enumeration<String> attributes = request.getSession().getAttributeNames();
    //    while (attributes.hasMoreElements()) {
    //     String attribute = (String) attributes.nextElement();
    //     System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
    // }
       HttpSession session = request.getSession(true);

       String user1 = (String)session.getAttribute("usr");
       Hashtable<String,ArrayList<String>> mapOfList = new Hashtable<String,ArrayList<String>>();
       ArrayList<String> pp= new ArrayList<String>();
       ArrayList<Product> p= new ArrayList<Product>();
       for(String user: prodRecmMap.keySet())
       {
        if(user.equals(session.getAttribute("usr")))
        {
            String products = prodRecmMap.get(user);
            products=products.replace("[","");
            products=products.replace("]","");
            products=products.replace("\"", " ");
            ArrayList<String> productsList = new ArrayList<String>(Arrays.asList(products.split(",")));
            //System.out.println("the ArrayList is "+productsList);
            
            
            for(String prod : productsList){
                prod= prod.replace("'", "");
                Product prodObj = new Product();
                
                prodObj = ProductRecommenderUtility.getProduct(prod.trim());
                //System.out.println("the prodObj is "+prodObj);

                
                String a =(prodObj.getProductname());
                String b=(String.valueOf(prodObj.getPrice()));
                String c=(String.valueOf(prodObj.getImage()));
                // mapOfList.put(user1,pp);
                Product p1=new Product(a,Double.parseDouble(b),c);
                p.add(p1);

            }

               // System.out.println("THe final Hashtable is this:"+mapOfList);
            


        }
        //System.out.println("THe final ArrayList p is this:"+p);

    }
    request.setAttribute("p",p);
    session.setAttribute("p",p);

   
    
    




    String user = (String)session.getAttribute("usr");
    //System.out.println("the user is "+user);
    ArrayList<MostSoldProducts> mostsold = new ArrayList<MostSoldProducts>();
    ArrayList<LatestProducts> latest = new ArrayList<LatestProducts>();
    ArrayList<Bestrating> bestrated = new ArrayList<Bestrating> ();
    try{
        mostsold=SqlQueries.SelectMostSoldProducts();
        latest=SqlQueries.SelectLatestProducts();
        bestrated=MongoDBDataStoreUtilities.topProducts();
    }catch(Exception e){
        System.out.println("the exception in Index is "+e);
    }

    RequestDispatcher dispatcher;
    request.setAttribute("bestrated",bestrated);
    request.setAttribute("latest",latest);
    request.setAttribute("mostsold",mostsold);
    request.setAttribute("user",user);
    //request.setAttribute("prodRecmMap",prodRecmMap);


    request.getRequestDispatcher("index.jsp").forward(request, response);

}
}