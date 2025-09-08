package com.ats.job.irepository;

import com.ats.job.model.Job;
import java.util.List;

public interface IJobRepository {
    List<Job> getAllJobs();
    Job getJobById(int jobId);
    Job addJob(Job job);
    Job updateJob(Job job);
    void deleteJob(int jobId);
}
