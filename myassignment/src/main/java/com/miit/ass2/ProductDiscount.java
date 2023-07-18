package com.miit.ass2;

public class ProductDiscount {
    private static long id;

    private String name;

    private float discount;

    public ProductDiscount(String name, float discount){
        this.name = name;
        this.discount = discount;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
