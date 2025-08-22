package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrdersDto;
import com.example.demo.entity.Orders;
import com.example.demo.entity.PaymentDto;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentClient;

import feign.FeignException;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private ModelMapper modelMapper;
	private PaymentClient paymentClient;

    public OrderService(PaymentClient paymentClient,
                        OrderRepository orderRepository,
                        ModelMapper modelMapper) {
        this.paymentClient = paymentClient;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

	public OrdersDto getOrdersfromid(int id) {

		Optional<Orders> order = orderRepository.findById(id);
		return modelMapper.map(order, OrdersDto.class);
		
	}
	
	public Orders createOrder(OrdersDto orderDto) {
		return orderRepository.save(modelMapper.map(orderDto, Orders.class));
	}
	
	public String placeOrder(OrdersDto orderDto) {
	    Orders order = modelMapper.map(orderDto, Orders.class);
	    Orders savedOrder = orderRepository.save(order);
	    PaymentDto payment = new PaymentDto();
	    payment.setOrderId(savedOrder.getId()); 
	    payment.setAmount(savedOrder.getPrice());
	    String response;

	    try {
	    	payment.setStatus("Success");
	        response = paymentClient.doPayment(payment);
	    } catch (FeignException e) {
	        response = "Payment failed: " + e.getMessage();
	    }
	    return response;
	}


}
