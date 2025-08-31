package com.academy.fourtk.api_gateway.domain.model

data class User(
    val id: String,
    val email: String,
    val password: String,
    val role: String
)