package java.com.example.demo.repository;

import java.com.example.demo.entity.Payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {



}
