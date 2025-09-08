package com.ats.interview.repository;

import com.ats.interview.irepository.IInterviewRepository;
import com.ats.interview.model.Interview;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class InterviewRepositoryImpl implements IInterviewRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InterviewRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Interview> getAllInterviews() {
        return jdbcTemplate.query("SELECT * FROM interviews", new InterviewRowMapper());
    }

    @Override
    public Interview getInterviewById(int interviewId) {
        String sql = "SELECT * FROM interviews WHERE interview_id = ?";
        return jdbcTemplate.queryForObject(sql, new InterviewRowMapper(), interviewId);
    }

    @Override
    public Interview addInterview(Interview interview) {
        String sql = "INSERT INTO interviews (candidate_id, job_id, interview_date, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, interview.getCandidateId(), interview.getJobId(), interview.getInterviewDate(), interview.getStatus());
        return interview;
    }

    @Override
    public Interview updateInterview(Interview interview) {
        String sql = "UPDATE interviews SET candidate_id = ?, job_id = ?, interview_date = ?, status = ? WHERE interview_id = ?";
        jdbcTemplate.update(sql, interview.getCandidateId(), interview.getJobId(), interview.getInterviewDate(), interview.getStatus(), interview.getInterviewId());
        return interview;
    }

    @Override
    public Interview updateInterviewStatus(int interviewId, String status) {
        jdbcTemplate.update("UPDATE interviews SET status = ? WHERE interview_id = ?", status, interviewId);
        return getInterviewById(interviewId);
    }

    @Override
    public void deleteInterview(int interviewId) {
        jdbcTemplate.update("DELETE FROM interviews WHERE interview_id = ?", interviewId);
    }

    @Override
    public Integer getInterviewCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM interviews", Integer.class);
    }
}
