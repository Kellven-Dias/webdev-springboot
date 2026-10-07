package com.webproject.webproject.config;

import com.webproject.webproject.entities.Category;
import com.webproject.webproject.entities.Order;
import com.webproject.webproject.entities.User;
import com.webproject.webproject.entities.enums.OrderStatus;
import com.webproject.webproject.repositories.CategoryRepository;
import com.webproject.webproject.repositories.OrderRepository;
import com.webproject.webproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

// Classe usada para configurações do ambiente de teste => por ex, seeds
// "CommandLineRunner" diz ao projeto para executar junto com a inicialização
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Autowired realiza a injeção de dependência automática através do spring
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2026-10-05T08:00:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2026-10-05T09:00:00Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2026-10-05T07:00:00Z"), OrderStatus.SHIPPED, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
