package com.academy.fourtk.api_gateway.application.port.out

import com.academy.fourtk.api_gateway.domain.model.User

interface UserRepositoryPort {
    fun findByEmail(email: String): User?
}