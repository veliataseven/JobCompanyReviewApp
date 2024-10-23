package com.va.job_company_review.company.service;

import com.va.job_company_review.company.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    
    List<Company> findAll();

    Optional<Company> findById(Long id);

    Company createCompany(Company company);

    Company updateCompany(Long id, Company company);

    Optional<Company> deleteCompany(Long id);
}
