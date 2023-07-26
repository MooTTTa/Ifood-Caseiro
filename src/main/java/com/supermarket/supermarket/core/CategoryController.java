package com.supermarket.supermarket.core;

import com.supermarket.supermarket.entities.Category;
import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.services.CategoryService;
import com.supermarket.supermarket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.findById(id)).getBody();
    }

}
