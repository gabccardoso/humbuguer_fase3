package com.pos.fiap.infrastructure.persistence;

import com.pos.fiap.infrastructure.controllers.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategory(Category category);
}
