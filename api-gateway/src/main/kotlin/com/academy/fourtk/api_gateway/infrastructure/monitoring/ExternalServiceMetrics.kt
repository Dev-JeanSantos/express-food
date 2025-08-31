package com.academy.fourtk.api_gateway.infrastructure.monitoring

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class ExternalServiceMetrics(
    private val meterRegistry: MeterRegistry
) {

    fun countFailure(serviceName: String) {
        meterRegistry.counter("external_service_failures", "service", serviceName).increment()
    }
}
