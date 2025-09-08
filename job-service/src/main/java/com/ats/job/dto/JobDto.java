package com.ats.job.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class JobDto {
    @JsonProperty("jobId")
    private int jobId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("location")
    private String location;

    @JsonProperty("postedDate")
    private Timestamp postedDate;

    public JobDto() {}

    public JobDto(int jobId, String title, String description, String location, Timestamp postedDate) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.postedDate = postedDate;
    }

    // Getters and Setters
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Timestamp getPostedDate() { return postedDate; }
    public void setPostedDate(Timestamp postedDate) { this.postedDate = postedDate; }
}
