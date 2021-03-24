import com.google.gson.Gson;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.mongodb.AggregationOutput;


@WebServlet("/HeatMapStoreRev")
public class HeatMapStoreRev extends HttpServlet {

    static DBCollection myReviews;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
			
			ArrayList<Review> reviews = MongoDBDataStoreUtilities.allreviews();
			HashMap<Integer,coordinate> pin_cord = new HashMap<>();
			pin_cord.put(60621,new coordinate(41.849457, -87.634873));
			pin_cord.put(60353,new coordinate(41.853586, -87.628960));
			pin_cord.put(60051,new coordinate(41.862159, -87.650808));
			pin_cord.put(600345,new coordinate(41.821659, -87.618667));
			pin_cord.put(60134,new coordinate(41.883927, -87.625694));
			
			HashMap<coordinate,Integer> map = new HashMap<>();
            
			for(int i=0;i<reviews.size();i++){
                int pin = Integer.valueOf(reviews.get(i).getRetailerPin());
				System.out.println(pin);
				if(!pin_cord.containsKey(pin)){
					continue;
				}
				coordinate temp = pin_cord.get(pin);
				map.put(temp,map.getOrDefault(temp,0)+1);
			}
			
			ArrayList<coordinate> data1 = new ArrayList<>();
			
			for(Map.Entry<coordinate,Integer> entry : map.entrySet()){
				coordinate key = entry.getKey();
				key.weight = entry.getValue();
				data1.add(key);
			}
			System.out.println(data1);
			
            String reviewJson = new Gson().toJson(data1);

            response.setContentType("application/JSON");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(reviewJson);

        } catch (Exception ex) {
            
        }

    }

}