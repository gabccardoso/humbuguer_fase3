package com.pos.fiap.infrastructure.controllers.dto;

import com.pos.fiap.infrastructure.controllers.enums.Status;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long clientId;
    @NotNull
    private Status status;
    private Date dataCriacao;
    private List<ProductDTO> produtos;

    public OrderDTO(Long clientId, Status status, Date dataCriacao) {
        this.clientId = clientId;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ProductDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductDTO> produtos) {
        this.produtos = produtos;
    }
}
