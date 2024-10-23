package com.va.job_company_review.job.service;

import com.va.job_company_review.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface JobService {

    List<Job> findAll();

    Optional<Job> findById(Long id);

    Job createJob(Job job);

    Optional<Job> deleteJob(Long id);

    Job updateJob(Long id, Job job);
}
