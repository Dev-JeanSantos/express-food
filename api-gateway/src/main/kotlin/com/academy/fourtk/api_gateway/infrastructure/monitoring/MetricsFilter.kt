package com.academy.fourtk.api_gateway.infrastructure.monitoring

import io.micrometer.core.instrument.MeterRegistry
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.time.Duration

@Component
class MetricsFilter(
    private val meterRegistry: MeterRegistry
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val start = System.currentTimeMillis()
        try {
            filterChain.doFilter(request, response)
        } finally {
            val duration = System.currentTimeMillis() - start
            val path = request.requestURI
            val method = request.method
            val status = response.status

            meterRegistry.counter("http_requests_total", "path", path, "method", method, "status", status.toString()).increment()
            meterRegistry.timer("http_requests_latency", "path", path, "method", method)
                .record(Duration.ofMillis(duration))
        }
    }
}
