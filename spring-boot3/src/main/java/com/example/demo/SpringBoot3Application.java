package com.example.demo;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBoot3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader()
    {
        return args -> {
            log.info("CommandLineRunner called");
        };
    }

    @Bean
    public ApplicationRunner dataLoader2()
    {
        return args -> {
            log.info("ApplicationRunner called");
        };
    }

    private static Map<String, User> userRepo = new HashMap<>();

    static {
        User user1 = new User(1,"zbdy", "1111");
        User user2 = new User(2,"abcd", "1234");
        userRepo.put(user1.getUsername(), user1);
        userRepo.put(user2.getUsername(), user2);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        log.info("getAllUsers requested");
        return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
    }
}

