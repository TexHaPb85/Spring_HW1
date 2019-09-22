package edu.cursor.spring_hw1.service;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.exceptions.AuthorNotFoundException;
import edu.cursor.spring_hw1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService implements UserDetailsService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("author not found"));
    }

    public Author findByUserName(String userName) {
        return authorRepository
                .findAuthorByName(userName)
                .orElseThrow(() -> new AuthorNotFoundException("author with name " + userName + " not found"));
    }

    public Author saveAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author updateAuthor(Author author, Long id) {
        Author editedAuthor = authorRepository
                .findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found"));

        editedAuthor.setName(author.getName());
        editedAuthor.setSurName(author.getSurName());
        editedAuthor.setPassword(author.getPassword());
        return authorRepository.save(editedAuthor);
    }

    @Transactional
    public void removeAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByUserName(s);
    }
}
