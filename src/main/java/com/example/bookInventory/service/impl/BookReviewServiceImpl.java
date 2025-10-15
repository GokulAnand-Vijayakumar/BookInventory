package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.repository.BookReviewRepository;
import com.example.bookInventory.service.BookReviewService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class BookReviewServiceImpl implements BookReviewService {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Override
    public BookReview addBookReview(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);
    }

    @Override
    public boolean addBookReviewIfNotExists(BookReview bookReview) {
        boolean exists = bookReviewRepository.existsByIsbn(bookReview.getIsbn());
        if (!exists) {
            bookReviewRepository.save(bookReview);
            return true;
        }
        return false;
    }

    @Override
    public BookReview getBookReviewByIsbn(String isbn) {
        return bookReviewRepository.findByIsbn(isbn);
    }

    @Override
    public List<BookReview> getAllBookReviews() {
        return bookReviewRepository.findAll();
    }

    @Override
    public BookReview updateRatingByIsbn(String isbn, int rating) {
        BookReview review = getBookReviewByIsbn(isbn);
        if (review != null) {
            review.setRating(rating);
            return bookReviewRepository.save(review);
        }
        return null;
    }

    @Override
    public BookReview updateCommentsByIsbn(String isbn, String comments) {
        BookReview review = getBookReviewByIsbn(isbn);
        if (review != null) {
            review.setComment(comments);
            return bookReviewRepository.save(review);
        }
        return null;
    }
}