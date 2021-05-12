package com.ciandt.tdd.handson.tddhandson.external.data.memory

import com.ciandt.tdd.handson.tddhandson.entity.Departament
import com.ciandt.tdd.handson.tddhandson.entity.User
import com.ciandt.tdd.handson.tddhandson.external.data.exception.UserNotFoundException
import spock.lang.Specification

class UserInMemoryRepositoryTest extends Specification {
    UserIdGenerator userIdGenerator = Mock()
    UserInMemoryRepository userInMemoryRepository = new UserInMemoryRepository(userIdGenerator)

    def setup() {
        userInMemoryRepository.userList = []
    }

    def "should add an user to memory"() {
        given: "an user named teste from the sales departament"
        def name = "teste"
        def departament = Departament.SALES
        def user = User.createUser(name, departament)

        and: "an expected new id"
        def id = 123;

        when: "the user is inserted"
        userInMemoryRepository.insert(user)

        then: "no exception occurs in operation"
        noExceptionThrown()

        and: "a new id is generated to the user"
        1 * userIdGenerator.createId() >> id

        and: "internal list has the new user with the expected id"
        userInMemoryRepository.userList.any {
            it.id == id &&
            it.name == name &&
            it.departament == departament
        }
    }

    def "should find user by id"() {
        given: "an user teste from the sales departament"
        def id = 123;
        def name = "teste"
        def departament = Departament.SALES
        def user = new User(id, name, departament)

        and: "the repository has this user"
        userInMemoryRepository.userList.add(user)

        when: "a user is requested by its id"
        def foundUser = userInMemoryRepository.findById(id)

        then: "the found user is as expected"
        foundUser != null
        foundUser.id == user.id
        foundUser.name == user.name
        foundUser.departament == foundUser.departament
    }

    def "user not found should throw an UserNotFoundExeception"() {
        given: "an random id"
        def id = 14569

        when: "a user is requested by its id"
        userInMemoryRepository.findById(id)

        then: "an UserNotFoundException should be thrown"
        thrown(UserNotFoundException)
    }

}
