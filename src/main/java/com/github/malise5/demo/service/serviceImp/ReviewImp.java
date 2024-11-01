package com.github.malise5.demo.service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.malise5.demo.model.Company;
import com.github.malise5.demo.model.Review;
import com.github.malise5.demo.repository.CompanyRepository;
import com.github.malise5.demo.repository.ReviewRepository;
import com.github.malise5.demo.service.ReviewService;

@Service
public class ReviewImp implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final CompanyRepository companyRepository;

    public ReviewImp(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> review = reviewRepository.findByCompanyId(companyId);
        return review.stream()
                .filter(r -> r.getId()
                        .equals(reviewId))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Boolean createReview(Long companyId, Review review) {

        Optional<Company> company = companyRepository.findById(companyId);

        if (company.isPresent()) {
            review.setCompany(company.get());
            reviewRepository.save(review);
            return true;
            // company.get().getReviews().add(review);
            // companyRepository.save(company.get());
        }

        return false;
    }

    @Override
    public Boolean updateReview(Long companyId, Long reviewId , Review review) {
        Optional<Company> comp= companyRepository.findById(companyId);
        if (comp.isPresent()) {
            review.setCompany(comp.get());
            review.setId(reviewId);
            reviewRepository.save(review);

            return true;
        }
        return false;

    }

    @Override
    public Boolean deleteReview(Long id) {
        Optional<Review> rv = reviewRepository.findById(id);
        if (rv.isPresent()) {
            reviewRepository.deleteById(id);
            return true;
        }

        return false;

    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long companyId) {
        List<Review> reviewList = reviewRepository.findByCompanyId(companyId);
        return reviewList;

    }

}
