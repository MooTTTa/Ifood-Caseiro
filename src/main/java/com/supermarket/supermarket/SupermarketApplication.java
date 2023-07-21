package com.supermarket.supermarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan({ "com.supermarket.supermarket",
//		"application.properties",
//		"application-test.properties"})
@SpringBootApplication()
public class SupermarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketApplication.class, args);
	}

}
