package com.github.nagaseyasuhito.sample.mysql.replication;

import com.github.nagaseyasuhito.sample.mysql.replication.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.findAll().stream()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
