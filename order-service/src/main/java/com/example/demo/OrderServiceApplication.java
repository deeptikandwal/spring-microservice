package com.example.demo;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	 // Debug Feign client registration
    @Bean
    ApplicationRunner runner(ApplicationContext context) {
        return args -> {
            System.out.println("==== Beans of type PaymentClient ====");
            String[] beanNames = ((ListableBeanFactory) context).getBeanNamesForType(com.example.demo.repository.PaymentClient.class);
            for (String name : beanNames) {
                System.out.println("Bean found: " + name);
            }
        };
    }

}
