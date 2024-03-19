package com.pos.fiap.main;

import com.pos.fiap.application.gateways.PaymentGateway;
import com.pos.fiap.application.gateways.ProductGateway;
import com.pos.fiap.application.useCases.PaymentInteractor;
import com.pos.fiap.application.useCases.ProductInteractor;
import com.pos.fiap.domain.entities.Payment;
import com.pos.fiap.infrastructure.controllers.dto.ProductDTOMapper;
import com.pos.fiap.infrastructure.gateways.PaymentRepositoryGateway;
import com.pos.fiap.infrastructure.gateways.ProductEntityMapper;
import com.pos.fiap.infrastructure.gateways.ProductRepositoryGateway;
import com.pos.fiap.infrastructure.persistence.PaymentRepository;
import com.pos.fiap.infrastructure.persistence.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    PaymentInteractor paymentInteractor(PaymentGateway paymentGateway){
        return new PaymentInteractor(paymentGateway);
    }

    @Bean
    PaymentGateway paymentGateway(PaymentRepository paymentRepository){
        return new PaymentRepositoryGateway(paymentRepository);
    }

}
