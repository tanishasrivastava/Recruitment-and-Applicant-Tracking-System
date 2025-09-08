package com.ats.interview.service;

import com.ats.interview.dto.CandidateDto;
import com.ats.interview.dto.InterviewDto;
import com.ats.interview.dto.JobDto;
import com.ats.interview.irepository.IInterviewRepository;
import com.ats.interview.model.Interview;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    private final IInterviewRepository interviewRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Value("${candidate.service.url}")
    private String candidateServiceUrl;

    @Value("${job.service.url}")
    private String jobServiceUrl;

    public InterviewService(IInterviewRepository interviewRepository,
                            ModelMapper modelMapper,
                            RestTemplate restTemplate) {
        this.interviewRepository = interviewRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    public InterviewDto addInterview(InterviewDto dto) {
       
        CandidateDto candidate;
        try {
            candidate = restTemplate.getForObject(
                    candidateServiceUrl + "/candidates/" + dto.getCandidateId(),
                    CandidateDto.class
            );
            if (candidate == null) {
                throw new RuntimeException(" Candidate not found with ID: " + dto.getCandidateId());
            }
        } catch (Exception e) {
            throw new RuntimeException(" Candidate not found with ID: " + dto.getCandidateId(), e);
        }

        // Validate Job
        JobDto job;
        try {
            job = restTemplate.getForObject(
                    jobServiceUrl + "/jobs/" + dto.getJobId(),
                    JobDto.class
            );
            if (job == null) {
                throw new RuntimeException(" Job not found with ID: " + dto.getJobId());
            }
        } catch (Exception e) {
            throw new RuntimeException(" Job not found with ID: " + dto.getJobId(), e);
        }

        //  Map & Save Interview
        Interview interview = modelMapper.map(dto, Interview.class);

        if (interview.getStatus() == null) {
            interview.setStatus("Pending");
        }

        interviewRepository.addInterview(interview);
        return modelMapper.map(interview, InterviewDto.class);
    }

    public InterviewDto getInterviewById(int id) {
        Interview interview = interviewRepository.getInterviewById(id);
        return modelMapper.map(interview, InterviewDto.class);
    }

    public List<InterviewDto> getAllInterviews() {
        return interviewRepository.getAllInterviews()
                .stream()
                .map(i -> modelMapper.map(i, InterviewDto.class))
                .collect(Collectors.toList());
    }

    public InterviewDto updateInterview(InterviewDto dto) {
        Interview interview = modelMapper.map(dto, Interview.class);
        interviewRepository.updateInterview(interview);
        return modelMapper.map(interview, InterviewDto.class);
    }

    public InterviewDto updateInterviewStatus(int id, String status) {
        Interview interview = interviewRepository.updateInterviewStatus(id, status);
        return modelMapper.map(interview, InterviewDto.class);
    }

    public void deleteInterview(int id) {
        interviewRepository.deleteInterview(id);
    }
}
