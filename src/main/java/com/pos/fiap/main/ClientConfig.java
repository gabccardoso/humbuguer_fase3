package com.pos.fiap.main;

import com.pos.fiap.application.gateways.ClientGateway;
import com.pos.fiap.application.useCases.ClientInteractor;

import com.pos.fiap.infrastructure.controllers.dto.ClientDTOMapper;
import com.pos.fiap.infrastructure.gateways.ClientEntityMapper;
import com.pos.fiap.infrastructure.gateways.ClientRepositoryGateway;
import com.pos.fiap.infrastructure.persistence.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    ClientInteractor clientInteractor(ClientGateway clientGateway){
        return new ClientInteractor(clientGateway);
    }

    @Bean
    ClientGateway clientGateway(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper){
        return new ClientRepositoryGateway(clientRepository, clientEntityMapper);
    }

    @Bean
    ClientEntityMapper clientEntityMapper(){
        return new ClientEntityMapper();
    }

    @Bean
    ClientDTOMapper clientDTOMapper(){
        return new ClientDTOMapper();
    }
}
