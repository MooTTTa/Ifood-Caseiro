package com.supermarket.supermarket.repositories;

import com.supermarket.supermarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
