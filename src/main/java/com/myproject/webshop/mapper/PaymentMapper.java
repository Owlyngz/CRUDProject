package com.myproject.webshop.mapper;

import com.myproject.webshop.dto.PaymentDTO;
import com.myproject.webshop.model.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class PaymentMapper {

    public PaymentDTO toDto(Payment payment) {

        return new PaymentDTO(payment.getpId(), payment.getuName(), payment.getBankName(), payment.getCardNo(), payment.getCcv());
    }


    public List<PaymentDTO>toDtoList(List<Payment> payments) {

        List<PaymentDTO> paymentDto = new ArrayList<>();

        for(Payment payment: payments) {
            paymentDto.add((toDto(payment)));
        }
        return paymentDto;
    }

    public Payment toEntity(PaymentDTO paymentDTO) {

        return new Payment(paymentDTO.getpId(), paymentDTO.getuName(), paymentDTO.getBankName(), paymentDTO.getCardNo(), paymentDTO.getCcv());
    }


    public List<Payment>toEntityList(List<PaymentDTO> paymentDTOList) {

        List<Payment>paymentEntityList = new ArrayList<>();

        for(PaymentDTO paymentDTO: paymentDTOList) {
            paymentEntityList.add((toEntity(paymentDTO)));
        }
        return paymentEntityList;
    }

    public Payment updatePayment(PaymentDTO paymentDTO, Payment payment) {

        payment.setuName(paymentDTO.getuName());
        payment.setBankName(paymentDTO.getBankName());
        payment.setCardNo(paymentDTO.getCardNo());
        payment.setCcv(paymentDTO.getCcv());

        return payment;
    }

}
