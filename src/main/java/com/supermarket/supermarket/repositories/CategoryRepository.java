package com.supermarket.supermarket.repositories;

import com.supermarket.supermarket.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
