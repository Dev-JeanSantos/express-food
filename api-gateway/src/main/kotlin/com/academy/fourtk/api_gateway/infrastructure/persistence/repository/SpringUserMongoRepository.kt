package com.academy.fourtk.api_gateway.infrastructure.persistence.repository

import com.academy.fourtk.api_gateway.infrastructure.persistence.document.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface SpringUserMongoRepository : MongoRepository<UserDocument, String> {
    fun findByEmail(email: String): UserDocument?
}
