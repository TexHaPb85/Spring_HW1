package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getBooks();

    void addBook(Book book);

    void deleteBook(int idOfBook);
}
