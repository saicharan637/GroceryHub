import java.io.IOException;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;

/* 
    Review class contains class variables username,productname,reviewtext,reviewdate,reviewrating

    Review class has a constructor with Arguments username,productname,reviewtext,reviewdate,reviewrating
      
    Review class contains getters and setters for username,productname,reviewtext,reviewdate,reviewrating
*/

    public class Review implements Serializable{
       private String productName;
       private String username;
       private String category;
       private String reviewRating;
       private String reviewDate;
       private String reviewText;
       private Double price;
       private String storeid;
       private int storezip;
       private String retailerpin;
       
       public Review(String productName, String username, String category, String reviewRating, String reviewDate, String reviewText, Double price, String storeid) {
        this.productName = productName;
        this.username = username;
        this.category = category;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.price = price;
        this.storeid = storeid;
    }
    public Review(String productName, String username, String category, int storezip, String reviewRating, String reviewDate, String reviewText, Double price, String storeid) {
        this.productName = productName;
        this.username = username;
        this.category = category;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.price = price;
        this.storeid = storeid;
    }
    public Review(String productName, String retailerpin, String reviewRating) {
        this.productName = productName;
        this.retailerpin = retailerpin;
        this.reviewRating = reviewRating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }
    public int getZip() {
        return storezip;
    }

    public String getRetailerPin() {
        return retailerpin;
    }

    @Override
    public String toString() {
        return "Review [productName=" + productName + ", username=" + username + ", category=" + category
        + ", reviewRating=" + reviewRating + ", reviewDate=" + reviewDate + ", reviewText=" + reviewText
        + ", price=" + price + ", storeid=" + storeid + "]";
    }
    


}