package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void deleteAuthor(int idOfAuthor) {
        authors.removeIf(author -> author.getId() == idOfAuthor);
    }

    @Override
    public void addBook(Integer idOfAuthor, Book book) {
        authors.get(idOfAuthor).addBook(book);
    }
}

