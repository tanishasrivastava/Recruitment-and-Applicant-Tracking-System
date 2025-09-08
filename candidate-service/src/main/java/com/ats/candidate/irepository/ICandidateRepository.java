package com.ats.candidate.irepository;

import java.util.List;
import com.ats.candidate.model.Candidate;

public interface ICandidateRepository {
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(int candidateId);
    Candidate addCandidate(Candidate candidate);
    Candidate updateCandidate(Candidate candidate);
    void deleteCandidate(int candidateId);
    Integer getCandidateCount();
}
