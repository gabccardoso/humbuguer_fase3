package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.persistence.ProductEntity;

public class ProductEntityMapper {

    ProductEntity toEntity(Product productObjDomain){
        return new ProductEntity(productObjDomain.name(), productObjDomain.category(), productObjDomain.description(), productObjDomain.image(), productObjDomain.price());
    }

    Product toObjDomain(ProductEntity productEntity){
        return new Product(productEntity.getName(), productEntity.getCategory(), productEntity.getDescription(), productEntity.getImage(), productEntity.getPrice(), productEntity.getItens());
    }
}
