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
	    public BookReview updateRatingByIsbn(String isbn, int newRating) {
	        BookReview review = bookReviewRepository.findByIsbn(isbn);
	        if (review != null) {
	            review.setRating(newRating);
	            return bookReviewRepository.save(review);
	        }
	        return null;
	    }
    @Override
    public BookReview addBookReview1(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);
    }
 
    @Override
    public BookReview getBookReviewByIsbn(String isbn) {
        return bookReviewRepository.findByIsbn(isbn);
    }
 
    @Override
    public BookReview updateRatingByIsbn(String isbn, Integer rating) {
        BookReview review = getBookReviewByIsbn(isbn);
        review.setRating(rating);
        return bookReviewRepository.save(review);
    }
 
    @Override
    public BookReview updateCommentsByIsbn(String isbn, String comments) {
        BookReview review = getBookReviewByIsbn(isbn);
        review.setComment(comments);
        return bookReviewRepository.save(review);
    }

	@Override
	public List<BookReview> getAllBook() {
		// TODO Auto-generated method stub
		return bookReviewRepository.findAll();
	}

	@Override
	public boolean addBookReviewIfNotExists(BookReview bookReview) {
		// TODO Auto-generated method stub
		return false;
	}

}