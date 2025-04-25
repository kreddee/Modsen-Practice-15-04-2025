package org.example.libraryservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.libraryservice.model.BookRecord;
import org.example.libraryservice.service.BookRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class BookRecordController {

    private final BookRecordService service;

    @GetMapping("/all")
    public List<BookRecord> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/available")
    public List<BookRecord> getAvailableBooks() {
        return service.getAvailableBooks();
    }

    @GetMapping("/{id}")
    public BookRecord getBookById(@PathVariable Long id) {
        return service.getBookById(id).orElse(null);
    }

    @PostMapping("/rent/{id}")
    public BookRecord rentBook(@PathVariable Long id, @RequestParam Long userId) {
        return service.rentBook(id, userId);
    }

    @PostMapping("/return/{id}")
    public BookRecord returnBook(@PathVariable Long id) {
        return service.returnBook(id);
    }
}
