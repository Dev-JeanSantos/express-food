package com.academy.fourtk.api_gateway.infrastructure.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService {


    private val secretKey = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".toByteArray())
    private val validity = 3600000

    fun validateTokenAndExtractUser(token: String): String {
        try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body

            return claims.subject // normalmente o "userId"
        } catch (e: Exception) {
            throw RuntimeException("Token inválido ou expirado")
        }
    }
}
