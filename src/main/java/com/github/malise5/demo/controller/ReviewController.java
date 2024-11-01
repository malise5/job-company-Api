package com.github.malise5.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.malise5.demo.model.Review;
import com.github.malise5.demo.service.serviceImp.CompanyImpl;
import com.github.malise5.demo.service.serviceImp.ReviewImp;

@RestController
@RequestMapping("/api/companies/{companyId}")
public class ReviewController {

    private final ReviewImp reviewImp;
    private final CompanyImpl companyImpl;

    public ReviewController(ReviewImp reviewImp, CompanyImpl companyImpl) {
        this.reviewImp = reviewImp;
        this.companyImpl = companyImpl;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getById(@PathVariable Long companyId) {
        List<Review> existingReviw = reviewImp.getAllReviewsByCompanyId(companyId);

        if (existingReviw != null) {
            return ResponseEntity.status(HttpStatus.OK).body(existingReviw);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId) {
        Review existingReviw = reviewImp.getReviewById(companyId, reviewId);
        
        return new ResponseEntity<Review>(existingReviw, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewImp.createReview(companyId, review);

        if (isReviewSaved){
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Review failed to be added", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // @PutMapping("/reviews/{reviewId}")
    // public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review) {
    //     Boolean existingReview = reviewImp.updateReview(id, review);

    //     if (existingReview) {

    //         return ResponseEntity.status(HttpStatus.OK).body("Review updated successfully");

    //     }

    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
    // }



    // @DeleteMapping("/{id}")
    // public ResponseEntity<String> deleteReview(@PathVariable Long id) {

    //     Boolean existingReview = reviewImp.deleteReview(id);
    //     if (existingReview) {
    //         return ResponseEntity.status(HttpStatus.OK).body("Review deleted successfully");
    //     }
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
    // }

}
