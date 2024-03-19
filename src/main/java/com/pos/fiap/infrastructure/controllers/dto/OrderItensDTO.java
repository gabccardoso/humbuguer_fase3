package com.pos.fiap.infrastructure.controllers.dto;

public class OrderItensDTO {
    Long productId;
    int quantity;

    public OrderItensDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderItensDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
