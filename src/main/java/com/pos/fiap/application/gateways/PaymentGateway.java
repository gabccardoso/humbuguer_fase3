package com.pos.fiap.application.gateways;

import com.pos.fiap.infrastructure.controllers.enums.StatusPayment;

public interface PaymentGateway{
    String findPaymentStatus(Long orderId);

    StatusPayment createPayment(Long orderId);
}
