package edu.cursor.spring_hw1.service;

import edu.cursor.spring_hw1.entities.Book;
import edu.cursor.spring_hw1.exceptions.BookNotFoundException;
import edu.cursor.spring_hw1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findById(Long id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("book with id " + id + "not found"));
    }

    public List<Book> findBooksByAuthorId(Long id){
        return bookRepository.findBooksByAuthorID(id);
    }
}
