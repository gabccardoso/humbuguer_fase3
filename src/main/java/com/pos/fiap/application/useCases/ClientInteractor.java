package com.pos.fiap.application.useCases;

import com.pos.fiap.application.gateways.ClientGateway;
import com.pos.fiap.domain.entities.Client;

import java.util.List;

public class ClientInteractor {

    private ClientGateway clientGateway;

    public ClientInteractor(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Long createClient(Client client){
        return clientGateway.createClient(client);
    }

    public Client findClientByCPF(String cpf){
        return clientGateway.findClientByCPF(cpf);
    }

    public List<Client> findClients(){
        return clientGateway.findClients();
    }
}
