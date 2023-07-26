package com.supermarket.supermarket.services;

import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.repositories.OrderRepository;
import com.supermarket.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }
}
