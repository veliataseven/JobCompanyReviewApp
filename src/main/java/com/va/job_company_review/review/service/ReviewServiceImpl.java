package com.va.job_company_review.review.service;

import com.va.job_company_review.company.model.Company;
import com.va.job_company_review.company.service.CompanyService;
import com.va.job_company_review.review.model.Review;
import com.va.job_company_review.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAll(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review createReview(Long companyId, Review review) {
        Optional<Company> company = companyService.findById(companyId);
        if (company.isPresent()) {
            review.setCompany(company.get());
            return reviewRepository.save(review);
        } else throw new IllegalArgumentException("Company not found");
    }

    @Override
    public Review findById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        Review review = reviews.stream()
                .filter(r -> r.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
        if (review != null) {
            return review;
        } else throw new IllegalArgumentException("Review not found");
    }

    @Override
    public Review updateReview(Long companyId, Long reviewId, Review review) {
        Optional<Company> company = companyService.findById(companyId);
        if (company.isPresent()) {
            review.setId(review.getId());
            review.setCompany(company.get());
            return reviewRepository.save(review);
        } else throw new IllegalArgumentException("Review not found");
    }

    @Override
    public Optional<Review> deleteReview(Long companyId, Long reviewId) {
        Optional<Company> company = companyService.findById(companyId);
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        Review review = reviews.stream()
                .filter(r -> r.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
        if (company.isPresent() && review != null) {
            company.get().getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId, company.get());
            reviewRepository.delete(review);
            return Optional.of(review);
        } else throw new IllegalArgumentException("Review or Company not found");
    }
}
