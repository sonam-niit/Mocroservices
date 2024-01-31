package com.demo.rest1.service;
// ProductService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest1.model.Product;
import com.demo.rest1.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Product addNewProduct(Product product) {
    	return productRepository.save(product);
    }
    
    public List<Product> getAllProduct(){
    	return productRepository.findAll();
    }
    
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

}
