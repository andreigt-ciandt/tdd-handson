package com.ciandt.tdd.handson.tddhandson.entity

import spock.lang.Specification

class ProductTest extends Specification {
    def "CreateProduct"() {
        given: "product info"
        def name = "produto"
        def quantity = 100
        def userId = 123
        def user = new User(userId, "teste", Departament.MANAGEMENT)

        when: "product is created"
        Product product = Product.createProduct(name, quantity, user)

        then: "a product is created"
        product.id == 0
        product.name == name
        product.quantity == quantity
        product.createdBy.id == userId
    }
}
