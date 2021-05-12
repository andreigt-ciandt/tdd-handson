package com.ciandt.tdd.handson.tddhandson;

import com.ciandt.tdd.handson.tddhandson.entity.Departament;
import com.ciandt.tdd.handson.tddhandson.entity.User;
import com.ciandt.tdd.handson.tddhandson.external.data.UserRepository;
import com.ciandt.tdd.handson.tddhandson.usecase.IncludeUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddHandsonApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	IncludeUser includeUser;

	@Autowired
	UserRepository userRepository;

	@Test
	void validaIncludeUser() {
		final User user = User.createUser("Andrei", Departament.SALES);
		includeUser.execute(user);

		User foundUser = userRepository.findById(1);

		Assert.assertEquals(foundUser.getName(), user.getName());
		Assert.assertEquals(foundUser.getDepartament(), user.getDepartament());
	}
}
