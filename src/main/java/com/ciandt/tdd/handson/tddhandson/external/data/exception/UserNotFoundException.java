package com.ciandt.tdd.handson.tddhandson.external.data.exception;

public class UserNotFoundException extends RuntimeException {
    int userId;

    public UserNotFoundException(int userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "User not found for the given id: " + userId;
    }
}
