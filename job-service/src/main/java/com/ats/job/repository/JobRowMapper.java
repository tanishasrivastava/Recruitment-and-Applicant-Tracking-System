package com.ats.job.repository;

import com.ats.job.model.Job;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRowMapper implements RowMapper<Job> {
    @Override
    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Job(
                rs.getInt("job_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("location"),
                rs.getTimestamp("posted_date")
        );
    }
}
