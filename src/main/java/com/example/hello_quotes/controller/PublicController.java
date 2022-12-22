package com.example.hello_quotes.controller;


import com.example.hello_quotes.model.Quote;
import com.example.hello_quotes.repository.QuoteRepository;
import com.example.hello_quotes.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    private final QuoteService quoteService;

    @GetMapping
    public List<Quote> getAllQuotes () {
        return quoteService.getAllQuotes();
    }
}