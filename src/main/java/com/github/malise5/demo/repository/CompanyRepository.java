package com.github.malise5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.malise5.demo.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
