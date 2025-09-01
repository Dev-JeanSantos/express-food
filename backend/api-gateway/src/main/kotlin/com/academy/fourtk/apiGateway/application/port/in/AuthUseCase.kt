package com.academy.fourtk.apiGateway.application.port.`in`

import com.academy.fourtk.apiGateway.application.dto.request.LoginRequest
import com.academy.fourtk.apiGateway.application.dto.response.AuthResponse

interface AuthUseCase {
    fun login(request: LoginRequest): AuthResponse
}
