package com.academy.fourtk.api_gateway.application.dto.request

data class LoginRequest(
    val email: String,
    val password: String
)