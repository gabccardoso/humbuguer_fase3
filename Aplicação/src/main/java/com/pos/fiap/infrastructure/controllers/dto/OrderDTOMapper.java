package com.pos.fiap.infrastructure.controllers.dto;

import com.pos.fiap.domain.entities.Order;

public class OrderDTOMapper {
    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO(order.clientId(), order.status(), order.dataCriacao());
    }

    public Order toOrder(OrderDTO orderDTO){
        return new Order(orderDTO.getClientId(), orderDTO.getStatus(), orderDTO.getDataCriacao());
    }
}
