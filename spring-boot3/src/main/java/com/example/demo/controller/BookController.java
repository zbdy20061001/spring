package com.example.demo.controller;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BookController {

    @Autowired
    private BookRepository bookRepo;


    //curl -i -u zbdy:1234  http://localhost:8080/books
    //eqaul to below. "echo -n zbdy:1234" => emJkeToxMjM0
    //curl -i -H "Authorization: Basic emJkeToxMjM0"  http://localhost:8080/books
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> getAllBooks() {
        log.info("getAllBooks requested");
        return bookRepo.findAll();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
