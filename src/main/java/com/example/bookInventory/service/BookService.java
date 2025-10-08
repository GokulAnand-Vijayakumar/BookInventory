package com.example.bookInventory.service;

import com.example.bookInventory.entity.Book;

import java.util.List;

public interface BookService {

    // Create a new Book
    Book save(Book book);

    // Get Book by ISBN
    Book getByIsbn(String isbn);

    // Get all Books
    List<Book> getAll();

    // Get Book by title
    Book getByTitle(String title);

    // Get Books by category
    List<Book> getByCategory(Integer category);

    // Get Books by publisher ID
    List<Book> getByPublisherId(Integer publisherId);

    // Update title by ISBN
    Book updateTitle(String isbn, String title);

    // Update description by ISBN
    Book updateDescription(String isbn, String description);

    // Update category by ISBN
    Book updateCategory(String isbn, Integer category);

    // Update edition by ISBN
    Book updateEdition(String isbn, String edition);

    // Update publisher by ISBN
    Book updatePublisher(String isbn, Integer publisherId);

    // Delete Book by ISBN
    void deleteByIsbn(String isbn);
}