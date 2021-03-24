import java.io.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/Reviews")

public class Reviews extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		storeReview(request, response);
	}

	protected void storeReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
        {
			HttpSession session = request.getSession(true);
			String stzip = (String) session.getAttribute("stozip");
			if(stzip == null){
				stzip = "60353";
			}
			int storezip = Integer.parseInt(stzip);
        	Utilities utility = new Utilities(request);
            String prodname=request.getParameter("prodname");		
            String category=request.getParameter("category");
            String image=request.getParameter("image");
			Double price=Double.parseDouble(request.getParameter("price"));
            String review=request.getParameter("review");
			String reviewtext=request.getParameter("reviewtext");
			LocalDate localDate  = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String reviewdate = localDate.format(formatter);
			String message=utility.storeReview(prodname,"",category,storezip,review,reviewdate,reviewtext,price,image);
			String msg="";				     
			
      		RequestDispatcher dispatcher;
			if(message.equals("Successfull"))
			{
				msg = "Review for &nbsp"+prodname+" Stored";
				session.setAttribute("message", msg);
			}
			else
			{
				msg = "Mongo Db is not up and running";
				session.setAttribute("message", msg);
			}
			dispatcher = request.getRequestDispatcher("Reviews.jsp");
	        dispatcher.forward(request, response);
	                     	
        }
        catch(Exception e)
		{
            System.out.println(e.getMessage());
		}  			 	
}
}