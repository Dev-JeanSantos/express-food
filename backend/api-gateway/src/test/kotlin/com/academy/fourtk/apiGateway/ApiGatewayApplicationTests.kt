package com.academy.fourtk.apiGateway

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource

@SpringBootTest
class ApiGatewayApplicationTests {

    companion object {
        @JvmStatic
        @DynamicPropertySource
        fun mongoProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri") { "mongodb://localhost:27017/expressfood_test" }
        }
    }

    @Test
    fun contextLoads() {
    }
}
