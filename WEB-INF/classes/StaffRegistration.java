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



@WebServlet("/StaffRegistration")

public class StaffRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String sid = request.getParameter("storeid");
                String email = request.getParameter("email");

                System.out.println(username);
                System.out.println(password);
                System.out.println(sid);
                System.out.println(email);

                int storeid = Integer.parseInt(sid);
                
                HashMap<String, User> hm=new HashMap<String, User>();
                String usertype = "StoreManager";
                String msg="";

                hm=SqlQueries.selectUser();

                if(hm.containsKey(username)){
                    msg = "true";
                    System.out.println(msg);
                    response.setCharacterEncoding("UTF-8");             
                    response.getWriter().write(msg);
                } else{
                    User user = new User(username,password,usertype);
                    hm.put(username, user);
                    try {
                        SqlQueries.insertStoreManager(username, email, password, storeid);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    // Using text/plain for example
                    msg = "http://localhost:8080/Grocery%20Hub/index.jsp";
                    response.setCharacterEncoding("UTF-8");             
                    response.getWriter().write(msg);
                }
                
               
				// response.sendRedirect("index.jsp");
            }
}
