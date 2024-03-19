package com.pos.fiap.domain.entities;


import com.pos.fiap.infrastructure.persistence.ProductEntity;

public record OrderItens(Long product, int quantity) {

}
