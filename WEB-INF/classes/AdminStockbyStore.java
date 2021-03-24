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
import java.util.ArrayList;



@WebServlet("/AdminStockbyStore")

public class AdminStockbyStore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
                String storeid = request.getParameter("storeID");
                ArrayList<Product> prod = new ArrayList<Product>();
                if(storeid.equals("s1")){
                    prod = SqlQueries.getStore1();
                } else if(storeid.equals("s2")){
                    prod = SqlQueries.getStore2();
                }else if(storeid.equals("s3")){
                    prod = SqlQueries.getStore3();
                }else if(storeid.equals("s4")){
                    prod = SqlQueries.getStore4();
                }else if(storeid.equals("s5")){
                    prod = SqlQueries.getStore5();
                }

        request.setAttribute("val", "stocks");
        request.setAttribute("stoc", prod);
        request.getRequestDispatcher("ProductListAdmin.jsp").forward(request, response);
    }
}
