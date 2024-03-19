package com.pos.fiap.domain.entities;

import com.pos.fiap.infrastructure.controllers.enums.Category;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

import java.util.List;

public record Product(String name, Category category, String description, String image, Double price, List<OrderItensEntity> itens) {
}
