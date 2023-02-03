package com.example.securityhibernate.configs;

import com.example.securityhibernate.models.Role;
import com.example.securityhibernate.models.User;
import com.example.securityhibernate.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Logger;

@Configuration
public class Database {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setUsername("admin");
                user.setRole(Role.ROLE_USER);
                user.setPassword(passwordEncoder.encode("admin"));
                System.out.println("Insert User: " + userRepository.save(user));
            }
        };
    }
}
