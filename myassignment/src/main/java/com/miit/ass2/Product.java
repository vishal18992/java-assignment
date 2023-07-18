package com.miit.ass2;

import com.miit.Main;
import com.miit.ass2.Category;

public class Product {

    private static long id;
    private String name;
    private String description;
    private float price;
    private float discount;


    private Category category;

    public Product(){
        super();
        id++;
    }

    public Product(String name, String description){
        super();
        this.name = name;
        this.description = description;
        id++;
    }

    public Product(String name, String description, float price, float discount){
        super();
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public float getDiscountPrice(){
        float amount = 0;
        try {
            amount  = Math.max(0, this.price - (this.price * this.discount/100));
        }catch (ArithmeticException ex){
            ex.printStackTrace();
        }
        System.out.println("Discount Price Amount :- " + amount);
        return amount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        if(Float.compare(this.category.getProductDiscount().getDiscount(), 0) > 0){
            this.discount = this.category.getProductDiscount().getDiscount();
        }
    }
}
