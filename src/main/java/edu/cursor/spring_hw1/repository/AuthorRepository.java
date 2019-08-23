package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //void addBookToAuthor(Long authorId, Book book);//?????

    @Override
    Optional<Author> findById(Long aLong);

    //Optional<Author> findByLogin(String login);
}
