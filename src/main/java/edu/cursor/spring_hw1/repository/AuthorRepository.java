package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import edu.cursor.spring_hw1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //void addBookToAuthor(Long authorId, Book book);//?????
}
