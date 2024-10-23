package com.va.job_company_review.company.controller;

import com.va.job_company_review.company.model.Company;
import com.va.job_company_review.company.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        return company.map(ResponseEntity::ok).orElseThrow(() -> new IllegalArgumentException("Company not found"));
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company companyCreated = companyService.createCompany(company);
        return ResponseEntity.ok(companyCreated);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company companyUpdated = companyService.updateCompany(id, company);
        return ResponseEntity.ok(companyUpdated);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        Optional<Company> company = companyService.deleteCompany(id);
        return company.map(ResponseEntity::ok).orElseThrow(() -> new IllegalArgumentException("Company not found"));
    }
}
