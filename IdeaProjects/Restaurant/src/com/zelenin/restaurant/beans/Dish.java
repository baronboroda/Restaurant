package com.zelenin.restaurant.beans;

import java.math.BigDecimal;

public class Dish {
    private Integer id;
    private String name;
    private String unitName;
    private Float quantity;
    private String categoryName;
    private BigDecimal price;

    public Dish() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName (String unitName) {
        this.unitName = unitName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryId) {
        this.categoryName = categoryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
