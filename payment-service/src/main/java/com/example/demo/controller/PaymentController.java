package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaymentDto;
import com.example.demo.service.PaymentService;

@RestController
@EnableDiscoveryClient
@RequestMapping("/payments")
public class PaymentController {
	private PaymentService paymentService;

	public PaymentController(@Autowired PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentDto> getPayment(@PathVariable int id) {
		return ResponseEntity.ok(paymentService.getPaymentFromid(id));
	}
	
	@PostMapping("/doPayment")
	public String doPayment(@RequestBody PaymentDto paymentDto) {
		String respDto=paymentService.createPayment(paymentDto);

		return respDto;
		
	}
		
}