package com.example.hello_quotes.demo;

import com.example.hello_quotes.model.Quote;
import com.example.hello_quotes.model.User;
import com.example.hello_quotes.repository.QuoteRepository;
import com.example.hello_quotes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {

    private final UserRepository userRepository;

    private final QuoteRepository quoteRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser(){
        log.info("Starting demo user loading...");
        User user1 = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
        userRepository.save(user1);
        log.info("User " + user1.getUsername() + " was created successfully");

        User user2 = new User("admin", passwordEncoder.encode("admin"), "ROLE_USER,ROLE_ADMIN");
        userRepository.save(user2);
        log.info("User " + user2.getUsername() + " was created successfully");
        log.info("Finished demo user loading.");

        Quote quote1 = new Quote("Hell is other people", "theatre");
        quoteRepository.save(quote1);
        Quote quote2 = new Quote("Everything flows", "philosophy");
        quoteRepository.save(quote2);
        Quote quote3 = new Quote("I know only that I don't know anything", "philosophy");
        quoteRepository.save(quote3);

    }

}