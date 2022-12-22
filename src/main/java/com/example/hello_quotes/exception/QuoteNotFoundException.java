package com.example.hello_quotes.exception;

public class QuoteNotFoundException extends RuntimeException{
    public QuoteNotFoundException(Long id){
        super("The quote with ID " + id + " was not found");
    }
}