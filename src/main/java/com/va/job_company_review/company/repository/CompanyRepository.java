package com.va.job_company_review.company.repository;

import com.va.job_company_review.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
