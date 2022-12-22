package com.example.hello_quotes.repository;

import com.example.hello_quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByGenre(String genre);
}