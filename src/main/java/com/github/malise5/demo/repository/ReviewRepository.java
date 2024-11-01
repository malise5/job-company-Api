package com.github.malise5.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.malise5.demo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    List<Review> findByCompanyId(Long companyId);
    
}
