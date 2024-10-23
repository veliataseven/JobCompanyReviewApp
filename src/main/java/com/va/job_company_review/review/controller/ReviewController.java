package com.va.job_company_review.review.controller;

import com.va.job_company_review.review.model.Review;
import com.va.job_company_review.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/companies/{companyId}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.findAll(companyId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getReviews(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.findById(companyId, reviewId);
        return ResponseEntity.ok(review);
    }

    @PostMapping("/companies/{companyId}/reviews")
    public ResponseEntity<Review> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        Review createdReview = reviewService.createReview(companyId, review);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        Review reviewUpdated = reviewService.updateReview(companyId, reviewId, review);
        return ResponseEntity.ok(reviewUpdated);
    }

    @DeleteMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Optional<Review> reviewDeleted = reviewService.deleteReview(companyId, reviewId);
        return reviewDeleted.map(ResponseEntity::ok).orElseThrow(() -> new IllegalArgumentException("Review not found"));
    }
}
