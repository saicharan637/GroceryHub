import java.io.Serializable;


public class StoreInfo implements Serializable {
    private String  storeID;
    private String storeAddress;
    private int storeZIP;
    private String storeName;
    private String storeLatLang;

    public StoreInfo(String storeID, String storeName, String storeAddress, int storeZIP, String storeLatLang) {
        this.storeID = storeID;
        this.storeAddress = storeAddress;
        this.storeZIP = storeZIP;
        this.storeName = storeName;
        this.storeLatLang = storeLatLang;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreZIP() {
        return storeZIP;
    }

    public void setStoreZIP(int storeZIP) {
        this.storeZIP = storeZIP;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreLatLang() {
        return storeLatLang;
    }

}
