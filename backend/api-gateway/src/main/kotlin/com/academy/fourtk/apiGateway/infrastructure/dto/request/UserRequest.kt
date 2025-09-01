package com.academy.fourtk.apiGateway.infrastructure.dto.request

data class UserRequest(
    val email: String,
    val password: String,
    val role: String
)
