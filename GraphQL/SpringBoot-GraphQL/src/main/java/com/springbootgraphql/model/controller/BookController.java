package com.springbootgraphql.model.controller;

import com.springbootgraphql.model.dto.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private static Map<String, Book> books = Map.of(
            "1", new Book("1", "Harry Potter and the Philosopher's Stone", "J.K. Rowling"),
            "2", new Book("2", "The Hobbit", "J.R.R. Tolkien"),
            "3", new Book("3", "Harry Potter and the Chamber of Secrets", "J.K. Rowling")
    );

    @QueryMapping
    public Book getBookById(@Argument String id) {
        return books.get(id);
    }
    @QueryMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }
    @QueryMapping
    public List<Book> searchBooks(@Argument String title, @Argument String author) {
        return books.values().stream()
                .filter(book -> (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())))
                .filter(book -> (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .collect(Collectors.toList());
    }
}
