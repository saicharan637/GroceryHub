import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet("/Admin")

public class Admin extends HttpServlet {
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("button");	
		String msg = "good";
		String producttype= "",productId="",productName="",productWeight="",productImage="",storeid1="", storeid2="",storeid3="",storeid4="",storeid5="";
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
			if(request.getParameter("store1") != null){
				storeid1="YES";
			}else{
				storeid1="NO";
			}
			if(request.getParameter("store2") != null){
				storeid2="YES";
			}else{
				storeid2="NO";
			}
			if(request.getParameter("store3") != null){
				storeid3="YES";
			}else{
				storeid3="NO";
			}
			if(request.getParameter("store4") != null){
				storeid4="YES";
			}else{
				storeid4="NO";
			}
			if(request.getParameter("store5") != null){
				storeid5="YES";
			}else{
				storeid5="NO";
			}

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
					msg = SqlQueries.addAdminproducts(productId,productName,productImage,productPrice,productDiscount,producttype,numOfItems,productWeight,storeid1,storeid2,storeid3,storeid4,storeid5);
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
					msg = SqlQueries.updateAdminproducts(productId,productName,productImage,productPrice,productDiscount,producttype,numOfItems,productWeight,storeid1,storeid2,storeid3,storeid4,storeid5);
				}
				catch(Exception e)
				{ 
					msg = "Product cannot be updated";
					System.out.println("Product cannot be updated");
					System.out.println(e);
				}
				msg = "Product has been successfully updated";
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

					msg = SqlQueries.deleteAdminproducts(productId);
				}
				catch(Exception e)
				{ 
					
					// msg = "Product cannot be deleted";
					// System.out.println("Product cannot be deleted");
				}
				msg = "Product has been successfully deleted";
			}else{
				msg = "Product not available";
			}
		}

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		if(action.equals("add"))
		{
			msg = "Product added successfully";
			session.setAttribute("message", msg);
		}
		else if(action.equals("update"))
		{
			msg = "Product updated successfully";
			session.setAttribute("message", msg);
		}
		else if(action.equals("delete"))
		{
			msg = "Product deleted successfully";
			session.setAttribute("message", msg);
		}
		dispatcher = request.getRequestDispatcher("StoreManager.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Utilities utility = new Utilities(request);
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Session Timed out. Please try again");
			response.sendRedirect("ErrorLogin.jsp");
			return;
		}

		String val = request.getParameter("operation");
		

		ArrayList<Product> prod = new ArrayList<Product>();

		prod = SqlQueries.getStore1();

		request.setAttribute("val", val);
		request.setAttribute("stoc", prod);
		request.getRequestDispatcher("ProductListAdmin.jsp").forward(request, response);
	}
}