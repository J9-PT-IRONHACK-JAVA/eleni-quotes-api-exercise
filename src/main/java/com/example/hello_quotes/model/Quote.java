package com.example.hello_quotes.model;

import com.example.hello_quotes.dto.QuoteDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String genre;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant lastUpdatedAt;
    @Version
    private int version;
    public Quote(String message, String genre) {
        this.message = message;
        this.genre = genre;
    }

    public static Quote fromDTO(QuoteDTO quoteDTO){
        var quote = new Quote();
        quote.setMessage(quoteDTO.getMessage());
        quote.setGenre(quoteDTO.getGenre());
        return quote;
    }
}