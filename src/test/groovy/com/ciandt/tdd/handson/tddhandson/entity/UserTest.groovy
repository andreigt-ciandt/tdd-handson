package com.ciandt.tdd.handson.tddhandson.entity

import spock.lang.Specification

class UserTest extends Specification {
    def "CreateUser"() {
        given: "user props"
        def name = "Teste"
        def departament = Departament.SALES

        when: "a user is created"
        def user = User.createUser(name, departament)

        then: "the user info should be set"
        user.id == 0
        user.name == name
        user.departament == departament
    }
}
