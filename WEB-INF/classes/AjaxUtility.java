import java.io.*;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;

import java.sql.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.*;



public class AjaxUtility{
	StringBuffer sb = new StringBuffer();
	boolean namesAdded = false;
	static Connection conn = null;
	static String message;
	
	public static String getConnection()
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
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
			 message="unsuccessful";
		     return message;
		}
	}
	
	public  StringBuffer readdata(String searchId)
	{	
		HashMap<String,Product> data;
		data=getData();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				Product p=(Product)pi.getValue();                   
                if (p.getProductname().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getProductid() + "</id>");
                        sb.append("<productName>" + p.getProductname() + "</productName>");
                        sb.append("</product>");
                }
			}
       }
	  
	   return sb;
	}
	public  StringBuffer readdata1(String searchId)
	{	
		HashMap<String,Product> data;
		data=getData1();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				Product p=(Product)pi.getValue();                   
                if (p.getProductname().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getProductid() + "</id>");
                        sb.append("<productName>" + p.getProductname() + "</productName>");
                        sb.append("</product>");
                }
			}
       }
	  
	   return sb;
	}
	public  StringBuffer readdata2(String searchId)
	{	
		HashMap<String,Product> data;
		data=getData2();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				Product p=(Product)pi.getValue();                   
                if (p.getProductname().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getProductid() + "</id>");
                        sb.append("<productName>" + p.getProductname() + "</productName>");
                        sb.append("</product>");
                }
			}
       }
	  
	   return sb;
	}
	public  StringBuffer readdata3(String searchId)
	{	
		HashMap<String,Product> data;
		data=getData3();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				Product p=(Product)pi.getValue();                   
                if (p.getProductname().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getProductid() + "</id>");
                        sb.append("<productName>" + p.getProductname() + "</productName>");
                        sb.append("</product>");
                }
			}
       }
	  
	   return sb;
	}

	public  StringBuffer readdata4(String searchId)
	{	
		HashMap<String,Product> data;
		data=getData4();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				Product p=(Product)pi.getValue();                   
                if (p.getProductname().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getProductid() + "</id>");
                        sb.append("<productName>" + p.getProductname() + "</productName>");
                        sb.append("</product>");
                }
			}
       }
	  
	   return sb;
	}
	
	public static HashMap<String,Product> getData()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();

		
		try
		{
			getConnection();
			
		    String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s1='YES';";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
	}

	public static HashMap<String,Product> getData1()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();

		
		try
		{
			getConnection();
			
		    String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s2='YES';";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
	}

	public static HashMap<String,Product> getData2()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();

		
		try
		{
			getConnection();
			
		    String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s3='YES';";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
	}

	public static HashMap<String,Product> getData3()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();

		
		try
		{
			getConnection();
			
		    String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s4='YES';";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
	}

	public static HashMap<String,Product> getData4()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();

		
		try
		{
			getConnection();
			
		    String selectproduct="SELECT `Index`, ProductId, ProductName, Image, Price, Discount, Category, Number_Of_Items, Weight FROM groceryhub.product_details where s5='YES';";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	Product p = new Product(rs.getInt("Index"), rs.getString("ProductId"), rs.getString("ProductName"), rs.getString("Image"), rs.getDouble("Price"),rs.getDouble("Discount"),rs.getString("Category"),rs.getInt("Number_Of_Items"),rs.getString("Weight"));
			hm.put(rs.getString("ProductId"), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
	}

}
