package com.pos.fiap.domain.entities;


import com.pos.fiap.infrastructure.persistence.OrderEntity;
import com.pos.fiap.infrastructure.persistence.ProductEntity;

public record OrderItens(OrderEntity order, ProductEntity product, int quantity) {

}
