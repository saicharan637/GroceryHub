import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.io.IOException;

@WebServlet("/StoreSet")

public class StoreSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String storeloc = request.getParameter("storeSelection");
        String storeid = request.getParameter("stid");
        String storeadd = request.getParameter("stadd");
        String storezip = request.getParameter("stzip");

        request.setAttribute("storeLocation", storeloc);
        request.setAttribute("stozip", storezip);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}