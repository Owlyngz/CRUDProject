package com.myproject.webshop.controller;

import com.myproject.webshop.dto.PaymentDTO;
import com.myproject.webshop.model.Payment;
import com.myproject.webshop.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<PaymentDTO> allPayments() { return paymentService.getAllDtoPayments(); }

    @GetMapping("/payments/{id}")
    public PaymentDTO findById(@PathVariable Long id) { return paymentService.findPaymentById(id); }

    @PostMapping("/payment")
    public List<PaymentDTO> saveMethod(@RequestBody Payment payment) { return paymentService.savePayment(payment); }

    @DeleteMapping("/payments/{id}")
    public List<PaymentDTO> deleteMethod(@PathVariable Long id) {
        return paymentService.deletePaymentById(id);
    }

    @PutMapping("/payments/{id}/put")
    public PaymentDTO updateMethod(@RequestBody PaymentDTO paymentDTO, @PathVariable Long id) { return paymentService.updatePayment(paymentDTO, id); }

}
