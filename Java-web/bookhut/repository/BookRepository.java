package com.bookhut.repository;

import com.bookhut.entities.Book;

import java.util.List;

public interface BookRepository {

    void saveBook(Book book);

    List<Book> getAllBooks();

    void deleteBookByTitle(String title);

    Book findBookByTitle(String title);
}
