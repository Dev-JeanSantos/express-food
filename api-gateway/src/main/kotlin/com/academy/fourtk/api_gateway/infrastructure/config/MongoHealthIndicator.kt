package com.academy.fourtk.api_gateway.infrastructure.config

import org.springframework.stereotype.Component

@Component
class MongoHealthIndicator()
//    private val mongoClient: MongoClient
//) : HealthIndicator {

//    override fun health(): Health {
//        return try {
//            mongoClient.listDatabaseNames().first() // simples ping
//            Health.up().withDetail("mongo", "OK").build()
//        } catch (ex: Exception) {
//            Health.down(ex).withDetail("mongo", "FAIL").build()
//        }
//    }
//}