package com.zelenin.restaurant.beans;

import java.math.BigDecimal;

public class Dish {
    private Integer id;
    private String name;
    private Integer unitId;
    private Float quantity;
    private Integer categoryId;
    private BigDecimal price;

    public Dish() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId (Integer unitId) {
        this.unitId = unitId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String  toString() {
        return name + "price = " + price;
    }
}
