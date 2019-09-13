package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>{

}
