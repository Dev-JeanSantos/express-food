package com.academy.fourtk.apiGateway.infrastructure.persistence.repository

import com.academy.fourtk.apiGateway.infrastructure.persistence.document.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface SpringUserMongoRepository : MongoRepository<UserDocument, String> {
    fun findByEmail(email: String): UserDocument?
    fun existsByEmail(email: String): Boolean
}
