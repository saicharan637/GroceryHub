import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.AggregationOutput;
import java.util.*;

public class MongoDBDataStoreUtilities
{
	static DBCollection groceryhub;
	public static DBCollection getConnection()
	{
		MongoClient mongo;
		mongo = new MongoClient("localhost", 27017);

		DB db = mongo.getDB("CustomerReviews");
		groceryhub= db.getCollection("groceryhub");	
		return groceryhub; 
	}

	public static String insertReview(String productName, String username, String category, int StoreZip, String reviewRating, String reviewDate, String reviewText, Double price, String image)
	{
		try
		{		
			getConnection();
			BasicDBObject doc = new BasicDBObject("title", "groceryhub").
			append("productName", productName).
			append("userName", username).
			append("category", category).
			append("reviewRating",Integer.parseInt(reviewRating)).
			append("reviewDate", reviewDate).
			append("reviewText", reviewText).
			append("productPrice",price).
			append("storeZip", StoreZip).
			append("image", image);
			groceryhub.insert(doc);
			return "Successfull";
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("it is here the Exception");
			return "UnSuccessfull";
		}	
	}

	public static HashMap<String, ArrayList<Review>> selectReview()
	{	
		HashMap<String, ArrayList<Review>> reviews=null;

		try
		{
			getConnection();
			DBCursor cursor = groceryhub.find();
			reviews=new HashMap<String, ArrayList<Review>>();
			while (cursor.hasNext())
			{
				BasicDBObject obj = (BasicDBObject) cursor.next();				

				if(!reviews.containsKey(obj.getString("productName")))
				{	
					ArrayList<Review> arr = new ArrayList<Review>();
					reviews.put(obj.getString("productName"), arr);
				}
				ArrayList<Review> listReview = reviews.get(obj.getString("productName"));		
				Review review =new Review(obj.getString("productName"),obj.getString("userName"),obj.getString("category"),obj.getString("reviewRating"),obj.getString("reviewDate"),obj.getString("reviewText"),obj.getDouble("productPrice"),obj.getString("storeZip"));

			//add to review hashmap
				listReview.add(review);

			}
			
		}
		catch(Exception e)
		{
			reviews=null;
			System.out.println("the Exception in selectReview is "+e);
			System.out.println(e.toString()); 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 

            // Prints what exception has been thrown 
			System.out.println(e); 
		}	
		return reviews;	
	}

	public static  ArrayList <Bestrating> topProducts(){
		ArrayList <Bestrating> Bestrate = new ArrayList <Bestrating> ();
		try{

			getConnection();
			int retlimit =5;
			DBObject sort = new BasicDBObject();
			sort.put("reviewRating",-1);
			DBCursor cursor = groceryhub.find().limit(retlimit).sort(sort);
			while(cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();

				String prodcutnm = obj.get("productName").toString();
				String rating = obj.get("reviewRating").toString();
				String image = obj.get("image").toString();
				String price = obj.get("productPrice").toString();
				Bestrating best = new Bestrating(prodcutnm,rating,image,price);
				Bestrate.add(best);
			}

		}catch (Exception e){ 
			System.out.println("the exception in topProducts is "+e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return Bestrate;
	}
	
	public static ArrayList < Review > allreviews() {
        ArrayList < Review > Bestrate = new ArrayList < Review > ();
        try {

            getConnection();
            DBObject sort = new BasicDBObject();
            sort.put("reviewRating", -1);
            DBCursor cursor = groceryhub.find();
            while (cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();

                String prodcutnm = obj.get("productName").toString();
                String rating = obj.get("reviewRating").toString();
				String pin = obj.get("storeZip").toString();
                Bestrate.add(new Review(prodcutnm,pin,rating));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Bestrate;
    }

	
}	