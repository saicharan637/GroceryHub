import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/ProductData")
public class ProductData extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilities utility = new Utilities(request);
        Product data= (Product)request.getAttribute("data");
		String name = data.getProductname();
		System.out.println(name);
        // String id = data.getProductId();
        String category = data.getCategory();
        double price = data.getPrice();
        int count = data.getNumber_of_items();
        String image = data.getImage();
		String weight = data.getWeight();
		double discount = data.getDiscount();
		
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("category", category);
		request.setAttribute("image", image);
		request.setAttribute("discount", discount);
		request.setAttribute("weight", weight);
		request.setAttribute("number_of_items", count);

		request.getRequestDispatcher("searchresult.jsp").forward(request, response);
	}
	
	public void destroy(){
	// do nothing
	
	  
	}
	

}