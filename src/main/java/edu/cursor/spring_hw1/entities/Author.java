package edu.cursor.spring_hw1.entities;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String name;
    private String surName;
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(int id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", book='" + books + '\'' +
                "}";
    }
}
