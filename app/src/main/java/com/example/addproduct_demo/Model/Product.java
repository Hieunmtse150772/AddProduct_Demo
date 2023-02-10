package com.example.addproduct_demo.Model;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public int price;
    public String productID;
    public String maker;
    public int quantity;
    public Product(String productID, String name, int price, int quantity, String maker) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.maker = maker;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }

    public int getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    public int getQuantity() {
        return quantity;
    }

}
