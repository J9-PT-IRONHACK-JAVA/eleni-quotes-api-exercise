package com.example.hello_quotes.dto;


import com.example.hello_quotes.model.Quote;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuoteDTO {
    private Long id;
    @NotBlank(message = "Message can't be blank")
    private String message;
    @NotBlank(message = "Genre can't be blank")
    private String genre;


    public static QuoteDTO fromQuote(Quote quote){
        var quoteDTO = new QuoteDTO();
        quoteDTO.setId(quote.getId());
        quoteDTO.setMessage(quote.getMessage());
        quoteDTO.setGenre(quote.getGenre());
        return quoteDTO;
    }
}