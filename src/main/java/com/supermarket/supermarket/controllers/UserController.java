package com.supermarket.supermarket.controllers;

import com.supermarket.supermarket.entities.User;
import com.supermarket.supermarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id)).getBody();
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(user.getId()).toUri()).body(userService.insert(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok().body(userService.update(id, user));
    }

}
