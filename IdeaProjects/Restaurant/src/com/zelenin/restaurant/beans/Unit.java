package com.zelenin.restaurant.beans;

public class Unit {
    private Integer id;
    private String name;
    private String keyword;

    public Unit() {}

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword(){
        return keyword;
    }

    public void setKeyWord(String description) {
        this.keyword = description;
    }
}
