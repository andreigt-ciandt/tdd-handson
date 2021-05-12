package com.ciandt.tdd.handson.tddhandson.external.data.memory;

public class UserIdGenerator {
    private int currentId = 1;
    public int createId() {
        return currentId++;
    }
}
