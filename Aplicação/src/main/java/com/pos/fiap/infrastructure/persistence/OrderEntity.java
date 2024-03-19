package com.pos.fiap.infrastructure.persistence;

import com.pos.fiap.domain.entities.OrderItens;
import com.pos.fiap.infrastructure.controllers.enums.Status;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItensEntity> itens;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    public OrderEntity() {
    }

    public OrderEntity(Long clientId, Status status) {
        this.clientId = clientId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<OrderItensEntity> getItens() {
        return itens;
    }

    public void setItens(List<OrderItensEntity> itens) {
        this.itens = itens;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = new Date();
    }
}
