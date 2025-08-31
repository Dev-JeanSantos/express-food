package com.academy.fourtk.api_gateway.infrastructure.config

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.config.MeterFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import jakarta.annotation.PostConstruct

@Configuration
class MetricsConfig(
    private val meterRegistry: MeterRegistry,

    @Value("\${spring.application.name:fastfood-gateway}")
    private val appName: String,

    @Value("\${metrics.env:local}")
    private val environment: String
) {

    @PostConstruct
    fun init() {
        // Adiciona tags padrão a todas as métricas
        meterRegistry.config()
            .commonTags(
                listOf(
                    Tag.of("application", appName),
                    Tag.of("environment", environment)
                )
            )

        // Opcional: ignora endpoints específicos
        meterRegistry.config().meterFilter(MeterFilter.denyNameStartsWith("jvm.gc"))
    }
}
