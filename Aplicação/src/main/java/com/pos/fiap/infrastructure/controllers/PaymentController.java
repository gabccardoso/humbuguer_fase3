package com.pos.fiap.infrastructure.controllers;

import com.pos.fiap.application.useCases.PaymentInteractor;
import com.pos.fiap.infrastructure.controllers.enums.StatusPayment;
import com.pos.fiap.infrastructure.gateways.PaymentRepositoryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagamento")
public class PaymentController {

    private final PaymentInteractor paymentInteractor;

    public PaymentController(PaymentInteractor paymentInteractor) {
        this.paymentInteractor = paymentInteractor;
    }


    @GetMapping(value = "buscarStatusPagamento/{pedidoId}")
    public ResponseEntity<String> buscarStatusPagamento(@PathVariable Long pedidoId){
        return ResponseEntity.ok(paymentInteractor.findPaymentStatus(pedidoId));
    }

    @PostMapping(value = "fazPagamento")
    public ResponseEntity<StatusPayment> fazPagamento(@RequestParam Long orderId){
        return ResponseEntity.ok(paymentInteractor.createPayment(orderId));
    }

}
