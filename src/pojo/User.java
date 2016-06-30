package pojo;

public class User {
    private String email;
    private String username;
    private String password;
    private boolean isCustomer;
    
    public User(){
    }
    
    public User(String email, String username, String password) {
        this();
        this.email = email;
        this.username = username;
        this.password = password;
        this.isCustomer=false;
    }
    
    public User(String email, String username, String password, boolean isCustomer) {
        this(email, username, password);
        this.isCustomer = isCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }
}

