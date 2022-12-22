package com.example.hello_quotes.controller;

import com.example.hello_quotes.dto.QuoteDTO;
import com.example.hello_quotes.model.Quote;
import com.example.hello_quotes.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("ultra")
@RestController
@RequiredArgsConstructor

public class TopSecretController {
    private final QuoteService quoteService;

    //Create a project that return a list of Quote. Quote has a message and a genre. you must be able to get, post, update and delete quotes.
    //secure you app by having get endpoints open to everyone, post endpoints reserved to users, and update/delete endpoints for admins.

    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable("id") Long id, @RequestBody Quote quote){
        return quoteService.updateQuote(id, quote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuote(@PathVariable("id") Long id){
        quoteService.deleteQuote(id);
    }


}