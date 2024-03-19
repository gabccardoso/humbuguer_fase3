package com.pos.fiap.application.gateways;

import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.controllers.enums.Category;

import java.util.List;

public interface ProductGateway {
    List<Product> findByCategory(Category category);
    Long createProduct(Product product);
    Product editProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> findProducts();
}
