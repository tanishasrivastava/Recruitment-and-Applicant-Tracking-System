package com.ats.interview.repository;

import com.ats.interview.model.Interview;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewRowMapper implements RowMapper<Interview> {
    @Override
    public Interview mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Interview(
                rs.getInt("interview_id"),
                rs.getInt("candidate_id"),
                rs.getInt("job_id"),
                rs.getTimestamp("interview_date").toLocalDateTime(),
                rs.getString("status")
        );
    }
}
