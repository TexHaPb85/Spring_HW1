package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findBooksByAuthorID(Long id);
}
