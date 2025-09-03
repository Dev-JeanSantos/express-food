package com.academy.fourtk.apiGateway.application.exception

class UserNotFoundInServiceException(email: String) : RuntimeException("User not found: $email")
