package com.academy.fourtk.apiGateway.application.port.`in`

import com.academy.fourtk.apiGateway.infrastructure.dto.request.UserRequest
import com.academy.fourtk.apiGateway.infrastructure.dto.response.UserResponse

interface CreateUserPort {
    fun execute(request: UserRequest): UserResponse
}
