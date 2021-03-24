import java.io.*;
public class Bestrating
{
	String productname ;
	String rating;
	String image;
	String price;

	public  Bestrating(String productname,String rating,String image,String price)
	{
		
		this.productname = productname ;
		this.rating = rating;
		this.image = image;
		this.price = price;
	}
	public  Bestrating(String productname,String price,String image)
	{
		
		this.productname = productname ;
		this.price = price;
		this.image = image;
		
	}


	public String getProductname(){
		return productname;
	}

	public String getRating() {
		return rating;
	}

	public String getImage() {
		return image;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Bestrating [productname=" + productname + ", rating=" + rating + ", image=" + image + ", price=" + price
		+ "]";
	}


}