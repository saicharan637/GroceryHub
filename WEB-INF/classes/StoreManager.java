import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StoreManager")

public class StoreManager extends HttpServlet {
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("button");	
		String msg = "good";
		String producttype= "",productId="",productName="",productWeight="",productImage="";
		Double productPrice=0.0, productDiscount=0.0;
		int numOfItems=0;
		HashMap<String,Product> fruits=new HashMap<String,Product>();
		HashMap<String,Product> dairys = new HashMap<String,Product> ();
		HashMap<String,Product> meats = new HashMap<String,Product> ();
		HashMap<String,Product> frozens = new HashMap<String,Product> ();
		HashMap<String,Product> canneds = new HashMap<String,Product> ();
		HashMap<String,Product> beverages = new HashMap<String,Product> ();
		HashMap<String,Product> personalcares = new HashMap<String,Product> ();
		HashMap<String,Product> homecares = new HashMap<String,Product> ();

		String usr = request.getParameter("username");

		if (action.equals("add") || action.equals("update"))
		{	
			producttype = request.getParameter("Category");
			productId   = request.getParameter("ProductId");
			productName = request.getParameter("ProductName"); 
			productPrice = Double.parseDouble(request.getParameter("Price"));
			productWeight = request.getParameter("Weight");
			productImage = request.getParameter("productImage");
			numOfItems = Integer.parseInt(request.getParameter("Number_Of_Items"));
			productDiscount = Double.parseDouble(request.getParameter("Discount"));
		}
		else{
			productId = request.getParameter("ProductId");
		}	

		if(action.equals("add"))
		{
			if(producttype.equals("Fruits&Vegetables")){
				fruits = SqlQueries.getfruits();
				if(fruits.containsKey(productId)){
					msg = "Product already available";
				}
				
			}else if(producttype.equals("Dairy&Bakery"))
			{
				dairys = SqlQueries.getdairys();
				if(dairys.containsKey(productId)){
					msg = "Product already available";
				}
			}else if (producttype.equals("FreshMeat"))
			{
				meats = SqlQueries.getmeats();
				if(meats.containsKey(productId)){
					msg = "Product already available";
				}
			}else if(producttype.equals("frozen"))
			{
				frozens = SqlQueries.getfrozens();
				if(frozens.containsKey(productId)){
					msg = "Product already available";
				}
			}else if (producttype.equals("canned"))
			{
				canneds = SqlQueries.getcanneds();
				if(canneds.containsKey(productId)){
					msg = "Product already available";
				}
			}else if(producttype.equals("Beverages"))
			{
				beverages = SqlQueries.getbeverages();
				if(beverages.containsKey(productId)){
					msg = "Product already available";
				}
			}else if (producttype.equals("Personal Care"))
			{
				personalcares = SqlQueries.getpersonalcares();
				if(personalcares.containsKey(productId)){
					msg = "Product already available";
				}
			}else if(producttype.equals("Home Care"))
			{
				homecares = SqlQueries.gethomecares();
				if(homecares.containsKey(productId)){
					msg = "Product already available";
				}
			}	
			if (msg.equals("good"))
			{  
				try
				{
					msg = SqlQueries.addproducts(productId,productName,productImage,productPrice,productDiscount,producttype,numOfItems,productWeight,usr);
				}
				catch(Exception e)
				{ 
					msg = "Product cannot be inserted";
					System.out.println("Product cannot be inserted");
				}
				msg = "Product has been successfully added";
			}					
		}else if(action.equals("update"))
		{
			
			if(producttype.equals("Fruits&Vegetables")){
				fruits = SqlQueries.getfruits();
				if(!fruits.containsKey(productId)){
					msg = "Product not available";
				}
			}else if(producttype.equals("Dairy&Bakery"))
			{
				dairys = SqlQueries.getdairys();
				if(!dairys.containsKey(productId)){
					msg = "Product not available";
				}
			}else if (producttype.equals("FreshMeat"))
			{
				meats = SqlQueries.getmeats();
				if(!meats.containsKey(productId)){
					msg = "Product not available";
				}
			}else if(producttype.equals("frozen")){
				frozens = SqlQueries.getfrozens();
				if(!frozens.containsKey(productId)){
					msg = "Product not available";
				}  
			}else if(producttype.equals("canned"))
			{
				canneds = SqlQueries.getcanneds();
				if(!canneds.containsKey(productId)){
					msg = "Product not available";
				}
			}else if (producttype.equals("Beverages"))
			{
				beverages = SqlQueries.getbeverages();
				if(!beverages.containsKey(productId)){
					msg = "Product not available";
				}
			}else if (producttype.equals("Personal Care"))
			{
				personalcares = SqlQueries.getpersonalcares();
				if(!personalcares.containsKey(productId)){
					msg = "Product not available";
				}
			}else if(producttype.equals("Home Care")){
				homecares = SqlQueries.gethomecares();
				if(!homecares.containsKey(productId)){
					msg = "Product not available";
				}
			}
			if (msg.equals("good"))
			{		
				try
				{
					msg = SqlQueries.updateproducts(productId,productName,productImage,productPrice,productDiscount,producttype,numOfItems,productWeight,usr);
				}
				catch(Exception e)
				{ 
					msg = "Product cannot be updated";
					System.out.println("Product cannot be updated");
				}
				//msg = "Product has been successfully updated";
			} 
		}else if(action.equals("delete"))
		{
			msg = "bad";
			fruits = SqlQueries.getfruits();
			if(fruits.containsKey(productId)){
				msg = "good";
			}			  
			
			dairys = SqlQueries.getdairys();
			if(dairys.containsKey(productId)){
				msg = "good";
			}
			
			meats = SqlQueries.getmeats();
			if(meats.containsKey(productId)){
				msg = "good";
			}

			frozens = SqlQueries.getfrozens();
			if(frozens.containsKey(productId)){
				msg = "good";
			} 
			
			canneds = SqlQueries.getcanneds();
			if(canneds.containsKey(productId)){
				msg = "good";
			}
			
			beverages = SqlQueries.getbeverages();
			if(beverages.containsKey(productId)){
				msg = "good";
			}

			personalcares = SqlQueries.getpersonalcares();
			if(personalcares.containsKey(productId)){
				msg = "good";
			}

			homecares = SqlQueries.gethomecares();
			if(homecares.containsKey(productId)){
				msg = "good";
			} 
			if (msg.equals("good"))
			{		
				
				try
				{  
					
					msg = SqlQueries.deleteproducts(productId,usr);

				}
				catch(Exception e)
				{ 
					
					System.out.println("This is the Exception"+e);
				}
				msg = "Product has been successfully deleted";
			}else{
				msg = "Product cannot be deleted";
			}
		}

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		if(msg.equals("Product has been successfully added") && action.equals("add"))
		{
			msg = "Product added successfully";
			session.setAttribute("message", msg);
		}
		else if(!msg.equals("Product has been successfully added") && action.equals("add"))
		{
			msg = "Product cannot be added";
			session.setAttribute("message", msg);
		}
		else if(msg.equals("Product has been successfully updated") && action.equals("update"))
		{
			msg = "Product updated successfully";
			session.setAttribute("message", msg);
		}
		else if(!msg.equals("Product has been successfully updated") && action.equals("update"))
		{
			msg = "Product cannot be updated as it is not available in the store";
			session.setAttribute("message", msg);
		}
		else if(msg.equals("Product has been successfully deleted") && action.equals("delete"))
		{
			msg = "Product has been successfully deleted";
			session.setAttribute("message", msg);
		}
		else if(!msg.equals("Product has been successfully deleted") && action.equals("delete"))
		{
			msg = "Product doesn't exist in the Store to get deleted";
			session.setAttribute("message", msg);
		}
		// else if(msg.equals("Product cannot be deleted") && action.equals("delete"))
		// {
		// 	msg = "Product cannot be deleted";
		// 	session.setAttribute("message", msg);
		// }
		dispatcher = request.getRequestDispatcher("StoreManager.jsp");
		dispatcher.forward(request, response);	
	}
}