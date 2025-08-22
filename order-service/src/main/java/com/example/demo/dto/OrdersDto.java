package com.example.demo.dto;

import lombok.Data;

@Data
public class OrdersDto {

	private int id;
    private String productName;
    private int quantity;
    private double price;
}
