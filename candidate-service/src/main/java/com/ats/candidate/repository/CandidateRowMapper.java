package com.ats.candidate.repository;

import com.ats.candidate.model.Candidate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRowMapper implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Candidate(
                rs.getInt("candidate_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("resume_link"),
                rs.getInt("applied_job_id")
        );
    }
}
