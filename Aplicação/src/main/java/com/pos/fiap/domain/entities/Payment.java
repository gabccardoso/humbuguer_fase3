package com.pos.fiap.domain.entities;

import com.pos.fiap.infrastructure.controllers.enums.StatusPayment;

public record Payment(Long orderId, StatusPayment statusPayment) {
}
