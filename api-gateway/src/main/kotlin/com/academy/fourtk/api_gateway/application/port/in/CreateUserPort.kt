package com.academy.fourtk.api_gateway.application.port.`in`

import com.academy.fourtk.api_gateway.infrastructure.dto.request.UserRequest
import com.academy.fourtk.api_gateway.infrastructure.dto.response.UserResponse

interface CreateUserPort {
    fun execute(request: UserRequest): UserResponse
}