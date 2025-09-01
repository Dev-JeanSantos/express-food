package com.academy.fourtk.apiGateway.application.port.out

interface JwtTokenPort {
    fun generateToken(userId: String, role: String): String
}
