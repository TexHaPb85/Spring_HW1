package edu.cursor.spring_hw1.service;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.exceptions.AuthorNotFoundException;
import edu.cursor.spring_hw1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id){
        return authorRepository
                .findById(id)
                .orElseThrow(()->new AuthorNotFoundException("author not found"));
    }



    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthorById(Long id){
        authorRepository.deleteById(id);
    }


}
