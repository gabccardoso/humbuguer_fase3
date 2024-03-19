package com.pos.fiap.infrastructure.controllers.dto;


import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.controllers.enums.Category;
import com.pos.fiap.infrastructure.persistence.OrderItensEntity;

import java.util.List;

public class ProductDTO {

    private String name;
    private Category category;
    private String description;
    private String image;
    private Double price;
    List<OrderItensEntity> itens;

    public ProductDTO() {
    }

    public ProductDTO(String name, Category category, String description, String image, Double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderItensEntity> getItens() {
        return itens;
    }

    public void setItens(List<OrderItensEntity> itens) {
        this.itens = itens;
    }
}
