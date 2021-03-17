package com.example.infnet.repository;

import com.example.infnet.dto.ProductDTO;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDTO, Long> {

}
