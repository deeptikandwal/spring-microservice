package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentDto;
import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

	private PaymentRepository paymentRepository;
	private ModelMapper modelMapper;

	 // ✅ Constructor injection (preferred over @Autowired on fields)
    public PaymentService(PaymentRepository paymentRepository,
                        ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

	public PaymentDto getPaymentFromid(int id) {

		Optional<Payment> order = paymentRepository.findById(id);
		return modelMapper.map(order, PaymentDto.class);
		
	}
	
	public String createPayment(PaymentDto paymentDto) {
		 paymentDto.setOrderId(0); // force Hibernate to treat as new entity
		    Payment payment = paymentRepository.save(modelMapper.map(paymentDto, Payment.class));
		    return payment != null ? "Success" : "Failed";
	}

}
