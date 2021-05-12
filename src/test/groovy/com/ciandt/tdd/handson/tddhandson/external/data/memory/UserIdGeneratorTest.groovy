package com.ciandt.tdd.handson.tddhandson.external.data.memory

import spock.lang.Specification

class UserIdGeneratorTest extends Specification {

    UserIdGenerator userIdGenerator = new UserIdGenerator()

    def "Generates id"() {
        when: "a new id is requested"
        def result = userIdGenerator.createId()

        then: "an integer id is returned"
        result == 1

    }
}
