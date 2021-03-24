import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.ArrayList;

@WebServlet("/Reload")

public class Reload extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Utilities utility = new Utilities(request);
		// if(!utility.isLoggedin())
		// {
		// 	HttpSession session = request.getSession(true);				
		// 	session.setAttribute("login_msg", "Please Login to Pay");
		// 	response.sendRedirect("Login");
		// 	return;
		// }
		
		String cancel1 = request.getParameter("maker");
		// String reload = requestl.getParameter("reload");
		String name = request.getParameter("can");
        String type = request.getParameter("prodcat");
        String q = request.getParameter("quant");
		String z = request.getParameter("cartquant");

        System.out.println(z);
        int quant = Integer.parseInt(q);
        int a = Integer.parseInt(z);
		
			if(a!=quant){
				quant=a;
			}	
				
		if(cancel1.equals("reload"))
		{
			String us=utility.username();
			ArrayList<OrderItem> list = OrdersHashMap.orders.get(us);
			System.out.println(list);
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().equalsIgnoreCase(name)){
					list.get(i).setQuant(quant);
				}
			}
		}
		// utility.storeProduct(name, type,quant);
		response.sendRedirect("Cart");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request);
		
		
	}
}









