package com.academy.fourtk.apiGateway.application.services

import com.academy.fourtk.apiGateway.application.port.`in`.CreateUserPort
import com.academy.fourtk.apiGateway.application.port.out.UserRepositoryPort
import com.academy.fourtk.apiGateway.domain.model.User
import com.academy.fourtk.apiGateway.infrastructure.dto.request.UserRequest
import com.academy.fourtk.apiGateway.infrastructure.dto.response.UserResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateUserUseCase(
    private val userRepositoryPort: UserRepositoryPort
) : CreateUserPort {

    override fun execute(request: UserRequest): UserResponse {
        if (userRepositoryPort.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email já cadastrado")
        }
        val user = User(
            id = UUID.randomUUID().toString(),
            email = request.email,
            password = request.password,
            role = request.role
        )
        val saved = userRepositoryPort.save(user)
        return UserResponse(email = saved.email)
    }
}
