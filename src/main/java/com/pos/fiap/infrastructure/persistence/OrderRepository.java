package com.pos.fiap.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.status != 'FINALIZADO' ORDER BY " +
            "CASE o.status " +
            "WHEN 'PRONTO' THEN 0 " +
            "WHEN 'PREPARANDO' THEN 1 " +
            "WHEN 'RECEBIDO' THEN 2 " +
            "END ASC, o.dataCriacao ASC")
    List<OrderEntity> buscarProdutosNaoFinalizadosOrdenadosPorStatusDesc();
}
