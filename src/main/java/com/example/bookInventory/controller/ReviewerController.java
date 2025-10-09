package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.service.ReviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    @PostMapping("/post")
    public ResponseEntity<Reviewer> addReviewer(@RequestBody Reviewer reviewer) {
        return ResponseEntity.ok(reviewerService.save(reviewer));
    }

    @GetMapping("/{reviewerId}")
    public ResponseEntity<Reviewer> getReviewerById(@PathVariable Long reviewerId) {
        return ResponseEntity.ok(reviewerService.getById(reviewerId));
    }

    @GetMapping
    public ResponseEntity<List<Reviewer>> getAllReviewers() {
        return ResponseEntity.ok(reviewerService.getAll());
    }

    @PutMapping("/update/name/{reviewerId}")
    public ResponseEntity<Reviewer> updateReviewerName(@PathVariable Long reviewerId, @RequestBody String name) {
        return ResponseEntity.ok(reviewerService.updateName(reviewerId, name));
    }

    @PutMapping("/update/employedby/{reviewerId}")
    public ResponseEntity<Reviewer> updateReviewerEmployedBy(@PathVariable Long reviewerId, @RequestBody String employedBy) {
        return ResponseEntity.ok(reviewerService.updateEmployedBy(reviewerId, employedBy));
    }
}