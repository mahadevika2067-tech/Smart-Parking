package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.Payment;
import parksmart.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {

        payment.setPaymentStatus("Paid");

        return paymentRepository.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable int id) {
        paymentRepository.deleteById(id);
    }
}