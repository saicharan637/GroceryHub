import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Product extends HttpServlet {
    
    private int index;
    private String productid;
    private String productname;
    private String image;
    private double price;
    private double discount;
    private String category;
    private int number_of_items;
    private String weight;

    public Product(int index, String productid, String productname, String image, double price, double discount,String category, int number_of_items, String weight) {
        this.index = index;
        this.productid = productid;
        this.productname = productname;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.number_of_items = number_of_items;
        this.weight = weight;
    }

    public Product(String productid, String productname, String image, double price) {
        this.productid = productid;
        this.productname = productname;
        this.image = image;
        this.price = price;
    }
    public Product(String productid, String productname,double price, String image) {
        this.productid = productid;
        this.productname = productname;
        this.image = image;
        this.price = price;
    }
     public Product(String productname,double price, String image) {
        this.productname = productname;
        this.image = image;
        this.price = price;
    }

    public Product(){   
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getProductid() {
        return productid;
    }
    public void setProductid(String productid) {
        this.productid = productid;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getNumber_of_items() {
        return number_of_items;
    }
    public void setNumber_of_items(int number_of_items) {
        this.number_of_items = number_of_items;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Product [index=" + index + ", productid=" + productid + ", productname=" + productname + ", image="
        + image + ", price=" + price + ", discount=" + discount + ", category=" + category
        + ", number_of_items=" + number_of_items + ", weight=" + weight + "]";
    }

}