package com.pos.fiap.domain.entities;

import com.pos.fiap.infrastructure.controllers.dto.OrderItensDTO;
import com.pos.fiap.infrastructure.controllers.enums.Status;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

import java.util.Date;
import java.util.List;

public record Order(Long clientId, Status status, Date dataCriacao, List<OrderItens> orderItens) {

}
