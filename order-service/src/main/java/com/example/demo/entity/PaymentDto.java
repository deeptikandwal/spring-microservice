package com.example.demo.entity;
import lombok.Data;

@Data
public class PaymentDto {

	private int orderId;
	private Double amount;
	private String status;

}