package com.supermarket.supermarket.repositories;

import com.supermarket.supermarket.entities.Order;
import com.supermarket.supermarket.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
