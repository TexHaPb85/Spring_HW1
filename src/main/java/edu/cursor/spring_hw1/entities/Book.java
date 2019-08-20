package edu.cursor.spring_hw1.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "description")
    private String description;
    @Column(name = "rating", nullable = false)
    private double rating;
    @Column(name = "authorID", nullable = false)
    private Long authorID;

    public Book(String title, String genre, String description, double rating, Long authorID) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.authorID = authorID;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                "}";
    }
}
