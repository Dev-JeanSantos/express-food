package com.academy.fourtk.apiGateway.application.services

import com.academy.fourtk.apiGateway.application.port.`in`.GetUserPort
import com.academy.fourtk.apiGateway.application.port.out.UserRepositoryPort
import com.academy.fourtk.apiGateway.infrastructure.dto.response.GetUserResponse
import org.springframework.stereotype.Service

@Service
class GetUserUseCase(
    private val userRepositoryPort: UserRepositoryPort
) : GetUserPort {

    override fun execute(email: String): GetUserResponse {
        val user = userRepositoryPort.findByEmail(email)
            ?: throw NoSuchElementException("Usuário não encontrado com email: $email")

        return GetUserResponse(
            id = user.id,
            email = user.email,
            role = user.role
        )
    }
}
