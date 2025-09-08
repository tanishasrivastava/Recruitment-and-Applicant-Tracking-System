package com.ats.job.model;

import java.sql.Timestamp;

public class Job {
    private int jobId;
    private String title;
    private String description;
    private String location;
    private Timestamp postedDate;

    public Job() {}

    public Job(int jobId, String title, String description, String location, Timestamp postedDate) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.postedDate = postedDate;
    }

    // Getters and Setters
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }
}
