package com.academy.fourtk.apiGateway.application.port.out

import com.academy.fourtk.apiGateway.domain.model.User

interface UserRepositoryPort {
    fun findByEmail(email: String): User?
    fun save(user: User): User
    fun existsByEmail(email: String): Boolean
}
