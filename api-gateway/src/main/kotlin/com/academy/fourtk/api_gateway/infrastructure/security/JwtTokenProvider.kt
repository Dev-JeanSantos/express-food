package com.academy.fourtk.api_gateway.infrastructure.security

import com.academy.fourtk.api_gateway.application.port.out.JwtTokenPort
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider : JwtTokenPort {

    private val secretKey = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".toByteArray())
    private val expiration = 3600000 // 1h

    override fun generateToken(userId: String, role: String): String {
        val now = Date()
        val expiryDate = Date(now.time + expiration)

        return Jwts.builder()
            .setSubject(userId)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }
}