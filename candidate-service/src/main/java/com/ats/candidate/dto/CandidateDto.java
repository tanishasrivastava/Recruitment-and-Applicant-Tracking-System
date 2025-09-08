package com.ats.candidate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidateDto {
    @JsonProperty("candidateId")
    private int candidateId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("resumeLink")
    private String resumeLink;

    @JsonProperty("appliedJobId")
    private int appliedJobId;

    public CandidateDto() {}

    public CandidateDto(int candidateId, String name, String email, String resumeLink, int appliedJobId) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.resumeLink = resumeLink;
        this.appliedJobId = appliedJobId;
    }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getResumeLink() { return resumeLink; }
    public void setResumeLink(String resumeLink) { this.resumeLink = resumeLink; }

    public int getAppliedJobId() { return appliedJobId; }
    public void setAppliedJobId(int appliedJobId) { this.appliedJobId = appliedJobId; }
}
