import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

@WebServlet("/Startup")
public class Startup extends HttpServlet{
    public void init() throws ServletException{
        ServletContext sc = getServletContext();

        if (sc.getAttribute("usr") == null){
            String usr = "";
            sc.setAttribute("usr", usr);
        }

        if (sc.getAttribute("storeLocation") == null){
            String usr = "Cermak Fresh Market";
            sc.setAttribute("storeLocation", usr);
        }

        if (sc.getAttribute("stozip") == null){
            String usr = "60353";
            sc.setAttribute("stozip", usr);
        }
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

        String tweet="";
        HashMap<String,Product> selectedproducts=new HashMap<String,Product>();
        try
        {        
            String line=null;
            String TOMCAT_HOME = System.getProperty("catalina.home");

            HashMap<String,Product> productmap=SqlQueries.getData();
            
            for(Map.Entry<String, Product> entry : productmap.entrySet())
            {
                
                if(selectedproducts.size()<4 && !selectedproducts.containsKey(entry.getKey()))
                {       
                    
                    
                    BufferedReader reader = new BufferedReader(new FileReader (new File(TOMCAT_HOME+"\\webapps\\Grocery Hub\\Python\\DealMatches.txt")));
                    line=reader.readLine().toLowerCase();
                    

                    if(line==null)
                    {
                        System.out.println("No offers found");
                        break;
                    }   
                    else
                    {   
                        do {    
                          if(line.contains(entry.getKey()))
                          {
                            tweet+="<br>"+line;
                            selectedproducts.put(entry.getKey(),entry.getValue());
                            break;
                        }
                        
                    }while((line = reader.readLine()) != null);
                }
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    System.out.println("the selectedproducts is "+selectedproducts);
    sc.setAttribute("bestrated",bestrated);
    sc.setAttribute("latest",latest);
    sc.setAttribute("mostsold",mostsold);
    sc.setAttribute("selectedproducts",selectedproducts);
    sc.setAttribute("tweet",tweet);
}

}