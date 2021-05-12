package com.ciandt.tdd.handson.tddhandson.exception

import spock.lang.Specification

class ForbiddenUserExceptionTest extends Specification {

    def "create exception"() {
        when: "exception is created"
        def exception = new ForbiddenUserException(new RuntimeException())
        then: "exception is valid"
        exception != null
    }

}
