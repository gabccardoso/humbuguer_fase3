package com.pos.fiap.infrastructure.controllers;


import com.pos.fiap.application.useCases.ProductInteractor;
import com.pos.fiap.domain.entities.Product;
import com.pos.fiap.infrastructure.controllers.dto.ProductDTO;
import com.pos.fiap.infrastructure.controllers.dto.ProductDTOMapper;
import com.pos.fiap.infrastructure.controllers.enums.Category;
import com.pos.fiap.infrastructure.gateways.ProductRepositoryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProductController {

    private final ProductInteractor productInteractor;
    private final ProductDTOMapper productDTOMapper;

    public ProductController(ProductInteractor productInteractor, ProductDTOMapper productDTOMapper) {
        this.productInteractor = productInteractor;
        this.productDTOMapper = productDTOMapper;
    }

    @GetMapping(value = "buscarProdutoPorCategoria")
    public ResponseEntity<List<ProductDTO>> findByCategory(@RequestParam String categoriaBuscada){
        Category category = Category.valueOf(categoriaBuscada.toUpperCase());
        List<Product> products = productInteractor.findByCategory(category);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : products){
            productDTOList.add(productDTOMapper.toProductDTO(product));
        }
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping(value = "buscarProdutos")
    public ResponseEntity<List<ProductDTO>> buscarProdutos(){
        List<Product> products = productInteractor.findProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : products){
            productDTOList.add(productDTOMapper.toProductDTO(product));
        }
        return ResponseEntity.ok(productDTOList);
    }

    @PutMapping(value = "editarProduto/{id}")
    public ResponseEntity<ProductDTO> editarProduto(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        Product product = productInteractor.editProduct(id, productDTOMapper.toProduct(productDTO));
        return ResponseEntity.ok(productDTOMapper.toProductDTO(product));
    }

    @PostMapping(value = "criarProduto")
    public ResponseEntity<Long> criarProduto(@RequestBody ProductDTO productDTO){
        Long id = productInteractor.createProduct(productDTOMapper.toProduct(productDTO));
        return ResponseEntity.ok(id);
    }

    @DeleteMapping(value = "deletarProduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        productInteractor.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
