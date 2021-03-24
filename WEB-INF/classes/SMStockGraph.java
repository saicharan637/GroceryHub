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



@WebServlet("/SMStockGraph")

public class SMStockGraph extends HttpServlet {
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
        String getData="";
        String username=utility.username();
        String s1 = "NO", s2 = "NO", s3 = "NO", s4 = "NO", s5 = "NO";
        if(username.equals("s1")){s1 = "YES";}
        else if(username.equals("s2")){s2 = "YES";}
        else if(username.equals("s3")){s3 = "YES";}
        else if(username.equals("s4")){s4 = "YES";}
        else if(username.equals("s5")){s5 = "YES";}
        if(s1=="YES") getData = "SELECT productName, Number_Of_Items FROM groceryhub.product_details where s1='YES';";
        else if(s2=="YES") getData = "SELECT productName, Number_Of_Items FROM groceryhub.product_details where s2='YES';";
        else if(s3=="YES") getData = "SELECT productName, Number_Of_Items FROM groceryhub.product_details where s3='YES';";
        else if(s4=="YES") getData = "SELECT productName, Number_Of_Items FROM groceryhub.product_details where s4='YES';";
        else if(s5=="YES") getData = "SELECT productName, Number_Of_Items FROM groceryhub.product_details where s5='YES';";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(getData);
        JSONArray json = new JSONArray();

        while(rs.next()){
            JSONObject obj = new JSONObject();
            obj.put("product_name", rs.getString("productName"));
            obj.put("product_sales", rs.getDouble("Number_Of_Items"));
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
