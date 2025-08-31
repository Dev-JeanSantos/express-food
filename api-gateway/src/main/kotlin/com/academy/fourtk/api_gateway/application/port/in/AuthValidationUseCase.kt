package com.academy.fourtk.api_gateway.application.port.`in`

import com.academy.fourtk.api_gateway.application.dto.response.ValidateTokenResponse

interface AuthValidationUseCase {
    fun validate(): ValidateTokenResponse
}