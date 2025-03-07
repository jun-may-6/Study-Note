package com.springbootgraphql.model.service;

import com.springbootgraphql.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
//
//    public Book getBookById(String id) {
//        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public List<Book> getAllBooks() {
//        return books;
//    }
}