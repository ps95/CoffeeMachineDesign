package com.coffeedesign.Stock;

public abstract class Ingredient {

    public String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // quantity will be same as https://www.npoint.io/docs/e8cd5a9bbd1331de326a. Not taking this as input for now. Can be extended to read from JSON and populate.
    public int quantity;

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
