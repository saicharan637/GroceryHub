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



@WebServlet("/AdminStockGraph")

public class AdminStockGraph extends HttpServlet {
    static Connection conn = null;
    static String message;

    public static String getConnection()
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/groceryhub","root","masuam123");							
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

// @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //             ArrayList<OrderPayments> stock = new ArrayList<OrderPayments>();

    //             try {
    //                 stock=SqlQueries.productStock();
    //             } catch (Exception e) {
    //                 //TODO: handle exception
    //             }
    //             request.setAttribute("stock", stock);
    //             request.getRequestDispatcher("salesreport.jsp").forward(request, response);

    //         }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  

                
                    try {
                        getConnection();
                        String getData = "SELECT productName, Number_Of_Items FROM product_details;";
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery(getData);
                        System.out.println("the query is "+statement);
                        JSONArray json = new JSONArray();

                        while(rs.next()){
                            JSONObject obj = new JSONObject();
                            obj.put("product_name", rs.getString("productName"));
                            obj.put("product_sales", rs.getInt("Number_Of_Items"));
                            json.put(obj);
                        }
                        
                            System.out.println("the json is "+json);
                            String jsonSales = new Gson().toJson(json);
                            response.setContentType("application/JSON");
                            response.setCharacterEncoding("UTF-8");
                            response.getWriter().write(jsonSales);
                
                    } catch (Exception e) {
                        System.out.println("it is "+e);
                        //TODO: handle exception
                    }
                }
}
