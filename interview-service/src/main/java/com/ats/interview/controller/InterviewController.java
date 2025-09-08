package com.ats.interview.controller;

import com.ats.interview.dto.InterviewDto;
import com.ats.interview.service.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public InterviewDto addInterview(@RequestBody InterviewDto dto) {
        return interviewService.addInterview(dto);
    }

    @GetMapping("/{id}")
    public InterviewDto getInterview(@PathVariable int id) {
        return interviewService.getInterviewById(id);
    }

    @GetMapping
    public List<InterviewDto> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @PutMapping("/{id}")
    public InterviewDto updateInterview(@PathVariable int id, @RequestBody InterviewDto dto) {
        dto.setInterviewId(id);
        return interviewService.updateInterview(dto);
    }

    @PutMapping("/{id}/status")
    public InterviewDto updateStatus(@PathVariable int id, @RequestParam String status) {
        return interviewService.updateInterviewStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable int id) {
        interviewService.deleteInterview(id);
    }
}
