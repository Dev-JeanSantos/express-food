package com.academy.fourtk.apiGateway.application.services

import com.academy.fourtk.apiGateway.application.dto.request.LoginRequest
import com.academy.fourtk.apiGateway.application.dto.response.AuthResponse
import com.academy.fourtk.apiGateway.application.port.`in`.AuthUseCase
import com.academy.fourtk.apiGateway.application.port.out.JwtTokenPort
import com.academy.fourtk.apiGateway.application.port.out.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepositoryPort,
    private val jwtTokenPort: JwtTokenPort
) : AuthUseCase {

    override fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw RuntimeException("Usuário não encontrado")

        if (user.password != request.password) { // Trocar por hash real em produção!
            throw RuntimeException("Senha inválida")
        }

        val token = jwtTokenPort.generateToken(user.id, user.role)
        return AuthResponse("Bearer $token")
    }
}
