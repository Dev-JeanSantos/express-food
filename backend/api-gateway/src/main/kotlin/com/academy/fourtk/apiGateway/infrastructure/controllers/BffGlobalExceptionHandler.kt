package com.academy.fourtk.apiGateway.infrastructure.controllers

import com.academy.fourtk.apiGateway.application.exception.DatabaseConnectionException
import com.academy.fourtk.apiGateway.application.exception.UserAlreadyExistsException
import com.academy.fourtk.apiGateway.application.exception.UserNotFoundInServiceException
import com.academy.fourtk.apiGateway.application.exception.UserServiceUnavailableException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BffGlobalExceptionHandler {

    @ExceptionHandler(UserServiceUnavailableException::class)
    fun handleServiceUnavailable(ex: UserServiceUnavailableException) =
        ResponseEntity(ErrorResponse(ex.message ?: "User service unavailable"), HttpStatus.SERVICE_UNAVAILABLE)

    data class ErrorResponse(val error: String, val details: String? = null)

    @ExceptionHandler(UserAlreadyExistsException::class)
    fun handleUserAlreadyExists(ex: UserAlreadyExistsException): ResponseEntity<ErrorResponse> =
        ResponseEntity(
            ErrorResponse("User already exists", ex.message),
            HttpStatus.CONFLICT
        )

    @ExceptionHandler(DatabaseConnectionException::class)
    fun handleDatabaseConnectionException(ex: DatabaseConnectionException): ResponseEntity<Map<String, String>> {
        val body = mapOf("error" to ex.message.orEmpty())
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(body)
    }

    @ExceptionHandler(UserNotFoundInServiceException::class)
    fun handleUserNotFound(ex: UserNotFoundInServiceException) =
        ResponseEntity(ErrorResponse(ex.message ?: "User not found"), HttpStatus.NOT_FOUND)

    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception) =
        ResponseEntity(ErrorResponse(ex.message ?: "Unexpected error"), HttpStatus.INTERNAL_SERVER_ERROR)
}

data class ErrorResponse(val error: String)
