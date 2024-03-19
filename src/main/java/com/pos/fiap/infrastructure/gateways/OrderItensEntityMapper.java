package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.domain.entities.OrderItens;
import com.pos.fiap.infrastructure.persistence.OrderEntity;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

public class OrderItensEntityMapper {
    OrderItensEntity toEntity(OrderItens orderObjDomain){
        return new OrderItensEntity(orderObjDomain.order(), orderObjDomain.product(), orderObjDomain.quantity());
    }

    OrderItens toDomainObject(OrderItensEntity orderItensEntity){
        return new OrderItens(orderItensEntity.getOrder(), orderItensEntity.getProduct(), orderItensEntity.getQuantity());
    }
}
