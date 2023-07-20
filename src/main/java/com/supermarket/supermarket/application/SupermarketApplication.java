package com.supermarket.supermarket.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.supermarket.supermarket")
@SpringBootApplication()
public class SupermarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketApplication.class, args);
	}

}
