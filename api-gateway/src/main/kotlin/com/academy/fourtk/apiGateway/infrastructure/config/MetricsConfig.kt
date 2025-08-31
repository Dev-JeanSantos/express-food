package com.academy.fourtk.apiGateway.infrastructure.config

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.config.MeterFilter
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

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
