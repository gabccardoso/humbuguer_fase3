package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.application.gateways.OrderGateway;
import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.infrastructure.controllers.enums.Status;
import com.pos.fiap.infrastructure.persistence.*;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRepositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;
    private final OrderItensRepository orderItensRepository;
    private final ProductRepository productRepository;
    private final OrderEntityMapper orderEntityMapper;

    public OrderRepositoryGateway(OrderRepository orderRepository, OrderItensRepository orderItensRepository, ProductRepository productRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderItensRepository = orderItensRepository;
        this.productRepository = productRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public Long createOrder(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        OrderEntity orderSaved = orderRepository.save(orderEntity);
        return orderSaved.getId();
    }

    @Override
    public Order updateOrderItens(Long orderId, Map<Long, Integer> itensPedido) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        for (Map.Entry<Long, Integer> entry : itensPedido.entrySet()) {
            Long productId = entry.getKey();
            ProductEntity productEntity = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
            int quantity = entry.getValue();

            OrderItensEntity orderItensEntity = new OrderItensEntity();
            orderItensEntity.setProductId(productEntity.getId());
            orderItensEntity.setQuantity(quantity);

            orderEntity.getItens().add(orderItensEntity);
            orderItensRepository.save(orderItensEntity);
        }

        orderRepository.save(orderEntity);
        return orderEntityMapper.toDomainObject(orderEntity);
    }

    @Override
    public Order updateOrderStatus(Long orderId, Status status) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        orderEntity.setStatus(status);
        orderRepository.save(orderEntity);
        return orderEntityMapper.toDomainObject(orderEntity);
    }

    @Override
    public List<Order> findOrders() {
        List<OrderEntity> ordersEntity = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for(OrderEntity orderEntity : ordersEntity){
            orders.add(orderEntityMapper.toDomainObject(orderEntity));
        }
        return orders;
    }
}
