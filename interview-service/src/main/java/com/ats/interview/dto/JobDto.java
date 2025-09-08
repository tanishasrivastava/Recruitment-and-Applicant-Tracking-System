package com.ats.interview.dto;

public class JobDto {
    private int jobId;
    private String title;
    private String description;
    private String location;

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
}
