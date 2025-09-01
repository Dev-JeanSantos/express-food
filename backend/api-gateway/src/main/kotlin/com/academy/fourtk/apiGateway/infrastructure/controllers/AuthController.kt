package com.academy.fourtk.apiGateway.infrastructure.controllers

import com.academy.fourtk.apiGateway.application.dto.request.LoginRequest
import com.academy.fourtk.apiGateway.application.dto.response.AuthResponse
import com.academy.fourtk.apiGateway.application.dto.response.ValidateTokenResponse
import com.academy.fourtk.apiGateway.application.port.`in`.AuthUseCase
import com.academy.fourtk.apiGateway.application.port.`in`.AuthValidationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
