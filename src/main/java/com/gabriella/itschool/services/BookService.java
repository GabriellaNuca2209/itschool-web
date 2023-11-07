package com.gabriella.itschool.services;

import com.gabriella.itschool.models.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
}
