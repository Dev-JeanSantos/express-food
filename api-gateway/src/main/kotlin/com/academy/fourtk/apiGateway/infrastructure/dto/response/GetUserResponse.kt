package com.academy.fourtk.apiGateway.infrastructure.dto.response

data class GetUserResponse(
    val id: String,
    val email: String,
    val role: String
)
