package com.ciandt.tdd.handson.tddhandson.usecase;

import com.ciandt.tdd.handson.tddhandson.entity.User;
import com.ciandt.tdd.handson.tddhandson.exception.HandsOnServerException;
import com.ciandt.tdd.handson.tddhandson.external.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncludeUser {

    private final UserRepository userRepository;

    public IncludeUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        try {
            userRepository.insert(user);
        } catch (RuntimeException e) {
            throw new HandsOnServerException(e);
        }
    }

}
