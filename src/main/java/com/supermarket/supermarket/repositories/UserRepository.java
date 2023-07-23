package com.supermarket.supermarket.repositories;

import com.supermarket.supermarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
