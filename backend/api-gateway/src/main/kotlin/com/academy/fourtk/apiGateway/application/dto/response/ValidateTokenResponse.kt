package com.academy.fourtk.apiGateway.application.dto.response

data class ValidateTokenResponse(
    val userId: String,
    val role: String,
    val valid: Boolean
)
