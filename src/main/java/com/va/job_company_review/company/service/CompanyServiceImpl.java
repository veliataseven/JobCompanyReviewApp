package com.va.job_company_review.company.service;

import com.va.job_company_review.company.model.Company;
import com.va.job_company_review.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Optional<Company> companyToBeUpdated = companyRepository.findById(id);
        if (companyToBeUpdated.isPresent()) {
            Company updatedCompany = companyToBeUpdated.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            return companyRepository.save(updatedCompany);
        }
        else throw new IllegalArgumentException("Company not found");
    }

    @Override
    public Optional<Company> deleteCompany(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.delete(company.get());
            return company;
        }
        else throw new IllegalArgumentException("Company not found");
    }
}
