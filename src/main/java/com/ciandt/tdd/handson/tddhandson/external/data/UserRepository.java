package com.ciandt.tdd.handson.tddhandson.external.data;

import com.ciandt.tdd.handson.tddhandson.entity.User;

public interface UserRepository {

    void insert(User user);

    User findById(int id);

}
