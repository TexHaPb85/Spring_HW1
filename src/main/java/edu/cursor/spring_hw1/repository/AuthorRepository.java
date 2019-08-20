package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    /**How can I implement it?????
     @Query("select * from books where authorID = id")
     List<Book> getBooksByAuthorId(Long id);
     */
}
