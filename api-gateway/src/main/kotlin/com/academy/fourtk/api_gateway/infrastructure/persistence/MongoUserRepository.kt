package com.academy.fourtk.api_gateway.infrastructure.persistence

import com.academy.fourtk.api_gateway.application.port.out.UserRepositoryPort
import com.academy.fourtk.api_gateway.domain.model.User
import org.springframework.stereotype.Component

@Component
class MongoUserRepository : UserRepositoryPort {

    override fun findByEmail(email: String): User? {
        // MOCK - em produção, use MongoRepository
        if (email == "jean@fastfood.com") {
            return User("user123", email, "123456", "CLIENT")
        }
        return null
    }
}