package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.Payment;

public interface PaymentRepository
        extends JpaRepository<Payment, Integer> {
}