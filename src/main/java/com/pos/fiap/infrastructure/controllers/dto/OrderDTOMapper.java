package com.pos.fiap.infrastructure.controllers.dto;

import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.domain.entities.OrderItens;

import java.util.ArrayList;
import java.util.List;

public class OrderDTOMapper {
    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO(order.clientId(), order.status(), order.dataCriacao(), toOrderItensDTO(order.orderItens()));
    }

    public Order toOrder(OrderDTO orderDTO){
        return new Order(orderDTO.getClientId(), orderDTO.getStatus(), orderDTO.getDataCriacao(), toOrderItens(orderDTO.getOrderItens()));
    }

        public List<OrderItensDTO> toOrderItensDTO(List<OrderItens> orderItens){
        List<OrderItensDTO> orderItensDTO = new ArrayList<>();
        for (OrderItens orderItem : orderItens) {
            orderItensDTO.add(new OrderItensDTO(orderItem.product(), orderItem.quantity()));
        }
        return orderItensDTO;
        }

    public List<OrderItens> toOrderItens(List<OrderItensDTO> orderItensDTO){
        List<OrderItens> orderItensList = new ArrayList<>();
        for (OrderItensDTO orderItemDTO : orderItensDTO){
            orderItensList.add(new OrderItens(orderItemDTO.productId, orderItemDTO.quantity));
        }
        return orderItensList;
    }


}
