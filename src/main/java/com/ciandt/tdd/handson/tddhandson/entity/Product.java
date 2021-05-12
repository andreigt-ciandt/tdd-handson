package com.ciandt.tdd.handson.tddhandson.entity;

public class Product {

    private int id;
    private String name;
    private int quantity;
    private User createdBy;

    public Product(int id, String name, int quantity, User createdBy) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    public User getCreatedBy() {
        return createdBy;
    }

    public static  Product createProduct(final String name, final int quantity, final User createdBy) {
        return new Product(0, name, quantity, createdBy);
    }
}
