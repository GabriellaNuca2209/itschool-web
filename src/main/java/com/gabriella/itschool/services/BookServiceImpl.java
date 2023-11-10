package com.gabriella.itschool.services;

import com.gabriella.itschool.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    List<Book> bookList = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        if (!isValid(book)) {
            throw new RuntimeException("Invalid input");
        }

        long bookId = bookList.size() + 1L;
        book.setId(bookId);

        // save the book
        bookList.add(book);
        log.info("Book with id {} has been created", bookId);

        return bookList.get((int) bookId - 1);
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("Retrieved all book list");

        return bookList;
    }

    public Book getBook(long id) {
        return bookList.get((int) id - 1);
    }

    public Book deleteBook(long id) {
        log.info("Book with id {} has been deleted", id);

        return bookList.remove((int) id - 1);
    }

    // Validation

    private boolean isValid(Book book) {
        return !book.getTitle().isEmpty() || !book.getAuthor().isEmpty() || book.getPrice() != null;
    }
}
