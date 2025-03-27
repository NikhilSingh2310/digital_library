package com.ajackus.digitallibrary.repository;

import com.ajackus.digitallibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByBookId(String bookId);
}
