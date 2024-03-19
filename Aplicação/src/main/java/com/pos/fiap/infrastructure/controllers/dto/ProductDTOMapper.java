package com.pos.fiap.infrastructure.controllers.dto;

import com.pos.fiap.domain.entities.Product;

public class ProductDTOMapper {

    public ProductDTO toProductDTO(Product productObjDomain){
        return new ProductDTO(productObjDomain.name(), productObjDomain.category(), productObjDomain.description(), productObjDomain.image(), productObjDomain.price());
    }

    public Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getName(), productDTO.getCategory(), productDTO.getDescription(), productDTO.getImage(), productDTO.getPrice(), productDTO.getItens());
    }
}
