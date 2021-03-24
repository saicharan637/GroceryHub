import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import javax.servlet.*;


@WebServlet("/CreateIDForm")
public class CreateIDForm extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String usertype = request.getParameter("usertype");
		RequestDispatcher dispatcher;
    // Authentication start
		HashMap<String, User> hm=new HashMap<String, User>();
		
		String message = SqlQueries.getConnection();
		String error;

		
		if(message.equals("Successfull"))
			hm=SqlQueries.selectUser();
		
			// if the user already exist show error that already exist
		if(username.equals("")||email.equals("")||password.equals("")||repassword.equals("")){
			error = "Please Enter Data in all the fields";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("CreateID.jsp");
			dispatcher.forward(request, response);
		}
		else if(hm.containsKey(username)){
			error = "Username already exits";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("CreateID.jsp");
			dispatcher.forward(request, response);
		}
		else if(!isValid(email)){
			error = "Enter a Valid Email-ID";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("CreateID.jsp");
			dispatcher.forward(request, response);
		}
		else if(!isValidPassword(password)){
			error = "Password must contain at least one digit [0-9].\nPassword must contain at least one lowercase Latin character [a-z].\nPassword must contain at least one uppercase Latin character [A-Z].\nPassword must contain at least one special character like ! @ # & ( ).\nPassword must contain a length of at least 8 characters and a maximum of 20 characters.";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("CreateID.jsp");
			dispatcher.forward(request, response);
		}
		else if(!password.equals(repassword))
		{
			error = "Password and Repassword should be same";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("CreateID.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
				/*create a user object and store details into hashmap
				store the user hashmap into file  */

				User user = new User(username,password,usertype);
				hm.put(username, user);
				try {
					SqlQueries.insertUser(username, email, password,usertype);
				} catch (Exception e) {
					System.out.println(e);
				}

				response.sendRedirect("index.jsp");
				

				HttpSession session = request.getSession(true);
				session.setAttribute("usertype",usertype);
				// HttpSession session = request.getSession(true);				
				
				// if(!utility.isLoggedin()){
				// 	session.setAttribute("login_msg", "Your "+usertype+" account has been created. Please login");
				// 	response.sendRedirect("Login"); return;
				// } else {
				// 	response.sendRedirect("index.html");
				// }
			}
			
		}
		static boolean isValid(String email) {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			return email.matches(regex);
		}
		static boolean isValidPassword(String password) {
			String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
			return password.matches(regex);
		}
	}