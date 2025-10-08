package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookReview;

public interface ReviewService {
    BookReview save(BookReview obj);
    BookReview getById(Long id);
    List<BookReview> getAll();
    void deleteById(Long id);
}