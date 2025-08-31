package com.academy.fourtk.api_gateway.infrastructure.controllers

import com.academy.fourtk.api_gateway.application.dto.request.LoginRequest
import com.academy.fourtk.api_gateway.application.dto.response.AuthResponse
import com.academy.fourtk.api_gateway.application.dto.response.ValidateTokenResponse
import com.academy.fourtk.api_gateway.application.port.`in`.AuthUseCase
import com.academy.fourtk.api_gateway.application.port.`in`.AuthValidationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authUseCase: AuthUseCase,
    private val authValidationUseCase: AuthValidationUseCase
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(authUseCase.login(request))
    }

    @GetMapping("/validate")
    fun validateToken(): ResponseEntity<ValidateTokenResponse> {
        return ResponseEntity.ok(authValidationUseCase.validate())
    }
}
