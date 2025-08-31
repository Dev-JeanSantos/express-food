package com.academy.fourtk.api_gateway.application.port.out

interface JwtTokenPort {
    fun generateToken(userId: String, role: String): String
}