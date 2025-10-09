package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // surrogate key for simplicity

    @Column(name = "ISBN", length = 13, nullable = false)
    private String isbn;

    @Column(name = "AuthorID", nullable = false)
    private Integer authorId;

    @Column(name = "PrimaryAuthor", length = 1)
    private String primaryAuthor;

    public BookAuthor() {}

    public BookAuthor(String isbn, Integer authorId, String primaryAuthor) {
        this.isbn = isbn;
        this.authorId = authorId;
        this.primaryAuthor = primaryAuthor;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getPrimaryAuthor() {
        return primaryAuthor;
    }

    public void setPrimaryAuthor(String primaryAuthor) {
        this.primaryAuthor = primaryAuthor;
    }

    @Override
    public String toString() {
        return "BookAuthor [id=" + id + ", isbn=" + isbn + ", authorId=" + authorId + ", primaryAuthor=" + primaryAuthor + "]";
    }
}