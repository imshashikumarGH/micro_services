package com.learning.apigetway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatwayConfig {

    //NOT Working
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                //.addRequestHeader("MyHeader", "MyURI")

                                .addRequestParameter("ItemId", "P1001")
                                .addRequestParameter("quantity", "5"))
                        .uri("http://localhost:8080/order/calculatePrice?ItemId=P1001&quantity=10"))
                //.uri("http://httpbin.org:80"))
                .build();
    }

}
