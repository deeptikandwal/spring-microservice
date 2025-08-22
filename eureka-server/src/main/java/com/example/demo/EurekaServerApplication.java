package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

// Eureka Server is a service registry provided by Spring Cloud Netflix.
//1. Keeps track of which services are up and their locations.
//2. A Service Registry keeps a dynamic directory of all available services and their instances.

public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
