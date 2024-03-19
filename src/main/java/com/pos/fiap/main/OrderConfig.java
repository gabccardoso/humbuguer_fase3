package com.pos.fiap.main;

import com.pos.fiap.application.gateways.ClientGateway;
import com.pos.fiap.application.gateways.OrderGateway;
import com.pos.fiap.application.useCases.ClientInteractor;
import com.pos.fiap.application.useCases.OrderInteractor;
import com.pos.fiap.infrastructure.controllers.dto.ClientDTOMapper;
import com.pos.fiap.infrastructure.controllers.dto.OrderDTOMapper;
import com.pos.fiap.infrastructure.gateways.ClientEntityMapper;
import com.pos.fiap.infrastructure.gateways.ClientRepositoryGateway;
import com.pos.fiap.infrastructure.gateways.OrderEntityMapper;
import com.pos.fiap.infrastructure.gateways.OrderRepositoryGateway;
import com.pos.fiap.infrastructure.persistence.ClientRepository;
import com.pos.fiap.infrastructure.persistence.OrderItensRepository;
import com.pos.fiap.infrastructure.persistence.OrderRepository;
import com.pos.fiap.infrastructure.persistence.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    OrderInteractor orderInteractor(OrderGateway orderGateway){
        return new OrderInteractor(orderGateway);
    }

    @Bean
    OrderGateway orderGateway(OrderRepository orderRepository, OrderItensRepository orderItensRepository, ProductRepository productRepository, OrderEntityMapper orderEntityMapper){
        return new OrderRepositoryGateway(orderRepository, orderItensRepository, productRepository, orderEntityMapper);
    }

    @Bean
    OrderEntityMapper orderEntityMapper(){
        return new OrderEntityMapper();
    }

    @Bean
    OrderDTOMapper orderDTOMapper(){
        return new OrderDTOMapper();
    }
}
