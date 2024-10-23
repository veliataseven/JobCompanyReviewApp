package com.va.job_company_review.review.service;

import com.va.job_company_review.review.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll(Long companyId);

    Review createReview(Long companyId, Review review);

    Review findById(Long companyId, Long reviewId);

    Review updateReview(Long companyId, Long reviewId, Review review);

    Optional<Review> deleteReview(Long companyId, Long reviewId);
}
