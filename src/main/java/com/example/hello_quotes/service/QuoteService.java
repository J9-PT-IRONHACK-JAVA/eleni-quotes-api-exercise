package com.example.hello_quotes.service;

import com.example.hello_quotes.dto.QuoteDTO;
import com.example.hello_quotes.exception.QuoteNotFoundException;
import com.example.hello_quotes.model.Quote;
import com.example.hello_quotes.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
    private Quote findQuoteById(Long id) {
        return quoteRepository.findById(id).orElseThrow(() -> new QuoteNotFoundException(id));
    }

    public QuoteDTO createQuote(QuoteDTO quote) {
        var quoteCreated = quoteRepository.save(Quote.fromDTO(quote));
        return QuoteDTO.fromQuote(quoteCreated);
    }

    public Quote updateQuote(Long id, Quote quote) {
        var quoteToUpdate = findQuoteById(id);
        quoteToUpdate.setMessage(quote.getMessage());
        quoteToUpdate.setGenre(quote.getGenre());
        return quoteRepository.save(quoteToUpdate);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

}