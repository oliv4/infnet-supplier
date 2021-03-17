package com.example.infnet.controllers;

import java.util.List;
import java.util.Optional;

import com.example.infnet.dto.ProductDTO;
import com.example.infnet.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @PostMapping
    public ProductDTO storeProduct(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        Optional<ProductDTO> product = productService.getById(id);

        if (product.isEmpty()) return null;

        return product.get();
    }

    @PatchMapping("/{id}")
    public ProductDTO patchProduct(@RequestBody ProductDTO product, @PathVariable Long id) {
        if(!productService.exists(id)) return null;

        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public Optional<ProductDTO> deleteProduct(@PathVariable Long id) {
        if(!productService.exists(id)) return null;

        return productService.deleteById(id);
    }
}
