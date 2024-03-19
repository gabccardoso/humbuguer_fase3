package com.pos.fiap.application.gateways;

import com.pos.fiap.domain.entities.Client;

import java.util.List;

public interface ClientGateway {
    Long createClient(Client client);
    Client findClientByCPF(String cpf);
    List<Client> findClients();
}
