package com.ciandt.tdd.handson.tddhandson.external.data.memory;

import org.springframework.stereotype.Component;

@Component
public class ProductIdGenerator {
    private int currentId = 1;
    public int createId() {
        return currentId++;
    }
}
