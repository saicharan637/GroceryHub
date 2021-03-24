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



@WebServlet("/AdminTotalSales")

public class AdminTotalSales extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
                String val = request.getParameter("sale");
                String ss = "";
                
                ArrayList<OrderPayment> st = new ArrayList<OrderPayment>();

                if(val.equals("ordersales")){
                    st = SqlQueries.totalSalesinaDay();
                    ss = "sbd";
                } else{
                    st = SqlQueries.productsSold();
                    ss="cv";
                }
                
                request.setAttribute("val",ss);
                request.setAttribute("st",st);
                request.getRequestDispatcher("salesreport.jsp").forward(request, response);
    }
}
