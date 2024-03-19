package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.domain.entities.OrderItens;
import com.pos.fiap.infrastructure.persistence.OrderEntity;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderEntityMapper {
    OrderEntity toEntity(Order orderObjDomain){
        return new OrderEntity(orderObjDomain.clientId(), orderObjDomain.status(), toOrderItensListEntity(orderObjDomain.orderItens()));
    }

    Order toDomainObject(OrderEntity orderEntity){
        return new Order(orderEntity.getClientId(), orderEntity.getStatus(), orderEntity.getDataCriacao(), toOrderItensList(orderEntity.getItens()));
    }

    private List<OrderItens> toOrderItensList(List<OrderItensEntity> orderItensEntities) {
        List<OrderItens> orderItensList = new ArrayList<>();
        for (OrderItensEntity orderItensEntity : orderItensEntities) {
            orderItensList.add(new OrderItens(orderItensEntity.getProductId(), orderItensEntity.getQuantity()));
        }
        return orderItensList;
    }

    private List<OrderItensEntity> toOrderItensListEntity(List<OrderItens> orderItens) {
        List<OrderItensEntity> orderItensEntityList = new ArrayList<>();
        for (OrderItens orderItem : orderItens) {
            orderItensEntityList.add(new OrderItensEntity(orderItem.product(), orderItem.quantity()));
        }
        return orderItensEntityList;
    }
}
