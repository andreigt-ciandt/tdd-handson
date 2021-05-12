package com.ciandt.tdd.handson.tddhandson.external.data.exception

import spock.lang.Specification

class UserNotFoundExceptionTest extends Specification {
    def "the UserNotFoundException should tell the user id"() {
        given: "id not found"
        def id = 1567

        when: "a user not found exception is created"
        def exception = new UserNotFoundException(id)

        then: "the message should tell the user id which wasn't found"
        exception.message == "User not found for the given id: 1567";
    }
}
