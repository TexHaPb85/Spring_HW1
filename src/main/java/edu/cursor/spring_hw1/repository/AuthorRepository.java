package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.entities.Book;

import java.util.List;

public interface AuthorRepository {

    List<Author> getAuthors();

    void addAuthor(Author author);

    void deleteAuthor(int idOfAuthor);

    void addBook(Integer idOfAuthor, Book book);
}
