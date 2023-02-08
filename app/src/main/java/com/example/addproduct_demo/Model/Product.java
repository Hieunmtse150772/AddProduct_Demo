package com.example.addproduct_demo.Model;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public String price;
    public String productID;
    public String maker;
    public String quantity;
    public Product(String productID, String name, String price, String quantity, String maker) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.maker = maker;
        this.quantity = quantity;

    }

}
