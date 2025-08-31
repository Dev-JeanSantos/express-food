package com.academy.fourtk.api_gateway.infrastructure.controllers

import com.academy.fourtk.api_gateway.application.port.`in`.CreateUserPort
import com.academy.fourtk.api_gateway.infrastructure.dto.request.UserRequest
import com.academy.fourtk.api_gateway.infrastructure.dto.response.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val createUserPort: CreateUserPort
) {

    @PostMapping
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<UserResponse> {
        val response = createUserPort.execute(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}