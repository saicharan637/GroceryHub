import java.io.Serializable;


public class LatestProducts implements Serializable {
    private String  productName;
    private String index;
    private String price;
    private String image;

    public LatestProducts(String index, String productName, String price, String image) {
        this.productName = productName;
        this.price = price;
        this.index = index;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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
        return "Review [productName=" + productName + ", index=" + index + ", price=" + price + ", image=" + image
        + "]";
    }
}