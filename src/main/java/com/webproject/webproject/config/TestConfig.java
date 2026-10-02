package com.webproject.webproject.config;

import com.webproject.webproject.entities.User;
import com.webproject.webproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// Classe usada para configurações do ambiente de teste => por ex, seeds
// "CommandLineRunner" diz ao projeto para executar junto com a inicialização
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Autowired realiza a injeção de dependência automática através do spring
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
