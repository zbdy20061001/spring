package com.example.demo;

import com.example.demo.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;
@SpringBootApplication
@Slf4j
public class SpringBoot3Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Application.class, args);
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("home");
//        registry.addViewController("/home").setViewName("home");
//    }


    /******* Bean ***************/
    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            log.info("CommandLineRunner called");
        };
    }

    @Bean
    public ApplicationRunner dataLoader2() {
        return args -> {
            log.info(new BCryptPasswordEncoder().encode("1234"));
            log.info("ApplicationRunner called");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    InMemory
//    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> usersList = new ArrayList<>();
//        usersList.add(new User("zbdy", encoder.encode("1234"), List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        usersList.add(new User("abcd", encoder.encode("1234"), List.of(new SimpleGrantedAuthority("ROLE_OTHER"))));
        UserDetails user1 = User.withUsername("zbdy").password(encoder.encode("1234")).roles("USER").build();
        UserDetails user2 = User.withUsername("abcd").password(encoder.encode("1234")).roles("OTHER").build();
        usersList.add(user1);
        usersList.add(user2);
        return new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            com.example.demo.model.User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}

