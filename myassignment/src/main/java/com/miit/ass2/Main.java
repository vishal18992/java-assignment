package com.miit.ass2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductDiscount discount10 = new ProductDiscount("10%", 10);
        ProductDiscount discount20 = new ProductDiscount("20%", 20);

        Category categoryElectric = new Category("ELECTRIC");
        categoryElectric.setDiscount(discount10);

        Category categoryCloth = new Category("CLOTH");
        categoryCloth.setDiscount(discount20);

        Product iphone14 = new Product("Iphone 14 Max 128 GB", "Black");
        iphone14.setPrice(1500);
        iphone14.setCategory(categoryElectric);

        Product pods = new Product("AirPod", "White");
        pods.setPrice(399.00F);
        pods.setCategory(categoryElectric);


        List<Product> products = new ArrayList<>();
        products.add(iphone14);
        products.add(pods);

        float total = products.stream().map(Product::getDiscountPrice).reduce(0.00F, Float::sum);
        System.out.println(total);





    }
}
