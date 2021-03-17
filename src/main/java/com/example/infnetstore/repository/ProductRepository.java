package com.example.infnetstore.repository;

import com.example.infnetstore.dto.ProductDTO;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDTO, Long> {

}
