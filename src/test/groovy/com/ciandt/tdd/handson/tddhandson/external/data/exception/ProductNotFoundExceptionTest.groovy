package com.ciandt.tdd.handson.tddhandson.external.data.exception

import spock.lang.Specification

class ProductNotFoundExceptionTest extends Specification {
    def "the ProductNotFoundException should tell the user id"() {
        given: "id not found"
        def id = 1567

        when: "a user not found exception is created"
        def exception = new ProductNotFoundException(id)

        then: "the message should tell the user id which wasn't found"
        exception.message == "Product not found for the given id: 1567";
    }
}
