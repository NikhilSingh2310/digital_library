package com.ajackus.digitallibrary.mapper;

import com.ajackus.digitallibrary.dto.BookDTO;
import com.ajackus.digitallibrary.entity.Book;

public class BookMapper {

    public  static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(
                book.getId(),
                book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getAvailabilityStatus()
        );
    }

    public static  Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        return new Book(
                bookDTO.getId(),
                bookDTO.getBookId(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getGenre(),
                bookDTO.getAvailabilityStatus()
        );
    }
}