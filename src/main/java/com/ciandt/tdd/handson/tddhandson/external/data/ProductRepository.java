package com.ciandt.tdd.handson.tddhandson.external.data;

import com.ciandt.tdd.handson.tddhandson.entity.Product;

public interface ProductRepository {

    void insert(Product product);

    Product findById(int id);

}
