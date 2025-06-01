package entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private Role role;
    private boolean active;
    private String address;

    
    public User() {
    }
    
    public User(int id, String address, String fullName, String email, Role role, boolean active) {
        this.id = id;
        this.address = address;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.active = active;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
} 