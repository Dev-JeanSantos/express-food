package com.academy.fourtk.apiGateway.infrastructure.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service

@Service
class JwtService {

    private val secretKey = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".toByteArray())
    private val validity = 3600000

    fun validateTokenAndExtractUser(token: String): CustomUserDetails {
        try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body

            val email = claims.subject
            val role = claims["role"] as String

            return CustomUserDetails(email = email, role = role)
        } catch (e: Exception) {
            throw RuntimeException("Token inválido ou expirado: ${e.message}")
        }
    }
}
