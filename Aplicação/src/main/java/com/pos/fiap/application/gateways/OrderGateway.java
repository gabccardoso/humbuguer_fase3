package com.pos.fiap.application.gateways;

import com.pos.fiap.domain.entities.Client;
import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.infrastructure.controllers.enums.Status;

import java.util.List;
import java.util.Map;

public interface OrderGateway {
    Long createOrder(Order order);
    Order updateOrderItens(Long orderId, Map<Long, Integer> itensOrder);
    Order updateOrderStatus(Long orderId, Status status);
    List<Order> findOrders();
}
