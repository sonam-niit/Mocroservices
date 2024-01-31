package com.demo.rest1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
}
