package com.supermarket.supermarket.config;

import com.supermarket.supermarket.entities.User;
import com.supermarket.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "MM", "mm@gmail.com", "99999", "12345");
        User user2 =new User(null, "AA", "AA@gmail.com", "88888", "12345");
        User user3 =new User(null, "CC", "cc@gmail.com", "77777", "12345");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));

    }
}
