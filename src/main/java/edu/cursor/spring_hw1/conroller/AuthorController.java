package edu.cursor.spring_hw1.conroller;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getAuthors() {
        return authorService.getAllAuthors().toString();
    }

/*    @GetMapping("/books/{id}")
    public List<Book> getAuthorBooks(@PathVariable Long id) {
        return
    }*/

    @GetMapping("{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.removeAuthorById(id);
    }

/*    @PutMapping("{id}")
    public void addBookToAuthor(@PathVariable Integer id, @RequestBody Book book) {
        authorService
    }*/
}
