package com.polyglot.todo.controller;

import com.polyglot.todo.model.Book;
import com.polyglot.todo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WelcomeController {
    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome, kocak!");
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> books() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/book/{name}/{description}")
    public ResponseEntity<List<Book>> addBook(@PathVariable String name, @PathVariable String description) {
        bookRepository.save(Book.of(name, description));
        return ResponseEntity.ok(bookRepository.findAll());
    }

}
