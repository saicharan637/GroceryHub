import java.io.*;
import java.time.LocalDate;

/* 
	OrderPayment class contains class variables username,ordername,price,image,address,creditcardno.

	OrderPayment  class has a constructor with Arguments username,ordername,price,image,address,creditcardno
	  
	OrderPayment  class contains getters and setters for username,ordername,price,image,address,creditcardno
*/

public class OrderPayment implements Serializable {
    private int orderId;
    private String userName;
    private String emailId;
    private String firstname;
    private String lastname;
    private String customerAddress;
    private long customerZip;
    private long customerphone;
    private String productId;
    private String productName;
    private int no_of_items;
    private String category;
    private double productSubTotal;
    private String productWeight;
    private double orderTotal;
    private String storeId;
    private String storeAddress;
    private long storeZip;
    private String deliveryType;
    private LocalDate purchaseDate;
    private LocalDate expectedDeliveryDate;

    public OrderPayment(int orderId, String userName, String emailId, String firstname, String lastname, String customerAddress, long customerZip, long customerphone, String productId, String productName, int no_of_items, String category, double productSubTotal, String productWeight, double orderTotal, String storeId, String storeAddress, long storeZip, String deliveryType, LocalDate purchaseDate, LocalDate expectedDeliveryDate) {
        this.orderId = orderId;
        this.userName = userName;
        this.emailId = emailId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerAddress = customerAddress;
        this.customerZip = customerZip;
        this.customerphone = customerphone;
        this.productName = productName;
        this.no_of_items = no_of_items;
        this.category = category;
        this.productSubTotal = productSubTotal;
        this.productWeight = productWeight;
        this.orderTotal = orderTotal;
        this.storeId = storeId;
        this.productId = productId;
        this.storeAddress = storeAddress;
        this.storeZip = storeZip;
        this.deliveryType = deliveryType;
        this.purchaseDate = purchaseDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public OrderPayment(long customerZip){
        this.customerZip = customerZip;
    }

    public OrderPayment(LocalDate purchaseDate, double orderTotal ){
        this.purchaseDate = purchaseDate;
        this.orderTotal = orderTotal;
    }
    public OrderPayment(String productName, int no_of_items){
        this.productName = productName;
        this.no_of_items = no_of_items;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getProductId() {
        return productId;
    }

    public long getCustomerPhone() {
        return customerphone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public long getCustomerZip() {
        return customerZip;
    }

    public String getProductName() {
        return productName;
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public String getCategory() {
        return category;
    }

    public double getProductSubTotal() {
        return productSubTotal;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public long getStoreZip() {
        return storeZip;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }
}
