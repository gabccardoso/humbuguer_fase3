package com.pos.fiap.application.useCases;

import com.pos.fiap.application.gateways.ClientGateway;
import com.pos.fiap.application.gateways.OrderGateway;
import com.pos.fiap.domain.entities.Client;
import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.infrastructure.controllers.enums.Status;

import java.util.List;
import java.util.Map;

public class OrderInteractor {

    private final OrderGateway orderGateway;

    public OrderInteractor(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Long createOrder(Order order){
        return orderGateway.createOrder(order);
    }
    public Order updateOrderItens(Long orderId, Map<Long, Integer> itensOrder){
        return orderGateway.updateOrderItens(orderId, itensOrder);
    }
    public Order updateOrderStatus(Long orderId, Status status){
        return orderGateway.updateOrderStatus(orderId, status);
    }
    public List<Order> findOrders(){
        return orderGateway.findOrders();
    }
}
