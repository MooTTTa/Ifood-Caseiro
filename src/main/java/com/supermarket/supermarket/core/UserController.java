package com.supermarket.supermarket.core;

import com.supermarket.supermarket.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @GetMapping(value = "/users")
    public ResponseEntity<User> findAll(){
        return ResponseEntity.ok().body(new User(1L, "MM", "mm@gmail.com", "99999", "12345"));
    }

}
