import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;



@WebServlet("/SMCateogrySalesGraph")

public class SMCateogrySalesGraph extends HttpServlet {
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

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {  
    Utilities utility = new Utilities(request);
    
    try {
        getConnection();
        String username=utility.username();
        String n = "";          
        if(username.equals("s1")){n="1";}
        else if(username.equals("s2")){n="2";}
        else if(username.equals("s3")){n="3";}
        else if(username.equals("s4")){n="4";}
        else if(username.equals("s5")){n="5";}

        String getData = "SELECT category,sum(no_of_items) as ItemsSold FROM groceryhub.customerorders where StoreId=? group by category;";
        PreparedStatement pst = conn.prepareStatement(getData);
        pst.setString(1,n);
        ResultSet rs = pst.executeQuery();
        JSONArray json = new JSONArray();

        while(rs.next()){
            JSONObject obj = new JSONObject();
            obj.put("product_name", rs.getString("category"));
            obj.put("product_sales", rs.getDouble("ItemsSold"));
            json.put(obj);
        }
        
        // System.out.println(json);
        String jsonSales = new Gson().toJson(json);
        response.setContentType("application/JSON");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonSales);
        
    } catch (Exception e) {
        System.out.println(e);
                        //TODO: handle exception
    }
}
}
