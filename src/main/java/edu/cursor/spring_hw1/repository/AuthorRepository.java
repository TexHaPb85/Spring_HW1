package edu.cursor.spring_hw1.repository;

import edu.cursor.spring_hw1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long aLong);

    Optional<Author> findAuthorByName(String name);

/*    @Modifying
    @Query("update Author author set author.firstname = ?1, u.lastname = ?2 where u.id = ?3")
    void updateAurhor(Author author, Long id);*/
}
