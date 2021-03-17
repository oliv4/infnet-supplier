package com.example.infnetstore.services;

import java.util.List;
import java.util.Optional;

import com.example.infnetstore.dto.ProductDTO;
import com.example.infnetstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return (List<ProductDTO>) productRepository.findAll();
    }

    public ProductDTO save(ProductDTO product) {
        return productRepository.save(product);
    }

    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id);
    }

    public ProductDTO update(ProductDTO product, Long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    public Boolean exists(Long id) {
        return productRepository.existsById(id);
    }

    public Optional<ProductDTO> deleteById(Long id) {
        Optional<ProductDTO> product = productRepository.findById(id);
        productRepository.deleteById(id);

        return product;
    }
}
