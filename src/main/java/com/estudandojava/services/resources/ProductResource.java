package com.estudandojava.services.resources;


import com.estudandojava.services.entities.Category;
import com.estudandojava.services.entities.Product;
import com.estudandojava.services.services.CategoryService;
import com.estudandojava.services.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> list= productService.findAllProducts();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Product product=productService.findProductById(id);
        return ResponseEntity.ok().body(product);

    }
}
