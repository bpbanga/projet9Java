package com.opemclassrom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
            SpringApplication.run(GatewayApplication.class, args);
    }
}