package com.academy.fourtk.api_gateway.infrastructure.persistence

import com.academy.fourtk.api_gateway.application.port.out.UserRepositoryPort
import com.academy.fourtk.api_gateway.domain.model.User
import com.academy.fourtk.api_gateway.infrastructure.persistence.document.UserDocument
import com.academy.fourtk.api_gateway.infrastructure.persistence.repository.SpringUserMongoRepository
import org.springframework.stereotype.Component

@Component
class MongoUserRepository(
    private val springDataRepo: SpringUserMongoRepository
) : UserRepositoryPort {

    override fun findByEmail(email: String): User? {
        // MOCK - em produção, use MongoRepository
        if (email == "jean@fastfood.com") {
            return User("user123", email, "123456", "CLIENT")
        }
        return null
    }

    override fun save(user: User): User {
        val saved = springDataRepo.save(UserDocument.fromDomain(user))
        return saved.toDomain()
    }
}