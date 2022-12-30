package com.estudandojava.services.repositories;


import com.estudandojava.services.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
