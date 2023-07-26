package com.supermarket.supermarket.core;

import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.entities.Product;
import com.supermarket.supermarket.services.OrderService;
import com.supermarket.supermarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findById(id)).getBody();
    }

}
