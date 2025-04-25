package org.example.libraryservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private LocalDateTime rentedAt;
    private Boolean available;
    private Long rentedBy;
}
