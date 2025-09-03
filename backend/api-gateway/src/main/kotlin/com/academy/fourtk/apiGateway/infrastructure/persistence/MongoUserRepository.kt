package com.academy.fourtk.apiGateway.infrastructure.persistence

import com.academy.fourtk.apiGateway.application.exception.DatabaseConnectionException
import com.academy.fourtk.apiGateway.application.port.out.UserRepositoryPort
import com.academy.fourtk.apiGateway.domain.model.User
import com.academy.fourtk.apiGateway.infrastructure.persistence.document.UserDocument
import com.academy.fourtk.apiGateway.infrastructure.persistence.repository.SpringUserMongoRepository
import com.mongodb.MongoException
import com.mongodb.MongoSocketOpenException
import org.springframework.stereotype.Component

@Component
class MongoUserRepository(
    private val springDataRepo: SpringUserMongoRepository
) : UserRepositoryPort {
    override fun findByEmail(email: String): User? =
        springDataRepo.findByEmail(email)?.toDomain()

    override fun existsByEmail(email: String): Boolean =
        springDataRepo.existsByEmail(email)

    override fun save(user: User): User {
        try {
            val document = UserDocument.fromDomain(user)
            val saved = springDataRepo.save(document)
            return saved.toDomain()
        } catch (ex: MongoSocketOpenException) {
            throw DatabaseConnectionException("Failed to connect to MongoDB: ${ex.message}")
        } catch (ex: MongoException) {
            throw DatabaseConnectionException("MongoDB error: ${ex.message}")
        }
    }
}
