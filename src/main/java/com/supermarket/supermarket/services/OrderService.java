package com.supermarket.supermarket.services;

import com.supermarket.supermarket.dto.OrderDTO;
import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.entities.OrderItem;
import com.supermarket.supermarket.entities.Product;
import com.supermarket.supermarket.entities.User;
import com.supermarket.supermarket.entities.enums.OrderStatus;
import com.supermarket.supermarket.repositories.OrderItemRepository;
import com.supermarket.supermarket.repositories.OrderRepository;
import com.supermarket.supermarket.repositories.ProductRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public Object insert(OrderDTO orderDTO){
        Optional<User> client =  userRepository.findById(orderDTO.getClient_id());
        Optional<Product> product = productRepository.findById(orderDTO.getProduct_id());
        Instant moment = Instant.now();
        OrderStatus orderStatus = OrderStatus.WAITING_PAYMENT;

        Order newOrder = new Order(null, moment, orderStatus, client.get());
        orderRepository.save(newOrder);

        OrderItem orderItem = new OrderItem(newOrder, product.get(), orderDTO.getQuantity(), product.get().getPrice());
        return orderItemRepository.save(orderItem);
    }
}
