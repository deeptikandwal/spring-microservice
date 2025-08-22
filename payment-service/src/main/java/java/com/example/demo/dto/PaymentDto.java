package java.com.example.demo.dto;

import lombok.Data;

@Data
public class PaymentDto {


	private int orderId;
	private Double amount;
	private String status;
}
