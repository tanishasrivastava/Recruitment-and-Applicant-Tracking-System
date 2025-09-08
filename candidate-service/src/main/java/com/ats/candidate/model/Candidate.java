package com.ats.candidate.model;

public class Candidate {
    private int candidateId;
    private String name;
    private String email;
    private String resumeLink;
    private int appliedJobId;

    public Candidate() {}

    public Candidate(int candidateId, String name, String email, String resumeLink, int appliedJobId) {
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
