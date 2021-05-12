package com.ciandt.tdd.handson.tddhandson.external.data.exception;

public class ProductNotFoundException extends RuntimeException {
    int productId;

    public ProductNotFoundException(int productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return "Product not found for the given id: " + productId;
    }
}
