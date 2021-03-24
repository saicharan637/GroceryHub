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

@WebServlet("/CustomerCare")

public class CustomerCare extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       ArrayList<Feedback> feedback = new  ArrayList<Feedback>();
       
       feedback = SqlQueries.getAllFeedback();

       request.setAttribute("feed", feedback);
       request.getRequestDispatcher("feedback.jsp").forward(request, response);
		
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String problem = request.getParameter("problemtext");
        System.out.println(name);
        System.out.println(email);
        System.out.println(problem);
            
        
        SqlQueries.insertProblem(email,name,problem);
       

        System.out.println("Customer care executed");

        String msg = "http://localhost:8080/Grocery%20Hub/feedbackdone.jsp";

        response.getWriter().write(msg);
           
		
    }
}
