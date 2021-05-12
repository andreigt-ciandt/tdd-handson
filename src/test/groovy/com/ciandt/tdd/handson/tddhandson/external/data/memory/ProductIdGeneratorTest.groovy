package com.ciandt.tdd.handson.tddhandson.external.data.memory

import spock.lang.Specification

class ProductIdGeneratorTest extends Specification {

    ProductIdGenerator productIdGenerator = new ProductIdGenerator()

    def "Generates id"() {
        when: "a new id is requested"
        def result = productIdGenerator.createId()

        then: "an integer id is returned"
        result == 1
    }
}
