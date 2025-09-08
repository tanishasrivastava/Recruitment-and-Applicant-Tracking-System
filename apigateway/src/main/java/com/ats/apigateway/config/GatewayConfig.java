package com.ats.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("jobservice", r -> r.path("/jobs/**")
                .uri("lb://job-service"))
            .route("candidateservice", r -> r.path("/candidates/**")
                .uri("lb://candidate-service"))
            .route("interviewservice", r -> r.path("/interviews/**")
                .uri("lb://interview-service"))
            .build();
    }
}
