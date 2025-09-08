package com.ats.interview.model;

import java.time.LocalDateTime;

public class Interview {
    private int interviewId;
    private int candidateId;
    private int jobId;
    private LocalDateTime interviewDate;
    private String status;

    public Interview() {}

    public Interview(int interviewId, int candidateId, int jobId, LocalDateTime interviewDate, String status) {
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
