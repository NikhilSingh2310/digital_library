package com.ajackus.digitallibrary.service.impl;

import com.ajackus.digitallibrary.dto.BookDTO;
import com.ajackus.digitallibrary.entity.Book;
import com.ajackus.digitallibrary.mapper.BookMapper;
import com.ajackus.digitallibrary.repository.BookRepository;
import com.ajackus.digitallibrary.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        book = bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper::toDTO)  // Removed method reference
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)  // Removed method reference
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public BookDTO getBookByTitle(String title) {
        return bookRepository.findByTitle(title)
                .map(BookMapper::toDTO)  // Removed method reference
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setBookId(bookDTO.getBookId());
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setGenre(bookDTO.getGenre());
        existingBook.setAvailabilityStatus(bookDTO.getAvailabilityStatus());

        existingBook = bookRepository.save(existingBook);
        return BookMapper.toDTO(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
