package com.pos.fiap.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItensRepository extends JpaRepository<OrderItensEntity, Long> {
}
