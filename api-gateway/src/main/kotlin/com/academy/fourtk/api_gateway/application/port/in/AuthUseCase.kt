package com.academy.fourtk.api_gateway.application.port.`in`

import com.academy.fourtk.api_gateway.application.dto.request.LoginRequest
import com.academy.fourtk.api_gateway.application.dto.response.AuthResponse

interface AuthUseCase {
    fun login(request: LoginRequest): AuthResponse
}