package com.academy.fourtk.apiGateway.application.port.`in`

import com.academy.fourtk.apiGateway.infrastructure.dto.response.GetUserResponse

interface GetUserPort {
    fun execute(email: String): GetUserResponse
}
