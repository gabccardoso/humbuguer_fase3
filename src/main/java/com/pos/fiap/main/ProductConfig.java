package com.pos.fiap.main;

import com.pos.fiap.application.gateways.OrderGateway;
import com.pos.fiap.application.gateways.ProductGateway;
import com.pos.fiap.application.useCases.OrderInteractor;
import com.pos.fiap.application.useCases.ProductInteractor;
import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.controllers.ProductController;
import com.pos.fiap.infrastructure.controllers.dto.OrderDTOMapper;
import com.pos.fiap.infrastructure.controllers.dto.ProductDTOMapper;
import com.pos.fiap.infrastructure.gateways.OrderEntityMapper;
import com.pos.fiap.infrastructure.gateways.OrderRepositoryGateway;
import com.pos.fiap.infrastructure.gateways.ProductEntityMapper;
import com.pos.fiap.infrastructure.gateways.ProductRepositoryGateway;
import com.pos.fiap.infrastructure.persistence.OrderItensRepository;
import com.pos.fiap.infrastructure.persistence.OrderRepository;
import com.pos.fiap.infrastructure.persistence.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    ProductInteractor productInteractor(ProductGateway productGateway){
        return new ProductInteractor(productGateway);
    }

    @Bean
    ProductGateway productGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper){
        return new ProductRepositoryGateway(productRepository, productEntityMapper);
    }

    @Bean
    ProductEntityMapper productEntityMapper(){
        return new ProductEntityMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper(){
        return new ProductDTOMapper();
    }
}
