package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrdersDto;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private OrderService orderService;

	public OrderController(@Autowired OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdersDto> getOrder(@PathVariable int id) {
		return ResponseEntity.ok(orderService.getOrdersfromid(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Orders> createNewOrder(@RequestBody OrdersDto orderDto) {
		Orders respDto=orderService.createOrder(orderDto);
	    URI location = URI.create("/orders/" + respDto.getId());

		return ResponseEntity.created(location)
				.body(respDto);
		
	}
	
	@PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrdersDto orderdDto) {
        return orderService.placeOrder(orderdDto);
    }
}