package com.academy.fourtk.api_gateway.infrastructure.dto.request

data class UserRequest(
    val email: String,
    val password: String,
    val role: String
)
