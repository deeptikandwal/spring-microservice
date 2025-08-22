package com.example.demo.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.PaymentDto;

@FeignClient(name = "payment-service")  // Must match spring.application.name of Payment Service
public interface PaymentClient {

    @PostMapping("/doPayment")
    PaymentDto doPayment(@RequestBody PaymentDto payment);

}