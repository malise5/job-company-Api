package com.github.malise5.demo.service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.malise5.demo.model.Job;
import com.github.malise5.demo.repository.JobRepository;
import com.github.malise5.demo.service.JobService;

@Service
public class JObServiceImp implements JobService {

    private final JobRepository jobRepository;


    public JObServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findaAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }

        
    }

    public Boolean updateJob(Long id, Job item) {
        
        Optional<Job> job = jobRepository.findById(id);

        if (job.isPresent()) {
            Job updatedJob = job.get();
            updatedJob.setDescription(item.getDescription());
            updatedJob.setTitle(item.getTitle());
            updatedJob.setMaxSalary(item.getMaxSalary());
            updatedJob.setMinSalary(item.getMinSalary());
            updatedJob.setLocation(item.getLocation());
            jobRepository.save(updatedJob);
            return true;
        }

        return false;
    }

}
