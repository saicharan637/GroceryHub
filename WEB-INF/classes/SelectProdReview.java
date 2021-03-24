import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;


@WebServlet("/SelectProdReview")

public class SelectProdReview extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      ArrayList<Product> product = new ArrayList<Product>();

      product = SqlQueries.selectAllProducts();

      request.setAttribute("p", product);
      request.getRequestDispatcher("SelectProdRev.jsp").forward(request, response);
    }
}