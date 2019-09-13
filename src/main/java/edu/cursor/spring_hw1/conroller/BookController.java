package edu.cursor.spring_hw1.conroller;

import edu.cursor.spring_hw1.entities.Book;
import edu.cursor.spring_hw1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("{genre}")
    public List<Book> getGenreSortedBooks(@PathVariable String genre) {
        return bookService.findAllBooks().stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
