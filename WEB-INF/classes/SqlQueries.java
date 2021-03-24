import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;


public class SqlQueries{
	
	static Connection conn = null;
	static String message;

	public static String getConnection()
	{

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/groceryhub","root","mausam123");							
			message="Successfull";
			return message;
		}
		catch(SQLException e)
		{
			message="unsuccessful";
			return message;
		}
		catch(Exception e)
		{
			message=e.getMessage();
			return message;
		}
	}

	public static void insertUser(String username, String email, String password,String usertype)
	{
		try
		{	
			getConnection();
			String insertIntoCustomerRegisterQuery = "INSERT INTO registration(username,email,password,usertype)"
			+ "VALUES (?,?,?,?);";	
			
			
			PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
			pst.setString(1,username);
			pst.setString(2,email);
			pst.setString(3,password);
			pst.setString(4, usertype);
			
			pst.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}	
	}



	public static HashMap<String,User> selectUser()
	{	
		HashMap<String,User> hm=new HashMap<String,User>();
		try 
		{
			getConnection();
			Statement stmt=conn.createStatement();
			String selectCustomerQuery="select * from  Registration";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
				{	User user = new User(rs.getString("username"),rs.getString("password"),rs.getString("usertype"));
			hm.put(rs.getString("username"), user);
		}
	}
	catch(Exception e)
	{
		
	}
	return hm;			
}

public static void SaveAddress(String username, String address, int zipcode) {
	try {
		getConnection();
		String insertIntoCustomerRegisterQuery = "INSERT INTO registration(address=?, zipcode=?) where username=? ";
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
		pst.setString(1,address);
		pst.setInt(2,zipcode);
		pst.setString(3,username);
		pst.execute();
	} catch (Exception e) {
		System.out.println(e);
		//TODO: handle exception
	}
}

public static ArrayList<StoreInfo> SelectStoreInfo(){
	ArrayList<StoreInfo> storeList = new ArrayList<StoreInfo>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * from storelist";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			StoreInfo stores = new StoreInfo(rs.getString("StoreID"), rs.getString("StoreName"), rs.getString("StoreAddress"), rs.getInt("StoreZip"), rs.getString("StoreLatLang"));
			storeList.add(stores);
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	return storeList;
}

public static ArrayList<Product> selectfruits(){
	ArrayList<Product> fruits = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='Fruits&Vegetables';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			fruits.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectfruits is"+e);
	}
	return fruits;
}
public static ArrayList<Product> selectdairys(){
	ArrayList<Product> dairys = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='Dairy&Bakery';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			dairys.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectdairys is"+e);
	}
	return dairys;
}

public static ArrayList<Product> selectmeats(){
	ArrayList<Product> meats = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='FreshMeat';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			meats.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectmeats is"+e);
	}
	return meats;
}

public static ArrayList<Product> selectfrozens(){
	ArrayList<Product> frozens = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='frozen';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			frozens.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectfrozens is"+e);
	}
	return frozens;
}

public static ArrayList<Product> selectcanneds(){
	ArrayList<Product> canneds = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='canned';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			canneds.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectcanneds is"+e);
	}
	return canneds;
}

public static ArrayList<Product> selectbeverages(){
	ArrayList<Product> beverages = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='Beverages';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			beverages.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectbeverages is"+e);
	}
	return beverages;
}

public static ArrayList<Product> selectpersonalcares(){
	ArrayList<Product> personalcares = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='Personal Care';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			personalcares.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectpersonalcares is"+e);
	}
	return personalcares;
}

public static ArrayList<Product> selecthomecares(){
	ArrayList<Product> homecares = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details where Category='Home Care';";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			homecares.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selecthomecares is"+e);
	}
	return homecares;
}

public static HashMap<String,Product> getfruits()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		// SELECT * FROM product_details where Category='Fruits&Vegetables';
		
		String selectFruit="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectFruit);
		pst.setString(1,"Fruits&Vegetables");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
			{	Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
		hm.put(rs.getString("ProductId"), pds);
		pds.setProductid(rs.getString("ProductId"));
	}
}
catch(Exception e)
{
	System.out.println("the exception in getfruitsc is "+e);
}
return hm;			
}

public static HashMap<String,Product> getdairys()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectDairy="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectDairy);
		pst.setString(1,"Dairy&Bakery");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getdairys is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> getmeats()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectMeat="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectMeat);
		pst.setString(1,"FreshMeat");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getmeats is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> getfrozens()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectFrozen="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectFrozen);
		pst.setString(1,"frozen");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getfrozens is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> getcanneds()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectCanned="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectCanned);
		pst.setString(1,"canned");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getcanneds is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> getbeverages()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectBeverages="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectBeverages);
		pst.setString(1,"Beverages");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getbeverages is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> getpersonalcares()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectPersonalCare="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectPersonalCare);
		pst.setString(1,"Personal Care");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in getpersonalcares is "+e);
	}
	return hm;			
}

public static HashMap<String,Product> gethomecares()
{	
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		String selectHomeCare="select * from  product_details where Category=?";
		PreparedStatement pst = conn.prepareStatement(selectHomeCare);
		pst.setString(1,"Home Care");
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), pds);
			pds.setProductid(rs.getString("ProductId"));
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception in gethomecares is "+e);
	}
	return hm;			
}
public static void insertOrder(int OrderId, String username, String EmailId, String firstname, String lastname, String customerAddress, long customerZip, long creditCardNo, long phone, String orderNotes, String productId, String productName, double priceperprod, int no_of_items, String category, double productSubTotal, String productWeight, double orderTotal, String image, String StoreId, String StoreAddress, long StoreZip, String deliveryType, LocalDate purchaseDate, LocalDate expectedDeliveryDate) 
{
	try {
		getConnection();
		String insertIntoCustomerOrderQuery = "INSERT INTO customerOrders(OrderId,username,emailid, firstname, lastname,customerAddress,customerZip,customerPhoneNo,orderNotes,creditCardNo, productId, productName, pricePerItem,no_of_items,category,productSubTotal,productWeight,orderTotal,prodImg,StoreId,StoreAddress,StoreZip,deliveryType, purchaseDate, expectedDeliveryDate)"
		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);

		Date pdate = Date.valueOf(purchaseDate);
		Date edate = Date.valueOf(expectedDeliveryDate);
		pst.setInt(1,OrderId);
		pst.setString(2,username);
		pst.setString(3, EmailId);
		pst.setString(4,firstname);
		pst.setString(5,lastname);
		pst.setString(6,customerAddress);
		pst.setLong(7,customerZip);
		pst.setLong(8, phone);
		pst.setString(9,orderNotes);
		pst.setLong(10, creditCardNo);
		pst.setString(11, productId);
		pst.setString(12, productName);
		pst.setDouble(13,priceperprod);
		pst.setInt(14, no_of_items);
		pst.setString(15, category);
		pst.setDouble(16, productSubTotal);
		pst.setString(17, productWeight);
		pst.setDouble(18, orderTotal);
		pst.setString(19, image);
		pst.setString(20, StoreId);
		pst.setString(21, StoreAddress);
		pst.setLong(22, StoreZip);
		pst.setString(23, deliveryType);
		pst.setDate(24,pdate);
		pst.setDate(25,edate);
		pst.execute();
	}

	catch (Exception e) {
		System.out.println(e);
			//TODO: handle exception
	}
	
}

public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
{	

	HashMap<Integer, ArrayList<OrderPayment>> orderPayments=new HashMap<Integer, ArrayList<OrderPayment>>();
	
	try
	{					

		getConnection();
        //select the table 
		String selectOrderQuery ="select * from customerorders";			
		PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
		ResultSet rs = pst.executeQuery();	
		ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
		while(rs.next())
		{
			if(!orderPayments.containsKey(rs.getInt("OrderId")))
			{	
				ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
				orderPayments.put(rs.getInt("OrderId"), arr);
			}
			ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));
			
			//add to orderpayment hashmap
			OrderPayment order= new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("emailid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("customerAddress"),rs.getLong("customerZip"),rs.getLong("customerPhoneNo"),rs.getString("productId"),rs.getString("productName"),rs.getInt("no_of_items"),rs.getString("category"),rs.getDouble("productSubTotal"),rs.getString("productWeight"),rs.getDouble("orderTotal"),rs.getString("StoreId"),rs.getString("StoreAddress"),rs.getLong("StoreZip"), rs.getString("deliveryType"),rs.getDate("purchaseDate").toLocalDate(),rs.getDate("expectedDeliveryDate").toLocalDate());
			listOrderPayment.add(order);
		}
		
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	return orderPayments;
}
public static HashMap<Integer, ArrayList<OrderPayment>> selecStoreOrder(String username)
{	

	HashMap<Integer, ArrayList<OrderPayment>> orderPayments=new HashMap<Integer, ArrayList<OrderPayment>>();
	
	try
	{	
		String n = "";			
		if(username.equals("s1")){n="1";}
		else if(username.equals("s2")){n="2";}
		else if(username.equals("s3")){n="3";}
		else if(username.equals("s4")){n="4";}
		else if(username.equals("s5")){n="5";}

		getConnection();
        //select the table 
		String selectOrderQuery ="select * from customerorders where StoreId=?";			
		PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
		pst.setString(1,n);
		ResultSet rs = pst.executeQuery();	
		ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
		while(rs.next())
		{
			if(!orderPayments.containsKey(rs.getInt("OrderId")))
			{	
				ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
				orderPayments.put(rs.getInt("OrderId"), arr);
			}
			ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));
			
			//add to orderpayment hashmap
			OrderPayment order= new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("emailid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("customerAddress"),rs.getLong("customerZip"),rs.getLong("customerPhoneNo"),rs.getString("productId"),rs.getString("productName"),rs.getInt("no_of_items"),rs.getString("category"),rs.getDouble("productSubTotal"),rs.getString("productWeight"),rs.getDouble("orderTotal"),rs.getString("StoreId"),rs.getString("StoreAddress"),rs.getLong("StoreZip"), rs.getString("deliveryType"),rs.getDate("purchaseDate").toLocalDate(),rs.getDate("expectedDeliveryDate").toLocalDate());
			listOrderPayment.add(order);
		}
		
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	return orderPayments;
}

public static void updateQuantity(String Id, int quantity){
	try{
		getConnection();
		String updateCount = "UPDATE product_details set Number_Of_Items=? where ProductId=?";

		PreparedStatement pst = conn.prepareStatement(updateCount);
		pst.setInt(1,quantity);
		pst.setString(2,Id);
		pst.execute();
	} catch(Exception e){
		System.out.println(e);
	}
}
public static void SaveAddress(String username, String address, long zipcode){
	try{
		getConnection();
		String updateAddress = "UPDATE registration set address=?, zipcode=? where username=?";

		PreparedStatement pst = conn.prepareStatement(updateAddress);
		pst.setString(1,address);
		pst.setLong(2,zipcode);
		pst.setString(3, username);
		pst.execute();
	} catch(Exception e){
		System.out.println(e);
	}
}

public static String addproducts(String productId,String productName,String productImage,Double productPrice,double productDiscount,String productCategory,int numOfItems,String productWeight,String username)
{
	String msg = "Product is added successfully";
	try{
		String s1 = "NO", s2 = "NO", s3 = "NO", s4 = "NO", s5 = "NO";

		if(username.equals("s1")){s1 = "YES";}
		else if(username.equals("s2")){s2 = "YES";}
		else if(username.equals("s3")){s3 = "YES";}
		else if(username.equals("s4")){s4 = "YES";}
		else if(username.equals("s5")){s5 = "YES";}
		
		getConnection();
		String addProductQuery = "INSERT INTO  product_details(ProductId,ProductName,Image,Price,Discount,Category,Number_Of_Items,Weight,s1,s2,s3,s4,s5)" +
		"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement pst = conn.prepareStatement(addProductQuery);
		pst.setString(1,productId);
		pst.setString(2,productName);
		pst.setString(3,productImage);
		pst.setDouble(4,productPrice);
		pst.setDouble(5,productDiscount);
		pst.setString(6,productCategory);
		pst.setInt(7,numOfItems);
		pst.setString(8,productWeight);
		pst.setString(9,s1);
		pst.setString(10,s2);
		pst.setString(11,s3);
		pst.setString(12,s4);
		pst.setString(13,s5);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		msg = "Error while adding the product";
		e.printStackTrace();
	}
	return msg;
}

public static String updateproducts(String productId,String productName,String productImage,Double productPrice,double productDiscount,String productCategory,int numOfItems,String productWeight,String username)
{ 
	String msg = "Product has been successfully updated";
	try{
		String s1 = "NO", s2 = "NO", s3 = "NO", s4 = "NO", s5 = "NO";

		if(username.equals("s1")){s1 = "YES";}
		else if(username.equals("s2")){s2 = "YES";}
		else if(username.equals("s3")){s3 = "YES";}
		else if(username.equals("s4")){s4 = "YES";}
		else if(username.equals("s5")){s5 = "YES";}
		
		getConnection();
		String updateProductQuery = "UPDATE product_details SET ProductName=?,Image=?,Price=?,Discount=?,Category=?,Number_Of_Items=?,Weight=? where ProductId =? and s1=? and s2=? and s3=? and s4=? and s5=?;" ;
		
		PreparedStatement pst = conn.prepareStatement(updateProductQuery);
		
		pst.setString(1,productName);
		pst.setString(2,productImage);
		pst.setDouble(3,productPrice);
		pst.setDouble(4,productDiscount);
		pst.setString(5,productCategory);
		pst.setInt(6,numOfItems);
		pst.setString(7,productWeight);
		pst.setString(8,productId);
		pst.setString(9,s1);
		pst.setString(10,s2);
		pst.setString(11,s3);
		pst.setString(12,s4);
		pst.setString(13,s5);
		pst.executeUpdate();
		int i = pst.executeUpdate();
		if(i == 0)
		{
			msg = "Product cannot be updated";
		}
	}
	catch(Exception e)
	{
		msg = "Product cannot be updated";
		e.printStackTrace();
	}
	return msg;	
}

public static String deleteproducts(String productId,String username)
{   
	String msg = "Product has been successfully deleted";
	try
	{
		String s1 = "NO", s2 = "NO", s3 = "NO", s4 = "NO", s5 = "NO";

		if(username.equals("s1")){s1 = "YES";}
		else if(username.equals("s2")){s2 = "YES";}
		else if(username.equals("s3")){s3 = "YES";}
		else if(username.equals("s4")){s4 = "YES";}
		else if(username.equals("s5")){s5 = "YES";}
		
		getConnection();
		String deleteproductsQuery ="DELETE FROM product_details WHERE ProductId=? and s1=? and s2=? and s3=? and s4=? and s5=?";
		PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
		pst.setString(1,productId);
		pst.setString(2,s1);
		pst.setString(3,s2);
		pst.setString(4,s3);
		pst.setString(5,s4);
		pst.setString(6,s5);
		pst.executeUpdate();
		System.out.println("the query is "+pst.toString());
		if(pst.executeUpdate() == 0)
		{
			msg = "Product cannot be deleted";
			System.out.println("it is "+pst.executeUpdate());
		}
	}
	catch(Exception e)
	{
		System.out.println("this is the exception"+e);
	}
	System.out.println("the msg is this"+msg);
	return msg;
}
public static void deleteOrder(int orderId,String orderName)
{
	try
	{
		
		getConnection();
		String deleteOrderQuery ="Delete from customerorders where OrderId=? and productName=?";
		PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
		pst.setInt(1,orderId);
		pst.setString(2,orderName);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println("The Exception in deleteOrder is "+e);	
	}
}

public static ArrayList<MostSoldProducts> SelectMostSoldProducts(){
	ArrayList<MostSoldProducts> mostSoldList = new ArrayList<MostSoldProducts>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectmostsoldQuery = "SELECT productName, pricePerItem, prodImg, COUNT(ProductName) AS ct FROM customerorders GROUP BY ProductId ORDER BY ct DESC LIMIT 5";
		ResultSet rs = statement.executeQuery(selectmostsoldQuery);
		
		while(rs.next()){
			MostSoldProducts mostsold = new MostSoldProducts(rs.getString("productName"), rs.getString("pricePerItem"), rs.getString("prodImg"), rs.getString("ct"));
			mostSoldList.add(mostsold);
		}
	}
	catch(Exception e){
		System.out.println("the exception in SelectMostSoldProducts is "+e);
	}
	return mostSoldList;
}

public static ArrayList<LatestProducts> SelectLatestProducts(){
	ArrayList<LatestProducts> latestList = new ArrayList<LatestProducts>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectlatestQuery = "Select `Index`, ProductName, Price, Image from product_details ORDER BY `Index` DESC LIMIT 5";
		ResultSet rs = statement.executeQuery(selectlatestQuery);
		
		while(rs.next()){
			LatestProducts latest = new LatestProducts(rs.getString("Index"), rs.getString("ProductName"), rs.getString("Price"), rs.getString("Image"));
			latestList.add(latest);
		}
	}
	catch(Exception e){
		System.out.println("the exception in SelectLatestProducts is "+e);
	}
	return latestList;
}


public static String addAdminproducts(String productId,String productName,String productImage,Double productPrice,double productDiscount,String productCategory,int numOfItems,String productWeight,String s1,String s2,String s3,String s4,String s5)
{
	String msg = "Product is added successfully";
	try{
		
		getConnection();
		String addProductQuery = "INSERT INTO  product_details(ProductId,ProductName,Image,Price,Discount,Category,Number_Of_Items,Weight,s1,s2,s3,s4,s5)" +
		"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement pst = conn.prepareStatement(addProductQuery);
		pst.setString(1,productId);
		pst.setString(2,productName);
		pst.setString(3,productImage);
		pst.setDouble(4,productPrice);
		pst.setDouble(5,productDiscount);
		pst.setString(6,productCategory);
		pst.setInt(7,numOfItems);
		pst.setString(8,productWeight);
		pst.setString(9,s1);
		pst.setString(10,s2);
		pst.setString(11,s3);
		pst.setString(12,s4);
		pst.setString(13,s5);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		msg = "Error while adding the product";
		e.printStackTrace();
	}
	return msg;
}

public static String updateAdminproducts(String productId,String productName,String productImage,Double productPrice,double productDiscount,String productCategory,int numOfItems,String productWeight,String s1,String s2,String s3,String s4,String s5)
{ 
	String msg = "Product is updated successfully";
	try{
		
		getConnection();
		String updateProductQuery = "UPDATE product_details SET ProductName=?,Image=?,Price=?,Discount=?,Category=?,Number_Of_Items=?,Weight=?,s1=?, s2=?, s3=?, s4=?, s5=? where ProductId =?;" ;

		PreparedStatement pst = conn.prepareStatement(updateProductQuery);

		pst.setString(1,productName);
		pst.setString(2,productImage);
		pst.setDouble(3,productPrice);
		pst.setDouble(4,productDiscount);
		pst.setString(5,productCategory);
		pst.setInt(6,numOfItems);
		pst.setString(7,productWeight);
		pst.setString(8,s1);
		pst.setString(9,s2);
		pst.setString(10,s3);
		pst.setString(11,s4);
		pst.setString(12,s5);
		pst.setString(13,productId);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
		msg = "Product cannot be updated";
	}
	return msg;	
}
public static ArrayList<OrderPayment> ordrsHeatMapData(){
	ArrayList<OrderPayment> customerzip = new ArrayList<OrderPayment>();

	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT customerZip FROM groceryhub.customerorders group by OrderId;";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			OrderPayment order = new OrderPayment(rs.getLong("customerZip"));
			customerzip.add(order);
		}
	}
	catch(Exception e){
		System.out.println("the exception is"+e);
	}
	return customerzip;

}

public static String deleteAdminproducts(String productId)
{   String msg = "Product is deleted successfully";
try
{

	getConnection();
	String deleteproductsQuery ="Delete from product_details where ProductId=?";
	PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
	pst.setString(1,productId);
	pst.executeUpdate();
}
catch(Exception e)
{
	msg = "Proudct cannot be deleted";
}
return msg;
}
public static ArrayList<Product> selectAllProducts(){
	ArrayList<Product> prod = new ArrayList<Product>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT * FROM product_details;";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			Product pds = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			prod.add(pds);
		}
	}
	catch(Exception e){
		System.out.println("the exception in selectfruits is"+e);
	}
	return prod;
}
public static void insertStoreManager(String username, String email, String password, int storeid)
{
	try
	{	
		getConnection();
		String insertIntoCustomerRegisterQuery = "INSERT INTO registration(username,email,password,usertype,storeid)"
		+ "VALUES (?,?,?,?,?);";	
		
		
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
		pst.setString(1,username);
		pst.setString(2,email);
		pst.setString(3,password);
		pst.setString(4, "StoreManager");
		pst.setInt(5,storeid);
		pst.execute();
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}	
}


public static HashMap<String,Product> getData()
{
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try
	{
		getConnection();
		Statement stmt=conn.createStatement();
		String selectCustomerQuery="select * from  product_details";
		ResultSet rs = stmt.executeQuery(selectCustomerQuery);
		while(rs.next())
			{	Product p = new Product(rs.getString("ProductId"),rs.getString("ProductName"),rs.getString("Image"),rs.getDouble("Price"));
		hm.put(rs.getString("ProductName"), p);
	}
}
catch(Exception e)
{
	e.printStackTrace();	
}
return hm;			
}

public static ArrayList<OrderPayment> totalSalesinaDay(){
	ArrayList<OrderPayment> totalsales = new ArrayList<OrderPayment>();

	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT purchaseDate, sum(distinct(orderTotal)) as totalSales FROM groceryhub.customerorders group by purchaseDate";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			OrderPayment order = new OrderPayment(rs.getDate("purchaseDate").toLocalDate(), rs.getDouble("totalSales"));
			totalsales.add(order);
		}
	}
	catch(Exception e){
		System.out.println("the exception is"+e);
	}
	return totalsales;

}


public static ArrayList<OrderPayment> productsSold(){
	ArrayList<OrderPayment> totalsales = new ArrayList<OrderPayment>();

	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT productName, sum(no_of_items) as count FROM customerorders group by productName;";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			OrderPayment order = new OrderPayment(rs.getString("productName"), rs.getInt("count"));
			totalsales.add(order);
		}
	}
	catch(Exception e){
		System.out.println("the exception is"+e);
	}
	return totalsales;

}


public static ArrayList<OrderPayment> productStock(){
	ArrayList<OrderPayment> totalsales = new ArrayList<OrderPayment>();

	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT productName, Number_Of_Items FROM product_details;";
		ResultSet rs = statement.executeQuery(selectStoreQuery);
		
		while(rs.next()){
			OrderPayment order = new OrderPayment(rs.getString("productName"), rs.getInt("Number_Of_Items"));
			totalsales.add(order);
		}
	}
	catch(Exception e){
		System.out.println("the exception is"+e);
	}
	return totalsales;

}


public static ArrayList<Product> getStore1()
{
	ArrayList<Product> hm=new ArrayList<Product>();

	
	try
	{
		getConnection();
		
		String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s1='YES';";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{	
			Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.add(p);
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception is"+e);
	}
	return hm;			
}

public static ArrayList<Product> getStore2()
{
	ArrayList<Product> hm=new ArrayList<Product>();

	
	try
	{
		getConnection();
		
		String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s2='YES';";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{	
			Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.add(p);
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception is"+e);
	}
	return hm;			
}

public static ArrayList<Product> getStore3()
{
	ArrayList<Product> hm=new ArrayList<Product>();

	
	try
	{
		getConnection();
		
		String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s3='YES';";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{	
			Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.add(p);
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception is"+e);
	}
	return hm;			
}

public static ArrayList<Product> getStore4()
{
	ArrayList<Product> hm=new ArrayList<Product>();

	
	try
	{
		getConnection();
		
		String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s4='YES';";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{	
			Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.add(p);
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception is"+e);
	}
	return hm;			
}

public static ArrayList<Product> getStore5()
{
	ArrayList<Product> hm=new ArrayList<Product>();

	
	try
	{
		getConnection();
		
		String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s5='YES';";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{	
			Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.add(p);
		}
	}
	catch(Exception e)
	{
		System.out.println("the exception is"+e);
	}
	return hm;			
}

public static void insertProblem(String email, String name, String problem) {
	System.out.println(email);
	System.out.println(name);
	System.out.println(problem);
	try {
		getConnection();
		String insertProb = "Insert INTO customerfeedback(feedbackId,customerName,emailid,cproblem)"+"VALUES (?,?,?,?);";

		PreparedStatement pst = conn.prepareStatement(insertProb);
		pst.setString(1, UUID.randomUUID().toString());
		pst.setString(2,name);
		pst.setString(3,email);
		pst.setString(4,problem);

		pst.execute();


	} catch (Exception e) {
		System.out.println(e);
			//TODO: handle exception
	}


}


public static ArrayList<Feedback> getAllFeedback(){
	ArrayList<Feedback> feedback =new ArrayList<Feedback>();

	try
	{
		getConnection();

		String selectproduct="SELECT * FROM customerfeedback;";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			Feedback p = new Feedback(rs.getString("feedbackId"), rs.getString("customerName"), rs.getString("emailid"), rs.getString("cproblem"));
			feedback.add(p);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return feedback;
}

public static ArrayList<int[]> salebystore(){
	ArrayList<int[]> ans = new ArrayList<int[]>();
	try{
		getConnection();
		Statement statement = conn.createStatement();
		String selectStoreQuery = "SELECT b.StoreZip as storeid, count(*) as cnt FROM customerorders a inner join storelist b on a.StoreId=b.storeid group by 1";
		ResultSet rs = statement.executeQuery(selectStoreQuery);

		while(rs.next()){
			int[] temp = new int[]{Integer.valueOf(rs.getString("storeid")),rs.getInt("cnt")};
			ans.add(temp);
		}
	}
	catch(Exception e){System.out.print("exception is this "+e);}
	return ans;
}

public static ArrayList<int[]> getDelivery(){
	ArrayList<int[]> feedback =new ArrayList<int[]>();

	try
	{
		getConnection();

		String selectproduct="SELECT StoreZip, count(deliveryType) as count FROM customerorders where deliveryType='Store Pickup' group by StoreZip;";
		PreparedStatement pst = conn.prepareStatement(selectproduct);
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	
			int[] p = new int[]{rs.getInt("StoreZip"), rs.getInt("count")};
			feedback.add(p);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return feedback;
}




}