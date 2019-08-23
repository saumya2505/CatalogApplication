package com.example.catalog.Model;

public class User {

    private String userID;
    private String storeID;
    private String RoleID;
    private String username;
    private String password;
    private String contactNo;
    private boolean isActive;
    private String name;
    private String email;
    private String address;
    private String gender;



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getUserID() {
        return userID;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setRoleID(String roleID) {
        RoleID = roleID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
