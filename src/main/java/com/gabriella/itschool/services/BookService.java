package com.gabriella.itschool.services;

import com.gabriella.itschool.models.entities.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBook(long id);
    Book deleteBook(long id);
}
