package com.miit.ass2;

public class Category {

    private static long id;

    private String name;

    private ProductDiscount discount;

    public Category(String name){
        this.name = name;
        id++;
    }

    public static long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDiscount getProductDiscount() {
        return discount;
    }

    public void setDiscount(ProductDiscount discount) {
        this.discount = discount;
    }
}
