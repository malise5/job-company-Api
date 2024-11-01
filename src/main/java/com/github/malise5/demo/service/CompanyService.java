package com.github.malise5.demo.service;

import java.util.List;

import com.github.malise5.demo.model.Company;

public interface CompanyService {

    List<Company> getCompanyList();

    Company getCompanyById(Long id);

    Company createCompany(Company company);

    Boolean updateCompany(Long id ,Company company);

    Boolean deleteCompany(Long id);

    
}