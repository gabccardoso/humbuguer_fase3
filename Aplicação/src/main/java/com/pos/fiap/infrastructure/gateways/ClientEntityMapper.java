package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.domain.entities.Client;
import com.pos.fiap.infrastructure.persistence.ClientEntity;

public class ClientEntityMapper {
    ClientEntity toEntity(Client clientObjDomain){
        return new ClientEntity(clientObjDomain.id(), clientObjDomain.nome(), clientObjDomain.email(), clientObjDomain.cpf());
    }

    Client toDomainObject(ClientEntity clientEntity){
        return new Client(clientEntity.getId(), clientEntity.getNome(), clientEntity.getEmail(), clientEntity.getCpf());
    }
}
