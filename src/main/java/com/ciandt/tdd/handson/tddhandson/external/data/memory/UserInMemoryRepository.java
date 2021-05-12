package com.ciandt.tdd.handson.tddhandson.external.data.memory;

import com.ciandt.tdd.handson.tddhandson.entity.User;
import com.ciandt.tdd.handson.tddhandson.external.data.UserRepository;
import com.ciandt.tdd.handson.tddhandson.external.data.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryRepository implements UserRepository {

    private UserIdGenerator userIdGenerator;

    public UserInMemoryRepository(UserIdGenerator userIdGenerator) {
        this.userIdGenerator = userIdGenerator;
    }

    List<User> userList = new ArrayList<>();

    @Override
    public void insert(User user) {
        user.setId(userIdGenerator.createId());
        userList.add(user);
    }

    @Override
    public User findById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException(id));
    }
}
