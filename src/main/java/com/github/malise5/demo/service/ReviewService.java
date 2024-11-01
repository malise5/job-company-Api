package com.github.malise5.demo.service;

import java.util.List;

import com.github.malise5.demo.model.Review;

public interface ReviewService {

    List<Review> getAllReviews();

    List<Review> getAllReviewsByCompanyId(Long companyId);

    // Review getReviewByTitle(String title);

    // Review getReviewByRating(Double rating);

    Review getReviewById(Long companyId, Long reviewId);

    Boolean createReview(Long companyId, Review review);

    Boolean updateReview(Long id, Review review);

    Boolean deleteReview(Long id);
    
}
