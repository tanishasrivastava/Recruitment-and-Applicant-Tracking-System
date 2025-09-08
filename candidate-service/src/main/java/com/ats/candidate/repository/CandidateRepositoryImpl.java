package com.ats.candidate.repository;

import com.ats.candidate.irepository.ICandidateRepository;
import com.ats.candidate.model.Candidate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class CandidateRepositoryImpl implements ICandidateRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return jdbcTemplate.query("SELECT * FROM candidates", new CandidateRowMapper());
    }

    @Override
    public Candidate getCandidateById(int candidateId) {
        String sql = "SELECT * FROM candidates WHERE candidate_id = ?";
        return jdbcTemplate.queryForObject(sql, new CandidateRowMapper(), candidateId);
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidates (name, email, resume_link, applied_job_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, candidate.getName(), candidate.getEmail(), candidate.getResumeLink(), candidate.getAppliedJobId());
        return candidate;
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        String sql = "UPDATE candidates SET name = ?, email = ?, resume_link = ?, applied_job_id = ? WHERE candidate_id = ?";
        jdbcTemplate.update(sql, candidate.getName(), candidate.getEmail(), candidate.getResumeLink(), candidate.getAppliedJobId(), candidate.getCandidateId());
        return candidate;
    }

    @Override
    public void deleteCandidate(int candidateId) {
        String sql = "DELETE FROM candidates WHERE candidate_id = ?";
        jdbcTemplate.update(sql, candidateId);
    }

    @Override
    public Integer getCandidateCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidates", Integer.class);
    }
}
