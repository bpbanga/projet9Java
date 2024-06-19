package com.opemclassrom.configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
     @Bean
    public RouteLocator custumRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("patient",
                            r -> r.path("/patients")
                                    .and().method("GET")
                                    .uri("http://localhost:9002"))
            .route("patient",
                            r -> r.path("/patients/{id}")
                                    .and().method("GET")
                                    .uri("http://localhost:9002"))                        
            .route("patient",
                            r -> r.path("/patients")
                                    .and().method("POST")
                                    .uri("http://localhost:9002"))
            .route("patient",
                            r -> r.path("/patients")
                                    .and().method("PUT")
                                    .uri("http://localhost:9002"))

                    .build();
    }

}
