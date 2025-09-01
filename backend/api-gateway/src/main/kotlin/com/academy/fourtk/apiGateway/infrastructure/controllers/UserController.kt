package com.academy.fourtk.apiGateway.infrastructure.controllers

import com.academy.fourtk.apiGateway.application.port.`in`.CreateUserPort
import com.academy.fourtk.apiGateway.application.port.`in`.GetUserPort
import com.academy.fourtk.apiGateway.infrastructure.dto.request.UserRequest
import com.academy.fourtk.apiGateway.infrastructure.dto.response.GetUserResponse
import com.academy.fourtk.apiGateway.infrastructure.dto.response.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val createUserPort: CreateUserPort,
    private val getUserPort: GetUserPort
) {
    @PostMapping
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<UserResponse> {
        val response = createUserPort.execute(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping()
    fun getUserByEmail(@RequestParam email: String): ResponseEntity<GetUserResponse> {
        val user = getUserPort.execute(email)
        return ResponseEntity.ok(user)
    }
}
