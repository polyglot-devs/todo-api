package com.polyglot.todo.controller;

import com.polyglot.todo.model.Book;
import com.polyglot.todo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> books() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/{name}/{description}")
    public ResponseEntity<List<Book>> addBook(@PathVariable String name, @PathVariable String description) {
        bookRepository.save(Book.of(name, description));
        return ResponseEntity.ok(bookRepository.findAll());
    }
}
