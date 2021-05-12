package com.ciandt.tdd.handson.tddhandson.external.data.memory

import com.ciandt.tdd.handson.tddhandson.entity.Departament
import com.ciandt.tdd.handson.tddhandson.entity.Product
import com.ciandt.tdd.handson.tddhandson.entity.User
import com.ciandt.tdd.handson.tddhandson.external.data.exception.ProductNotFoundException
import com.ciandt.tdd.handson.tddhandson.external.data.exception.UserNotFoundException
import spock.lang.Specification

class ProductInMemoryRepositoryTest extends Specification {

    ProductIdGenerator productIdGenerator = Mock()
    ProductInMemoryRepository productInMemoryRepository = new ProductInMemoryRepository(productIdGenerator)

    def setup() {
        productInMemoryRepository.productList = []
    }

    def "should add an product to memory"() {
        given: "an user named teste from the management departament"
        def user = new User(123, "teste", Departament.MANAGEMENT)

        and: "an expected new id"
        def id = 1234

        and: "a product"
        def name = "produto teste"
        def quantity = 100
        def product = Product.createProduct(name, quantity, user)

        when: "the user is inserted"
        productInMemoryRepository.insert(product)

        then: "no exception occurs in operation"
        noExceptionThrown()

        and: "a new id is generated to the product"
        1 * productIdGenerator.createId() >> id

        and: "internal list has the new product with the expected id"
        productInMemoryRepository.productList.any {
            it.id == id &&
            it.name == name &&
            it.quantity == quantity
            it.createdBy.id == user.id
        }
    }

    def "should find product by id"() {
        given: "a product"
        def id = 123;
        def name = "product name"
        def quantity = 100
        def product = new Product(id, name, quantity, null)

        and: "the repository has this product"
        productInMemoryRepository.productList = [ product ]

        when: "a product is requested by its id"
        def foundProduct = productInMemoryRepository.findById(id)

        then: "the found user is as expected"
        foundProduct != null
        foundProduct.id == id
        foundProduct.name == name
        foundProduct.quantity == quantity
    }

    def "product not found should throw an ProductNotFoundExeception"() {
        given: "an random id"
        def id = 14569

        when: "a product is requested by its id"
        productInMemoryRepository.findById(id)

        then: "an ProductNotFoundException should be thrown"
        thrown(ProductNotFoundException)
    }
}
