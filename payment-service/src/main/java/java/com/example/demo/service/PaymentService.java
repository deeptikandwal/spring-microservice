package java.com.example.demo.service;

import java.com.example.demo.dto.PaymentDto;
import java.com.example.demo.entity.Payment;
import java.com.example.demo.repository.PaymentRepository;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


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
		Payment payment = paymentRepository.save(modelMapper.map(paymentDto, Payment.class));
		if (payment != null) {
			return "Success";
		} else {
			return "failed";
		}
	}

}
