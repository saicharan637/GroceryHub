import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Enumeration;
import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;



@WebServlet("/Fruits")

public class Fruits extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(true);


        // Enumeration<String> attributes = request.getSession().getAttributeNames();
        // while (attributes.hasMoreElements()) {
        //     String attribute = (String) attributes.nextElement();
        //     System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
        // }

        String sid1 =(String)session.getAttribute("sid");
        // System.out.println("sid is"+sid1);
        if(sid1==null){
            sid1 = "0";
        }
        int sid = Integer.parseInt(sid1+"");
        // System.out.println("sid is : "+sid);
        ArrayList<Product> fruits = new ArrayList<Product>();

        try{
            getConnection();
            Statement statement = conn.createStatement();
              if(sid==0){
                // System.out.println("sid is this "+sid);
                String selectStoreQuery = "Select * from product_details where s1='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
            else if(sid==1){
                // System.out.println("sid is this "+sid);
                String selectStoreQuery = "Select * from product_details where s1='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
            else if(sid==2){
                String selectStoreQuery = "Select * from product_details where s2='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
            else if(sid==3){
                String selectStoreQuery = "Select * from product_details where s3='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
            else if(sid==4){
                String selectStoreQuery = "Select * from product_details where s4='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
            else if(sid==5){
                String selectStoreQuery = "Select * from product_details where s5='YES' and Category='Fruits&Vegetables';";
                ResultSet rs = statement.executeQuery(selectStoreQuery);

                while(rs.next()){
                    Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
                    fruits.add(pds);
                }
            }
        }
        catch(Exception e){
            System.out.println("it is here"+e);
        }

        int count=fruits.size();
        // System.out.println("the count is this:"+count);
        String stozip =(String)session.getAttribute("stozip");
        String storeLocation =(String)session.getAttribute("storeLocation");

        ArrayList<LatestProducts> latest = new ArrayList<LatestProducts>();
        try{
            latest=SqlQueries.SelectLatestProducts();
        }catch(Exception e){
            System.out.println("the exception in Analytics is "+e);
        }
            
        request.setAttribute("latest",latest);
        request.setAttribute("fruits", fruits);
        request.setAttribute("count", count);
        request.setAttribute("sid",sid);
        request.setAttribute("stozip",stozip);
        request.setAttribute("storeloc",storeLocation);
        request.getRequestDispatcher("fruits.jsp").forward(request, response);
    }

    static Connection conn = null;
    static String message;

    public static String getConnection()
    {


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/groceryhub","root","mausam123");                             
            message="Successfull";
            return message;
        }
        catch(SQLException e)
        {
            message="unsuccessful";
            return message;
        }
        catch(Exception e)
        {
            message=e.getMessage();
            return message;
        }
    }


}