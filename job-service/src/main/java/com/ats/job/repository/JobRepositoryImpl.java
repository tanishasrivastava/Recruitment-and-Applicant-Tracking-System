package com.ats.job.repository;

import com.ats.job.irepository.IJobRepository;
import com.ats.job.model.Job;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class JobRepositoryImpl implements IJobRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Job> getAllJobs() {
        return jdbcTemplate.query("SELECT * FROM jobs", new JobRowMapper());
    }

    @Override
    public Job getJobById(int jobId) {
        String sql = "SELECT * FROM jobs WHERE job_id = ?";
        return jdbcTemplate.queryForObject(sql, new JobRowMapper(), jobId);
    }

    @Override
    public Job addJob(Job job) {
        String sql = "INSERT INTO jobs (title, description, location) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getLocation());
            return ps;
        }, keyHolder);

        job.setJobId(keyHolder.getKey().intValue());
        return getJobById(job.getJobId());
    }

    @Override
    public Job updateJob(Job job) {
        String sql = "UPDATE jobs SET title = ?, description = ?, location = ? WHERE job_id = ?";
        jdbcTemplate.update(sql, job.getTitle(), job.getDescription(), job.getLocation(), job.getJobId());
        return getJobById(job.getJobId());
    }

    @Override
    public void deleteJob(int jobId) {
        jdbcTemplate.update("DELETE FROM jobs WHERE job_id = ?", jobId);
    }
}

