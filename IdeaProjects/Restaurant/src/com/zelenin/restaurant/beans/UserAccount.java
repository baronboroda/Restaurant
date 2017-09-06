package com.zelenin.restaurant.beans;

public class UserAccount {
    private Integer id;
    private String userTypeName;
    private String name;
    private String password; // remake to hash-code with salt

    public UserAccount() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "user: " + getName() + "; type: " + getUserTypeName();
    }
}
