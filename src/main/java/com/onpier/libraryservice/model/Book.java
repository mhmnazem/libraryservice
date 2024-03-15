package com.onpier.libraryservice.model;

import jakarta.persistence.*;

import java.util.Objects;


/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Publisher")
    private String publisher;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, publisher);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}