package com.ciandt.tdd.handson.tddhandson.exception

import spock.lang.Specification

class HandsOnBusinessExceptionTest extends Specification {

    def "create exception"() {
        when: "exception is created"
        def exception = new HandsOnBusinessException(new RuntimeException())
        then: "exception is valid"
        exception != null
    }

}
