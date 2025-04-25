package org.example.libraryservice.repository;

import org.example.libraryservice.model.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRecordRepository extends JpaRepository<BookRecord, Long> {
    List<BookRecord> findByAvailableTrue();
}
