package com.example.bookInventory.controller;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookreview")
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    // Add a new book review if it doesn't already exist
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addBookReview(@RequestBody BookReview bookReview) {
        boolean isAdded = bookReviewService.addBookReviewIfNotExists(bookReview);

        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Book review added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Book review already exists");
            return ResponseEntity.status(409).body(response);
        }
    }

    // Get all book reviews
    @GetMapping
    public ResponseEntity<List<BookReview>> getAllBookReviews() {
        List<BookReview> reviews = bookReviewService.getAllBookReviews();
        return ResponseEntity.ok(reviews);
    }

    // Get a review by ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBookReviewByIsbn(@PathVariable String isbn) {
        BookReview review = bookReviewService.getBookReviewByIsbn(isbn);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("code", "NOTFOUND");
            error.put("message", "Book review not found for ISBN: " + isbn);
            return ResponseEntity.status(404).body(error);
        }
    }

    // Update rating by ISBN
    @PutMapping("/update/rating/{isbn}")
    public ResponseEntity<?> updateRating(@PathVariable String isbn, @RequestBody Integer rating) {
        BookReview updatedReview = bookReviewService.updateRatingByIsbn(isbn, rating);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("code", "UPDATEFAIL");
            error.put("message", "Failed to update rating. Review not found for ISBN: " + isbn);
            return ResponseEntity.status(404).body(error);
        }
    }

    // Update comments by ISBN
    @PutMapping("/update/comments/{isbn}")
    public ResponseEntity<?> updateComments(@PathVariable String isbn, @RequestBody String comments) {
        BookReview updatedReview = bookReviewService.updateCommentsByIsbn(isbn, comments);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("code", "UPDATEFAIL");
            error.put("message", "Failed to update comments. Review not found for ISBN: " + isbn);
            return ResponseEntity.status(404).body(error);
        }
    }
}