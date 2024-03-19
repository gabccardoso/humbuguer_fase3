package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.domain.entities.OrderItens;
import com.pos.fiap.infrastructure.persistence.OrderEntity;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

public class OrderEntityMapper {
    OrderEntity toEntity(Order orderObjDomain){
        return new OrderEntity(orderObjDomain.clientId(), orderObjDomain.status());
    }

    Order toDomainObject(OrderEntity orderEntity){
        return new Order(orderEntity.getClientId(), orderEntity.getStatus(), orderEntity.getDataCriacao());
    }

    OrderItensEntity toEntity(OrderItens orderObjDomain){
        return new OrderItensEntity(orderObjDomain.order(), orderObjDomain.product(), orderObjDomain.quantity());
    }

    OrderItens toDomainObject(OrderItensEntity orderItensEntity){
        return new OrderItens(orderItensEntity.getOrder(), orderItensEntity.getProduct(), orderItensEntity.getQuantity());
    }
}
