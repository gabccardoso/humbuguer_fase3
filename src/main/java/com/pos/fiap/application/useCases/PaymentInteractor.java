package com.pos.fiap.application.useCases;

import com.pos.fiap.application.gateways.PaymentGateway;
import com.pos.fiap.infrastructure.controllers.enums.StatusPayment;

public class PaymentInteractor {

    private final PaymentGateway paymentGateway;

    public PaymentInteractor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String findPaymentStatus(Long orderId){
        return paymentGateway.findPaymentStatus(orderId);
    }

    public StatusPayment createPayment(Long orderId){
        return paymentGateway.createPayment(orderId);
    }
}
