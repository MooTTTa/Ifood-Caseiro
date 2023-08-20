package com.supermarket.supermarket.services;

import com.supermarket.supermarket.dto.OrderDTO;
import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.entities.User;
import com.supermarket.supermarket.entities.enums.OrderStatus;
import com.supermarket.supermarket.repositories.OrderRepository;
import com.supermarket.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public Order insert(OrderDTO orderDTO){
        User client =  orderDTO.getClient();
        Instant moment = Instant.now();
        OrderStatus orderStatus = OrderStatus.WAITING_PAYMENT;
        Order newOrder = new Order(null, moment, orderStatus, client);
        return orderRepository.save(newOrder);
    }
}
