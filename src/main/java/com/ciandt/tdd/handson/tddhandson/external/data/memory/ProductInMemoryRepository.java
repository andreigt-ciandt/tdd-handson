package com.ciandt.tdd.handson.tddhandson.external.data.memory;

import com.ciandt.tdd.handson.tddhandson.entity.Product;
import com.ciandt.tdd.handson.tddhandson.entity.User;
import com.ciandt.tdd.handson.tddhandson.external.data.ProductRepository;
import com.ciandt.tdd.handson.tddhandson.external.data.exception.ProductNotFoundException;
import com.ciandt.tdd.handson.tddhandson.external.data.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductInMemoryRepository implements ProductRepository {

    private ProductIdGenerator productIdGenerator;

    public ProductInMemoryRepository(ProductIdGenerator productIdGenerator) {
        this.productIdGenerator = productIdGenerator;
    }

    List<Product> productList = new ArrayList<>();

    @Override
    public void insert(Product product) {
        product.setId(productIdGenerator.createId());
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
