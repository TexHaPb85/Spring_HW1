package edu.cursor.spring_hw1.conroller;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.entities.Book;
import edu.cursor.spring_hw1.exceptions.AuthorNotFoundException;
import edu.cursor.spring_hw1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getAuthors() {
        return authorRepository.getAuthors().toString();
    }

    @GetMapping("/books/{id}")
    public List<Book> getAuthorBooks(@PathVariable Integer id) {
        return authorRepository.getAuthors().get(id).getBooks();
    }

    @GetMapping("{id}")
    public Author getAuthor(@PathVariable Integer id) {
        if (id.compareTo(authorRepository.getAuthors().size()) >= 0) {
            throw new AuthorNotFoundException("author with id " + id + " not found");
        }
        return authorRepository.getAuthors().get(id);
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author) {
        authorRepository.addAuthor(author);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorRepository.deleteAuthor(id);
    }

    @PutMapping("{id}")
    public void addBookToAuthor(@PathVariable Integer id, @RequestBody Book book) {
        authorRepository.addBook(id, book);
    }
}
