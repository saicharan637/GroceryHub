import java.io.Serializable;


public class MostSoldProducts implements Serializable {
    private String  productName;
    private String count;
    private String price;
    private String image;

    public MostSoldProducts(String productName, String price, String image, String count) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    @Override
    public String toString() {
        return "MostSoldProducts [productName=" + productName + ", count=" + count + ", price=" + price + ", image="
        + image + "]";
    }
}