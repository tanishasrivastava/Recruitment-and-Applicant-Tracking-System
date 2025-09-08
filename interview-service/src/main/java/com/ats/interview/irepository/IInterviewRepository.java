package com.ats.interview.irepository;

import com.ats.interview.model.Interview;
import java.util.List;

public interface IInterviewRepository {
    List<Interview> getAllInterviews();
    Interview getInterviewById(int interviewId);
    Interview addInterview(Interview interview);
    Interview updateInterview(Interview interview);
    Interview updateInterviewStatus(int interviewId, String status);
    void deleteInterview(int interviewId);
    Integer getInterviewCount();
}
