package com.estudandojava.services.services;


import com.estudandojava.services.entities.Category;
import com.estudandojava.services.entities.Product;

import com.estudandojava.services.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();

    }

    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
