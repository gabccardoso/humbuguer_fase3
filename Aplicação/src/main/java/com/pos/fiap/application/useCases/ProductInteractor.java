package com.pos.fiap.application.useCases;

import com.pos.fiap.application.gateways.ProductGateway;
import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.controllers.enums.Category;

import java.util.List;

public class ProductInteractor {

    private final ProductGateway productGateway;

    public ProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> findByCategory(Category category){
        return productGateway.findByCategory(category);
    }
    public Long createProduct(Product product){
        return productGateway.createProduct(product);
    }
    public Product editProduct(Long id, Product product){
        return productGateway.editProduct(id, product);
    }
    public void deleteProduct(Long id){
        productGateway.deleteProduct(id);
    }
    public List<Product> findProducts(){
        return productGateway.findProducts();
    }
}
