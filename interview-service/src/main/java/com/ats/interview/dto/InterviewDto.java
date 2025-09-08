package com.ats.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class InterviewDto {
    @JsonProperty("interviewId")
    private int interviewId;

    @JsonProperty("candidateId")
    private int candidateId;

    @JsonProperty("jobId")
    private int jobId;

    @JsonProperty("interviewDate")
    private LocalDateTime interviewDate;

    @JsonProperty("status")
    private String status;

    public InterviewDto() {}

    public InterviewDto(int interviewId, int candidateId, int jobId, LocalDateTime interviewDate, String status) {
        this.interviewId = interviewId;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.interviewDate = interviewDate;
        this.status = status;
    }

    public int getInterviewId() { return interviewId; }
    public void setInterviewId(int interviewId) { this.interviewId = interviewId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public LocalDateTime getInterviewDate() { return interviewDate; }
    public void setInterviewDate(LocalDateTime interviewDate) { this.interviewDate = interviewDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
