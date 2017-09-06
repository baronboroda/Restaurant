package com.zelenin.restaurant.beans;

public class UserAccount {
    private Integer id;
    private Integer userTypeId;
    private String name;
    private String password; // remake to hash-code with salt

    public UserAccount() {}

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeID(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getId() {
        return id;
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
}
