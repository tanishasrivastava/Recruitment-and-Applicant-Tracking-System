package com.ats.job.controller;

import com.ats.job.dto.JobDto;
import com.ats.job.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // CREATE
    @PostMapping
    public JobDto addJob(@RequestBody JobDto dto) {
        return jobService.addJob(dto);
    }

    // READ
    @GetMapping("/{id}")
    public JobDto getJob(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    // READ ALL
    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    // UPDATE
    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable int id, @RequestBody JobDto dto) {
        return jobService.updateJob(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
    }
}
