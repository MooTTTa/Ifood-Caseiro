package com.supermarket.supermarket.repositories;

import com.supermarket.supermarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
