package com.academy.fourtk.api_gateway.infrastructure.persistence.document

import com.academy.fourtk.api_gateway.domain.model.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class UserDocument(
    @Id
    val id: String? = null,
    val email: String,
    val password: String,
    val role: String
) {
    fun toDomain(): User = User(
        id = this.id ?: "",
        email = this.email,
        password = this.password,
        role = this.role
    )

    companion object {
        fun fromDomain(user: User): UserDocument = UserDocument(
            id = if (user.id.isBlank()) null else user.id,
            email = user.email,
            password = user.password,
            role = user.role
        )
    }
}
