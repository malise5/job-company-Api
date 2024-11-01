package com.github.malise5.demo.service;

import java.util.List;

import com.github.malise5.demo.model.Job;

public interface JobService {

    List<Job> findaAll();

    void createJob(Job job);

    Job findJobById(Long id);

    Boolean deleteJobById(Long id);

    Boolean updateJob(Long id, Job item);

    
} 