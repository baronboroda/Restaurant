package com.zelenin.restaurant.beans;

public class Status {
    private Integer id;
    private String name;
    private String description;

    public Status() {}

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}