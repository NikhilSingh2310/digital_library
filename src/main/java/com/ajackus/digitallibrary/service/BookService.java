package com.ajackus.digitallibrary.service;

import com.ajackus.digitallibrary.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO addBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO getBookByTitle(String title);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}
