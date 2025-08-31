package com.academy.fourtk.apiGateway.application.port.`in`

import com.academy.fourtk.apiGateway.application.dto.response.ValidateTokenResponse

interface AuthValidationUseCase {
    fun validate(): ValidateTokenResponse
}
