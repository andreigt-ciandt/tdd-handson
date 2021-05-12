package com.ciandt.tdd.handson.tddhandson.exception

import spock.lang.Specification

class HandsOnServerExceptionTest extends Specification {

    def "create exception"() {
        when: "exception is created"
        def exception = new HandsOnServerException(new RuntimeException())
        then: "exception is valid"
        exception != null
    }

}
