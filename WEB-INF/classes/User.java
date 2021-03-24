import java.io.Serializable;


public class User implements Serializable {
    /**
     * 
     */
    private String userName;
    private String password;
    private String email;
    private String usertype;
    
    public User(String userName, String password, String usertype) {
        this.userName = userName;
        this.password = password;
        this.usertype = usertype;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}