package com.myproject.webshop.services;

import com.myproject.webshop.dto.PaymentDTO;
import com.myproject.webshop.mapper.PaymentMapper;
import com.myproject.webshop.model.Payment;
import com.myproject.webshop.repositories.PaymentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentDTO> getAllDtoPayments() {

        List<Payment>allPayments = paymentRepository.findAllPayments();
        return paymentMapper.toDtoList(allPayments);

    }

    public List<PaymentDTO> savePayment(Payment payment) {

        paymentRepository.save(payment);
        return getAllDtoPayments();
    }

    public PaymentDTO findPaymentById(Long id) {

        PaymentDTO paymentDTO = paymentMapper.toDto(paymentRepository.findPaymentById(id));
        return paymentDTO;
    }

    public PaymentDTO updatePayment(PaymentDTO paymentDTO, Long id) {

        Payment foundPayment = paymentRepository.findPaymentById(id);

        paymentMapper.updatePayment(paymentDTO, foundPayment);

        savePayment(foundPayment);

        return findPaymentById(id);

    }

    public List<PaymentDTO> deletePaymentById(Long id) {

        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.METHOD_NOT_ALLOWED);
        }
        if (id == 0) {
            throw new HttpClientErrorException(HttpStatus.I_AM_A_TEAPOT);
        }
        paymentRepository.deleteById(id);
        return getAllDtoPayments();

    }

}
