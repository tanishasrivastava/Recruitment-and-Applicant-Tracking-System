package com.ats.job.service;

import com.ats.job.dto.JobDto;
import com.ats.job.irepository.IJobRepository;
import com.ats.job.model.Job;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private final IJobRepository jobRepository;
    private final ModelMapper modelMapper;

    public JobService(IJobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    public JobDto addJob(JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        Job saved = jobRepository.addJob(job);
        return modelMapper.map(saved, JobDto.class);
    }

    public JobDto getJobById(int id) {
        Job job = jobRepository.getJobById(id);
        return modelMapper.map(job, JobDto.class);
    }

    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.getAllJobs();
        List<JobDto> dtos = new ArrayList<>();
        for (Job j : jobs) {
            dtos.add(modelMapper.map(j, JobDto.class));
        }
        return dtos;
    }

    public JobDto updateJob(int id, JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        job.setJobId(id);
        Job updated = jobRepository.updateJob(job);
        return modelMapper.map(updated, JobDto.class);
    }

    public void deleteJob(int id) {
        jobRepository.deleteJob(id);
    }
}
