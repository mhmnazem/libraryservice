package com.onpier.libraryservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */

@Entity
@Table(name = "Borrowed")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Borrower")
    private String borrower;

    @Column(name = "book")
    private String book;

    @Column(name = "borrowed_from")
    private Date borrowed_from;

    @Column(name = "borrowed_to")
    private Date borrowed_to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getBorrowed_from() {
        return borrowed_from;
    }

    public void setBorrowed_from(Date borrowed_from) {
        this.borrowed_from = borrowed_from;
    }

    public Date getBorrowed_to() {
        return borrowed_to;
    }

    public void setBorrowed_to(Date borrowed_to) {
        this.borrowed_to = borrowed_to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrowed borrowed = (Borrowed) o;
        return Objects.equals(id, borrowed.id) && Objects.equals(borrower, borrowed.borrower) && Objects.equals(book, borrowed.book) && Objects.equals(borrowed_from, borrowed.borrowed_from) && Objects.equals(borrowed_to, borrowed.borrowed_to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrower, book, borrowed_from, borrowed_to);
    }

    @Override
    public String toString() {
        return "Borrowed{" +
                "id=" + id +
                ", borrower='" + borrower + '\'' +
                ", book='" + book + '\'' +
                ", borrowed_from=" + borrowed_from +
                ", borrowed_to=" + borrowed_to +
                '}';
    }
}
