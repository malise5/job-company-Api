package com.github.malise5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.malise5.demo.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
    
}
