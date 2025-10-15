package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookReview;

public interface BookReviewService {
    BookReview addBookReview(BookReview bookReview);
    boolean addBookReviewIfNotExists(BookReview bookReview);
    BookReview getBookReviewByIsbn(String isbn);
    List<BookReview> getAllBookReviews();
    BookReview updateRatingByIsbn(String isbn, int rating);
    BookReview updateCommentsByIsbn(String isbn, String comments);
}


