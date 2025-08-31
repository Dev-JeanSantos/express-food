package com.academy.fourtk.api_gateway.application.dto.response

data class ValidateTokenResponse(
    val userId: String,
    val role: String,
    val valid: Boolean
)