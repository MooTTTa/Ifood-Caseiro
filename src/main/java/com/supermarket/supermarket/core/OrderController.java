package com.supermarket.supermarket.core;

import com.supermarket.supermarket.entities.Order;
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
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id)).getBody();
    }

}
