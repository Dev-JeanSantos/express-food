package com.academy.fourtk.api_gateway.application.services

import com.academy.fourtk.api_gateway.application.dto.response.ValidateTokenResponse
import com.academy.fourtk.api_gateway.application.port.`in`.AuthValidationUseCase
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AuthValidationService : AuthValidationUseCase {

    override fun validate(): ValidateTokenResponse {
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication == null || !authentication.isAuthenticated) {
            throw RuntimeException("Token inválido ou não autenticado")
        }

        val userId = authentication.name
        val role = authentication.authorities.firstOrNull()?.authority ?: "UNKNOWN"

        return ValidateTokenResponse(
            userId = userId,
            role = role,
            valid = true
        )
    }
}