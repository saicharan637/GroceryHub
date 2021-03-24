import java.util.HashMap;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Login")
public class Login extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    RequestDispatcher dispatcher;
    System.out.println(request.getParameter("remember"));
    if(request.getParameter("remember") != null){
      String remember = request.getParameter("remember");
      Cookie cUserName = new Cookie("cookuser", username.trim());
      Cookie cPassword = new Cookie("cookpass", password.trim());
      Cookie cRemember = new Cookie("cookrem", remember);
        cUserName.setMaxAge(60 * 60 * 24 * 365);// 365 days
        cPassword.setMaxAge(60 * 60 * 24 * 365);
        cRemember.setMaxAge(60 * 60 * 24 * 365);            
        response.addCookie(cUserName);
        response.addCookie(cPassword);
        response.addCookie(cRemember);                                


        boolean newbie = true;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
          for(int i=0; i<cookies.length; i++) {
            Cookie c = cookies[i];
            if ((c.getName().equals("repeatVisitor")) &&
            // Could omit test and treat cookie name as a flag
              (c.getValue().equals("yes"))) {
              newbie = false;
            break;
          }
        }
      }
      String title;
      if (newbie) {
        Cookie returnVisitorCookie =
        new Cookie("repeatVisitor", "yes");
      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
      response.addCookie(returnVisitorCookie);
      title = "Aboard";
      session.setAttribute("title", title);
    } else {
      title = "Back";
      session.setAttribute("title", title);
    }
  }

  HashMap<String, User> hm=new HashMap<String, User>();

  try
  {	
   hm=SqlQueries.selectUser();
 }
 catch(Exception e)
 {
  System.out.println("it is "+e);		
}

User user = hm.get(username);
String msg="";
if(user!=null){
  String user_pass = user.getPassword();


  if(password.equals(user_pass)){
    String usr = user.getUserName();
    String usertype = user.getUsertype();
    session.setAttribute("usr", usr);
    session.setAttribute("usertype", usertype);
    
    msg = "http://localhost:8080/Grocery%20Hub/Index";
    
  }else{
    msg = "true";
  }
}
response.setCharacterEncoding("UTF-8");             
response.getWriter().write(msg);

}
}