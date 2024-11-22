package com.example.pizza_laba;

public class Pizza {
    private final String name, weight, size, price;
    private final int image;

    public Pizza(String name, String weight, String size, String price, int image) {
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
