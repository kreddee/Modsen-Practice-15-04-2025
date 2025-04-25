package org.example.libraryservice.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryservice.model.BookRecord;
import org.example.libraryservice.repository.BookRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookRecordService {

    private final BookRecordRepository repository;

    public List<BookRecord> getAllBooks() {
        return repository.findAll();
    }

    public List<BookRecord> getAvailableBooks() {
        return repository.findByAvailableTrue();
    }

    public Optional<BookRecord> getBookById(Long id) {
        return repository.findById(id);
    }

    public BookRecord rentBook(Long id, Long userId) {
        BookRecord book = repository.findById(id).orElseThrow();
        if (!book.getAvailable()) throw new RuntimeException("Book is not available");
        book.setAvailable(false);
        book.setRentedAt(LocalDateTime.now());
        book.setRentedBy(userId);
        return repository.save(book);
    }

    public BookRecord returnBook(Long id) {
        BookRecord book = repository.findById(id).orElseThrow();
        book.setAvailable(true);
        book.setRentedBy(null);
        return repository.save(book);
    }
}
