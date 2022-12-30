package com.estudandojava.services.resources;


import com.estudandojava.services.entities.Category;
import com.estudandojava.services.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> list= categoryService.findAllCategories();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        Category order=categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(order);

    }
}
