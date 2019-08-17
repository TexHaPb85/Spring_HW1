package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(int idOfBook) {
        books.removeIf(book -> book.getId() == idOfBook);
    }

}
