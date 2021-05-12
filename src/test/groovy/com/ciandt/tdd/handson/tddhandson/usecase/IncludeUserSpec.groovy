package com.ciandt.tdd.handson.tddhandson.usecase

import com.ciandt.tdd.handson.tddhandson.entity.Departament
import com.ciandt.tdd.handson.tddhandson.entity.User
import com.ciandt.tdd.handson.tddhandson.exception.HandsOnServerException
import com.ciandt.tdd.handson.tddhandson.external.data.UserRepository
import spock.lang.Specification

class IncludeUserSpec extends Specification {

    UserRepository userRepository = Mock()
    IncludeUser includeUser = new IncludeUser(userRepository)

    def "inclusão de usuario"() {
        given: "um usuario"
        User user = User.createUser("Andrei", Departament.SALES)

        when: "use case de inclusao for executado"
        includeUser.execute(user)

        then: "usuario e incluido"
        noExceptionThrown()

        and: "o usuario deve ser persistido"
        1 * userRepository.insert(user)
    }

    def "uma HandsOnServerException deve ser lançada quando ocorrer erro na persistência"() {
        given: "ocorre uma exceção quando uma tentativa de inserção for feita"
        userRepository.insert(_) >> {
            throw new RuntimeException()
        }

        when: "use case de inclusao for executado"
        includeUser.execute(null)

        then: "observamos que uma HandsOnServerException é lançada"
        thrown(HandsOnServerException)
    }

}
