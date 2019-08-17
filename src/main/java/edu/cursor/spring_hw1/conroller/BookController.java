package edu.cursor.spring_hw1.conroller;

import edu.cursor.spring_hw1.entities.Book;
import edu.cursor.spring_hw1.exceptions.BookNotFoundException;
import edu.cursor.spring_hw1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String getBooks() {
        return bookRepository.getBooks().toString();
    }

    @GetMapping("{genre}")
    public List<Book> getGenreSortedBooks(@PathVariable String genre) {
        return bookRepository.getBooks().stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Integer id) {
        if (id.compareTo(bookRepository.getBooks().size()) >= 0) {
            throw new BookNotFoundException("book with id " + id + " not found");
        }
        return bookRepository.getBooks().get(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.addBook(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteBook(id);
    }
}
