package com.academy.fourtk.apiGateway.domain.model

data class User(
    val id: String,
    val email: String,
    val password: String,
    val role: String
)
