package edu.cursor.spring_hw1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false, unique = true)
    private String name;
    @Column(name = "sur_name",nullable = false, unique = true)
    private String surName;

/*    private List<Book> books;*/

    public Author() {
        //this.books = new ArrayList<>();
    }

    public Author(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        //this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        //books.add(book);
    }

/*    public List<Book> getBooks() {
        return books;
    }*/

/*    public void setBooks(List<Book> books) {
        this.books = books;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "\nAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                //", book='" + books + '\'' +
                "}";
    }
}
