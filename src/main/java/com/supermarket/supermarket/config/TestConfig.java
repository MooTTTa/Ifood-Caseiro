package com.supermarket.supermarket.config;

import com.supermarket.supermarket.entities.*;
import com.supermarket.supermarket.entities.enums.OrderStatus;
import com.supermarket.supermarket.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Sorvete");
        Category cat2 = new Category(null, "Hamburguer");
        Category cat3 = new Category(null, "PF");

        Product p1 = new Product(null, "Milk Shake", "Milk shake refrescante", 10.5, "");
        Product p2 = new Product(null, "Pote 1L Sorvete", "% 5 sabores de sorvetes diferentes ", 50.0, "");
        Product p3 = new Product(null, "XBacon", "Xbacon mais gostoso da cidade", 12.0, "");
        Product p4 = new Product(null, "XSalada", "Xsalada mais gostoso da cidade", 12.0, "");
        Product p5 = new Product(null, "Jantinha", "vem com 5 pedaços de carne", 20.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "MM", "mm@gmail.com", "99999", "12345");
        User u2 =new User(null, "AA", "AA@gmail.com", "88888", "12345");
        User u3 =new User(null, "CC", "cc@gmail.com", "77777", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem orderItem = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem orderItem2 = new OrderItem(o1, p3, 1, p1.getPrice());
        OrderItem orderItem3 = new OrderItem(o2, p3, 2, p1.getPrice());
        OrderItem orderItem4 = new OrderItem(o3, p5, 2, p1.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem, orderItem2, orderItem3, orderItem4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);

    }
}
